/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import persistence.Serializacion;
import javax.swing.JOptionPane;
import bussiness.account.MediatorAccount;

/**
 *
 * @author user
 */
public class WithdrawalForm extends javax.swing.JFrame {
    private String id;
    private float amount;
    private String type;
    /**
     * Creates new form WithdrawalForm
     */
    public WithdrawalForm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        savingsAccount = new javax.swing.JRadioButton();
        currentAccount = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        idTextBox = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        submitBtn = new javax.swing.JButton();
        amountTextBox = new javax.swing.JTextField();
        consignBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Consignación y Retiro de dinero");

        savingsAccount.setText("Ahorros");
        savingsAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savingsAccountActionPerformed(evt);
            }
        });

        currentAccount.setText("Corriente");

        jLabel2.setText("Número de cuenta:");

        jLabel3.setText("Monto:");

        submitBtn.setText("Retirar");
        submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });

        consignBtn.setText("Consignar");
        consignBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consignBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(savingsAccount)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(currentAccount))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(consignBtn)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(idTextBox)
                                    .addComponent(amountTextBox)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                .addComponent(submitBtn)
                                .addGap(16, 16, 16)))))
                .addGap(25, 25, 25))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(savingsAccount)
                    .addComponent(currentAccount))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(idTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(amountTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitBtn)
                    .addComponent(consignBtn))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void savingsAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savingsAccountActionPerformed
        
        
    }//GEN-LAST:event_savingsAccountActionPerformed

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed
        id = idTextBox.getText();
        if(id.equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "Por favor llene todos los campos", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {  
            amount = Float.parseFloat(amountTextBox.getText());
            if(amount%10000 != 0){
                JOptionPane.showMessageDialog(null, "El monto debe ser múltiplo de 10000", "Error", JOptionPane.WARNING_MESSAGE);
                return;
            }if(amount < 20000){
                JOptionPane.showMessageDialog(null, "El monto debe mayor a 20000", "Error", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch(NumberFormatException e){  
            JOptionPane.showMessageDialog(null, "Monto no válido", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(currentAccount.isSelected()){
            type = "currentAccount";
        }else{
            type = "savingsAccount";
        }
        if(!MediatorAccount.withdraw(amount, type, id)){
            JOptionPane.showMessageDialog(null, "Cuenta no válida", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
    }//GEN-LAST:event_submitBtnActionPerformed

    private void consignBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consignBtnActionPerformed
        id = idTextBox.getText();
        if(id.equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "Por favor llene todos los campos", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {  
            amount = Float.parseFloat(amountTextBox.getText());  
        } catch(NumberFormatException e){  
            JOptionPane.showMessageDialog(null, "Monto no válido", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(currentAccount.isSelected()){
            type = "currentAccount";
        }else{
            type = "savingsAccount";
        }
        if(!MediatorAccount.consign(amount, type, id)){
            JOptionPane.showMessageDialog(null, "Cuenta no válida", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
    }//GEN-LAST:event_consignBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(WithdrawalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WithdrawalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WithdrawalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WithdrawalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WithdrawalForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amountTextBox;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton consignBtn;
    private javax.swing.JRadioButton currentAccount;
    private javax.swing.JTextField idTextBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton savingsAccount;
    private javax.swing.JButton submitBtn;
    // End of variables declaration//GEN-END:variables
}
