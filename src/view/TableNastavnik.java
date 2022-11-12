/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import databaseRepository.DatabseConnection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Nastavnik;
import view.modelTable.TableModel;

/**
 *
 * @author PC
 */
public class TableNastavnik extends javax.swing.JPanel {

    /**
     * Creates new form TableNastavnik
     */
    public TableNastavnik() {
        initComponents();
        UbaciPodatkeUtabelu();

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
        tableNastavnici = new javax.swing.JTable();
        btnDetalji = new javax.swing.JButton();

        tableNastavnici.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableNastavnici);

        btnDetalji.setText("Detalji");
        btnDetalji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetaljiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnDetalji)
                        .addGap(12, 12, 12))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(btnDetalji)
                .addGap(7, 7, 7))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDetaljiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetaljiActionPerformed
            int index=tableNastavnici.getSelectedRow();
            TableModel modelNastavnici=(TableModel)tableNastavnici.getModel();
            List<Nastavnik> nastavnici=modelNastavnici.getAllNastavnici();
            Nastavnik nastavnik = null;
            if(nastavnici!=null){
                
                try {
                    nastavnik = nastavnici.get(index);
                } catch (Exception e) {
                    System.out.println("Greska! Nisi selektovao nista! Gde cec?!?");
                    JOptionPane.showMessageDialog(this,"Greska! Nisi selektovao nista! Gde cec?!?");
                    return;
                }
            } else{
                System.out.println("Doslo je do neke greske prikomm ucitavanja liste nastavnika");
            }
            JPanel panel=new JpanelDetaljiNastavnika(nastavnik);
            JDialog dialog=new JDialog(new Start(),true);
            dialog.add(panel);
            dialog.pack();
            dialog.setLocationRelativeTo(this);
            dialog.setVisible(true);
    }//GEN-LAST:event_btnDetaljiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetalji;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableNastavnici;
    // End of variables declaration//GEN-END:variables

    private void UbaciPodatkeUtabelu() {
            List<Nastavnik> nastavnici=new ArrayList<>();
            databaseRepository.DatabseConnection connection=new DatabseConnection();
            connection.Connect();
            nastavnici=connection.getAllNastavnik();
            TableModel model=new TableModel(nastavnici);
            tableNastavnici.setModel(model);
            connection.Disconnect();
    }
}
