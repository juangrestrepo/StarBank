/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bussiness;

import bussiness.client.NaturalPerson;
import bussiness.client.Client;
import bussiness.client.Company;
import bussiness.account.SavingsAccount;
import bussiness.account.Account;
import bussiness.account.CurrentAccount;
import persistence.Serializacion;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class Cashier {

    public Cashier() {
    }
    
    //Añade una persona natural
    public void addNaturalPerson(String id,String name,String phone,String address,String occupation){
        Client[] cliente = Serializacion.readClient("naturalPerson");
        NaturalPerson naturalPerson = new NaturalPerson(id,name,phone,address,occupation);
        
        if(cliente != null){
            for(Client nat : cliente){
                if(nat.getId().equals(naturalPerson.getId())){
                    JOptionPane.showMessageDialog(null, "Ya existe un usuario con esa ID", "Error", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
        }
        
        Serializacion.createFile(cliente,naturalPerson,"naturalPerson");
        JOptionPane.showMessageDialog(null, "Usuario agregado satisfactoriamente", "Éxito", JOptionPane.WARNING_MESSAGE);
    }
    
    //Añade una compañía
    public void addCompany(String id,String name,String phone,String address,String occupation,String compName, String nit, String commercialSection){
        Client[] cliente = Serializacion.readClient("company");
        Company company = new Company(id, name, phone, address, occupation, compName, nit, commercialSection);
        if(cliente != null){
            for(Client nat : cliente){
                if(nat.getId().equals(company.getId())){
                    JOptionPane.showMessageDialog(null, "Ya existe un usuario con esa ID", "Error", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
        }
        Serializacion.createFile(cliente,company,"company");
        JOptionPane.showMessageDialog(null, "Usuario agregado satisfactoriamente", "Éxito", JOptionPane.WARNING_MESSAGE);
    }
    
    //Añade una cuenta de ahorros
    public void addSavingsAccount(String idAccount, String idOwner, float balance, String typeOwner){
        boolean transaccionValida = false;
        Account[] cuentas = Serializacion.readAccount("savingsAccount");
        SavingsAccount account = new SavingsAccount(idAccount, idOwner, balance, BranchOffice.getInstance().getName());
        if(!Account.verifyAccount(cuentas,account)){
            JOptionPane.showMessageDialog(null, "Ya existe una cuenta con esa ID", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Client[] client = Serializacion.readClient(typeOwner);
        if(!Client.verifyClient(client, idOwner,typeOwner)){
            JOptionPane.showMessageDialog(null, "La ID del dueño no es válida", "Error", JOptionPane.WARNING_MESSAGE);
        }else{
            Serializacion.createFile(cuentas,account,"savingsAccount");
            JOptionPane.showMessageDialog(null, "Cuenta de ahorros creada satisfactoriamente", "Éxito", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    //Añade una cuenta corriente
    public void addCurrentAccount(String idAccount, String idOwner, float balance, String typeOwner){
        boolean transaccionValida = false;
        Account[] cuentas = Serializacion.readAccount("currentAccount");
        CurrentAccount account = new CurrentAccount(idAccount, idOwner, balance, BranchOffice.getInstance().getName());
        if(!Account.verifyAccount(cuentas,account)){
            JOptionPane.showMessageDialog(null, "Ya existe una cuenta con esa ID", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Client[] client = Serializacion.readClient(typeOwner);
        if(!Client.verifyClient(client, idOwner,typeOwner)){
            JOptionPane.showMessageDialog(null, "La ID del dueño no es válida", "Error", JOptionPane.WARNING_MESSAGE);
        }else{
            Serializacion.createFile(cuentas,account,"currentAccount");
            JOptionPane.showMessageDialog(null, "Cuenta corriente creada satisfactoriamente", "Éxito", JOptionPane.WARNING_MESSAGE);
        }
    }

}
