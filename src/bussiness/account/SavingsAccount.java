/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bussiness.account;


/**
 *
 * @author user
 */
public class SavingsAccount extends Account{
    
    public SavingsAccount(String idAccount, String idOwner, float balance, String branchOffice) {
        this.idAccount = idAccount;
        this.idOwner = idOwner;
        this.balance = balance;
        this.isActive = true;
        this.branchOffice = branchOffice;
        this.interest = (float)0.02;
    }
}
