/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.btssnir;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author infcb
 */
public class IHMPanel extends javax.swing.JPanel {

    FileNameExtensionFilter pdf;
    String namepdf;
    public String pathpdf;
    public String pathdest;
    public String nomfichier;
    boolean fichierjoint = false;
    boolean fichierjoint2 = false;
    gestion gest ;
    
    public IHMPanel() {
        initComponents();
        gest = new gestion(this);
        Fraction_button.setEnabled(false);
        destination_button.setEnabled(false);
        nom_fichier_dest.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        nom_pdf = new javax.swing.JLabel();
        Fraction_button = new javax.swing.JButton();
        destination_button = new javax.swing.JButton();
        nom_destination = new javax.swing.JLabel();
        nom_fichier_dest = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setText("choisir un pdf");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        nom_pdf.setText("           ");

        Fraction_button.setText("Fractionner");
        Fraction_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Fraction_buttonActionPerformed(evt);
            }
        });

        destination_button.setText("Choisir une destination");
        destination_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                destination_buttonActionPerformed(evt);
            }
        });

        nom_destination.setText("            ");

        nom_fichier_dest.setText("Entrer un nom de fichier à donner");
        nom_fichier_dest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nom_fichier_destActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(nom_pdf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(destination_button)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nom_destination, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                        .addComponent(Fraction_button, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(nom_fichier_dest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(163, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(31, 31, 31)
                .addComponent(nom_pdf)
                .addGap(31, 31, 31)
                .addComponent(destination_button)
                .addGap(31, 31, 31)
                .addComponent(nom_destination)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(nom_fichier_dest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(Fraction_button)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        pdf = new FileNameExtensionFilter("PDF","pdf");
        JFileChooser chooser = new JFileChooser(); 
        chooser.setCurrentDirectory(new File("/"));
        chooser.setDialogTitle("Choisir un pdf"); 
        chooser.changeToParentDirectory(); 
        chooser.setFileFilter(pdf);
        int retour = chooser.showOpenDialog(null);
        
        if (retour == JFileChooser.APPROVE_OPTION) {
        
        namepdf = chooser.getSelectedFile().getName();
        pathpdf = chooser.getSelectedFile().getAbsolutePath();
        
        
        System.out.println(pathpdf);
       nom_pdf.setText(namepdf);
       fichierjoint = true;
       destination_button.setEnabled(true);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void Fraction_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Fraction_buttonActionPerformed
        Fraction_button.setEnabled(false);
        destination_button.setEnabled(false);
        nom_destination.setText("");
        nom_pdf.setText("");
        nomfichier = nom_fichier_dest.getText();
        nom_fichier_dest.setText("Entrer un nom de fichier à donner");
        nom_fichier_dest.setEnabled(false);
        gest.split();
        
        
            javax.swing.JOptionPane.showMessageDialog(null, "OK");
        
    }//GEN-LAST:event_Fraction_buttonActionPerformed

    private void destination_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_destination_buttonActionPerformed
        JFileChooser destchoose = new JFileChooser();        
        destchoose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        destchoose.setCurrentDirectory(new File("/"));        
        destchoose.setDialogTitle("Choisir une destination"); 
        destchoose.changeToParentDirectory(); 
        int retour = destchoose.showOpenDialog(null);
        
        if (retour == JFileChooser.APPROVE_OPTION) {
        
        
        pathdest = destchoose.getSelectedFile().getAbsolutePath();
        
        
        System.out.println(pathdest);
       nom_destination.setText(pathdest);
       fichierjoint2 = true;
       Fraction_button.setEnabled(true);
       nom_fichier_dest.setText(namepdf);
       nom_fichier_dest.setEnabled(true);
        }
        
        
        
    }//GEN-LAST:event_destination_buttonActionPerformed

    private void nom_fichier_destActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nom_fichier_destActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nom_fichier_destActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Fraction_button;
    private javax.swing.JButton destination_button;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel nom_destination;
    private javax.swing.JTextField nom_fichier_dest;
    private javax.swing.JLabel nom_pdf;
    // End of variables declaration//GEN-END:variables
}
