/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bussiness.account;

import bussiness.client.Client;
import bussiness.operation.AccountDeactivation;
import bussiness.operation.Consignment;
import bussiness.operation.Operation;
import bussiness.operation.Withdrawal;
import persistence.Serializacion;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class Account {
    protected String idOwner;
    protected String idAccount;
    protected float balance;
    protected boolean isActive;
    protected String branchOffice;
    protected float interest;

    public String getIdAccount() {
        return idAccount;
    }

    public String getIdOwner() {
        return idOwner;
    }
    
    //Verifica que la cuenta tenga suficiente saldo para realizar el retiro de dinero
    public boolean verifyWithdrawal(float value){
        if(this.balance - value - this.interest*value < 10000){
            return false;
        }
        return true;
    }
    
    //Consigna a la sucursal el dinero resultante de los intereses por retirar dinero
    public Account[] sendCashToBank(float value){
        Account[] cuentas = Serializacion.readAccount("savingsAccount");
        for(Account nat : cuentas){
            if(nat.idAccount.equals("000")){
                nat.balance += value;
                Serializacion.createFile(cuentas, null, "savingsAccount");
                break; 
            }
        }
        return cuentas;
    }
    
    //Retira dinero de la cuenta
    public void withdraw(float value, String type){
        if(!verifyWithdrawal(value)){
            JOptionPane.showMessageDialog(null, "No tiene fondos suficientes", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        balance = balance - (value + value*interest);
        verifyWithdrawal(value*interest);
        Account[] cuentas = Serializacion.readAccount(type);
        if(cuentas == null){
            JOptionPane.showMessageDialog(null, "No hay cuentas en el sistemas", "Error", JOptionPane.WARNING_MESSAGE);
        }else{
            if(type.equalsIgnoreCase("savingsAccount")){
                cuentas = sendCashToBank(value*interest);
            }else{
                sendCashToBank(value*interest);
            }  
            for(Account account : cuentas){
                if(account.idAccount.equalsIgnoreCase(this.idAccount)){
                    account.balance = this.balance;
                }
            }
            Serializacion.createFile(cuentas, null, type);
            JOptionPane.showMessageDialog(null, "Retiro hecho satisfactoriamente", "Éxito", JOptionPane.WARNING_MESSAGE);
        }      
    }
    
    //Retiro de dinero especial realizado cuando se cierra la cuenta
    public void withdraw(String type){
        balance = 0;
        Account[] cuentas = Serializacion.readAccount(type);
        if(cuentas == null){
            JOptionPane.showMessageDialog(null, "No hay cuentas en el sistemas", "Error", JOptionPane.WARNING_MESSAGE);
        }else{
            for(Account account : cuentas){
                if(account.idAccount.equalsIgnoreCase(this.idAccount)){
                    account.balance = this.balance;
                }
            }
            Serializacion.createFile(cuentas, null, type);
            JOptionPane.showMessageDialog(null, "Retiro hecho satisfactoriamente", "Éxito", JOptionPane.WARNING_MESSAGE);
        }     
    }
    
    //Añade dinero a la cuenta
    public void consign(float value, String type){
        Account[] cuentas = Serializacion.readAccount(type);
        if(cuentas == null){
            JOptionPane.showMessageDialog(null, "No hay cuentas en el sistemas", "Error", JOptionPane.WARNING_MESSAGE);
        }else{
            for(Account nat : cuentas){
                if(nat.idAccount.equals(this.idAccount)){
                    nat.balance += value;
                    Serializacion.createFile(cuentas, null, type);
                    JOptionPane.showMessageDialog(null, "Depósito hecho satisfactoriamente", "Éxito", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
        }
    }
    
    //Crea el registro de una nueva operación
    public void addOperation(float value,String name){
        if(name.equalsIgnoreCase("Consignment")){
            Operation[] operations = Serializacion.readOperations("consignment");
            Consignment cons = new Consignment(value,this.idAccount);
            Serializacion.createFile(operations, cons,"consignment");
        }else if (name.equalsIgnoreCase("Withdrawal")){
            Operation[] operations = Serializacion.readOperations("withdrawal");
            Withdrawal with = new Withdrawal(value,this.idAccount);
            Serializacion.createFile(operations, with,"withdrawal");
        }else if (name.equalsIgnoreCase("Deactivation")){
            Operation[] operations = Serializacion.readOperations("deactivation");
            AccountDeactivation deac = new AccountDeactivation(this.idAccount);
            Serializacion.createFile(operations, deac,"deactivation");
        }
    }
    
    //Desactiva una cuenta
    public void deactivate(String tipo){
        boolean cambioRealizado = false;
        Account[] cuentas = Serializacion.readAccount(tipo);
        
        for(Account account : cuentas){
            if(account.idAccount.equals(this.idAccount)){
                account.isActive = false;
                cambioRealizado = true;
            }
        }
        if(cambioRealizado){
            Serializacion.createFile(cuentas, null, tipo);
        }else{
            JOptionPane.showMessageDialog(null, "La cuenta especificada no existe.", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public static boolean verifyAccount(Account[] cuentas, Account account){
        if(cuentas != null){
            for(Account nat : cuentas){
                if(nat.getIdAccount().equals(account.getIdAccount())){
                    return false;
                }
            }
        }
        return true;
    }
}
