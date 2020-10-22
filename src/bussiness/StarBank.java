/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bussiness;

import view.Welcome;

/**
 *
 * @author user
 */
public class StarBank {
    static public Cashier csh;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        csh = new Cashier();
        Welcome cuadro1 = new Welcome();
        cuadro1.setVisible(true);
    }
    
}
