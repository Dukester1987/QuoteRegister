/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIs;

import DO.ClientObject;
import DO.ObjectCollector;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import quoteregister.GuiIcon;

/**
 *
 * @author ldulka
 */
public class NewClientGui extends javax.swing.JFrame {

    private List<ClientObject> clients;
    private static ClientGui cg = null;
    private static JobGui jg = null;
    private int selectedRow = -1;
    private ClientObject co = null;

    /**
     * Creates new form NewClientGui
     */
    public NewClientGui(ClientGui cg) {
        this.cg = cg;
        startUP();
    }
    
    public NewClientGui(JobGui jg) {        
        this.jg = jg;        
        startUP();
    }    

    public NewClientGui(ClientGui cg, int selectedRow) {
        this.cg = cg;
        this.selectedRow = selectedRow;
        startUP();        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ClientName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        GlobeID = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Client details"));

        jLabel3.setText("Client Name:");

        ClientName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ClientNameKeyReleased(evt);
            }
        });

        jLabel5.setText("Globe ID:");

        GlobeID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                GlobeIDKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(ClientName, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(GlobeID, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ClientName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(GlobeID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Exit16.png"))); // NOI18N
        jButton2.setText("Close");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/ok16.png"))); // NOI18N
        jButton1.setText("Insert");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ClientNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ClientNameKeyReleased

    }//GEN-LAST:event_ClientNameKeyReleased

    private void GlobeIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GlobeIDKeyReleased

    }//GEN-LAST:event_GlobeIDKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            addNewClient();
            this.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Excepton", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ClientName;
    private javax.swing.JTextField GlobeID;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

    private void addNewClient() throws Exception {
        int id = getClientID()+1;
        if(ClientName.getText().isEmpty())
            throw new Exception("Client needs to be set");
        
        if(!checkClients(ClientName.getText()))
            throw new Exception("Client already exists in a database");
        
        if(co==null){
            co = new ClientObject(id, GlobeID.getText(), ClientName.getText());
            clients.add(co);
            co.dbSave();
        } else {
            co.createClientObject(co.getID(), GlobeID.getText(), ClientName.getText());
            co.dbUpdate();
        }        
        
        refreshTable(co);  
    }

    private int getClientID() {
        clients = ObjectCollector.getClients();
        clients.sort(Comparator.comparing(ClientObject::getID));
        if(clients.size()>0){
            return clients.get(clients.size()-1).getID();
        } else {
            return 0;
        }
    }   

    private void refreshTable(ClientObject co) {
        if(jg!=null)
            jg.refreshClientList(co);
        if(cg!=null)
            cg.refreshClientTable();      
    }

    private void startUP() {
        initComponents();
        setTitle("New Client");
        GuiIcon ico = new GuiIcon(this);        
        
        if(selectedRow>=0){
            setTitle("Edit Client");
            jButton1.setText("Edit");
            initValues();
        }
    }

    private void initValues() {
        DefaultTableModel model = (DefaultTableModel) cg.clientTable.getModel();
        int SelRow = cg.clientTable.convertRowIndexToModel(selectedRow);
        int ID = (int) model.getValueAt(selectedRow, 0);
        
        co = ObjectCollector.getClientByID(ID);
        
        ClientName.setText(co.getClientName());
        GlobeID.setText(co.getGlobeID());
        
    }

    private boolean checkClients(String client) {
        return clients.stream().noneMatch(p -> p.getClientName().equalsIgnoreCase(client));
    }
}
