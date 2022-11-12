/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import databaseRepository.DatabseConnection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Nastavnik;
import model.Zvanje;
import validacija.ValidirajPodatke;
import view.modelTable.TableModel;

/**
 *
 * @author PC
 */
public class JpanelDetaljiNastavnika extends javax.swing.JPanel {

    /**
     * Creates new form JpanelDetaljiNastavnika
     */
    public JpanelDetaljiNastavnika(Nastavnik nastavnik) {
        initComponents();
        PrepareWindow(nastavnik);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtableNastavnik = new javax.swing.JTable();
        btnObrisi = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnSacuvaj = new javax.swing.JButton();

        jtableNastavnik.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtableNastavnik);

        btnObrisi.setText("Obrisi");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        jButton1.setText("Omoguci izmene");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnSacuvaj.setText("Sacuvaj Izmene");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSacuvaj)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnObrisi)
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnObrisi)
                    .addComponent(jButton1)
                    .addComponent(btnSacuvaj))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        
        TableModel model=(TableModel)jtableNastavnik.getModel();
        Nastavnik nastavnik=(Nastavnik) model.getAllNastavnici().get(0);
        int result=JOptionPane.showConfirmDialog(this, "Da li ste sigurni da zelite da onrisete nastavnika");
        DatabseConnection connection=new DatabseConnection();
        List<Nastavnik> nastavnici1=new ArrayList<>();
        if(result==JOptionPane.YES_OPTION){
            connection.Connect();
            connection.izbrisiNastavnika(nastavnik);
            TableModel model1=new TableModel(nastavnici1);
            jtableNastavnik.setModel(model1);
        }else {
            return;
        }
        
        
        
    }//GEN-LAST:event_btnObrisiActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            jtableNastavnik.setEnabled(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
        TableModel model=(TableModel)jtableNastavnik.getModel();
        Nastavnik nastavnik=(Nastavnik) model.getAllNastavnici().get(0);
        String name=nastavnik.getName();
        String Lastname=nastavnik.getLastname();
        Zvanje zvanje=nastavnik.getZvanje();
        ValidirajPodatke validacija=new ValidirajPodatke();
        validacija.ValidirajPodatke(name, Lastname);
        
            
        
    }//GEN-LAST:event_btnSacuvajActionPerformed

    private void PrepareWindow(Nastavnik nastavnik) {
        List<Nastavnik> nastavnici=new ArrayList<>();
        nastavnici.add(nastavnik);
        TableModel model=new TableModel(nastavnici);
        jtableNastavnik.setModel(model);
        jtableNastavnik.setEnabled(false);
        

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtableNastavnik;
    // End of variables declaration//GEN-END:variables
}
