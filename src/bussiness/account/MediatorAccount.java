/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bussiness.account;

import persistence.Serializacion;

/**
 *
 * @author user
 */
public class MediatorAccount {
    public static boolean withdraw(float amount, String type, String id){
        boolean success = false;
        Account[] ac = Serializacion.readAccount(type);
        for(Account account : ac){
            if(account.idAccount.equals(id)){
                account.withdraw(amount, type);
                account.addOperation(amount, "withdrawal");
                success = true;
            }
        }
        return success;
    }
    
    public static boolean consign(float amount, String type, String id){
        boolean success = false;
        Account[] ac = Serializacion.readAccount(type);
        for(Account account : ac){
            if(account.idAccount.equals(id)){
                account.consign(amount, type);
                account.addOperation(amount, "consignment");
                success = true;
            }
        }
        return success;
    }
    
    public static boolean deactivate(String type, String id){
        boolean success = false;
        Account[] ac = Serializacion.readAccount(type);
        for(Account account : ac){
            if(account.idAccount.equals(id)){
                account.withdraw(type);
                account.deactivate(type);
                account.addOperation(0, "deactivation");
                success = true;
            }
        }
        return success;
    }
}
