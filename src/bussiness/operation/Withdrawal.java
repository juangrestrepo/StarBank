/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bussiness.operation;

import bussiness.BranchOffice;
import java.util.Date;

/**
 *
 * @author user
 */
public class Withdrawal extends Operation{
    private float value;

    public Withdrawal(float value, String idAccount) {
        this.value = value;
        this.idAccount = idAccount;
        this.date = new Date();
        this.branchOffice = BranchOffice.getInstance().getName();
    }
}
