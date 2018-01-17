/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIs;

import DO.ObjectCollector;
import DO.ProductAllObject;
import DO.TransportRateObject;
import DO.TruckGroupObject;
import Table.ChildNode;
import java.awt.Color;
import java.util.List;
import java.util.UUID;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.jdesktop.swingx.treetable.DefaultTreeTableModel;
import quoteregister.GuiIcon;
import quoteregister.TreeTableWrapper;

/**
 *
 * @author ldulka
 */
public class RateGui extends javax.swing.JFrame {

    private TreeTableWrapper wrapper;
    private int[] selectedRows;
    private int type;
    private TransportRateObject rate;
    private List<TruckGroupObject> truckGroups;
    private String ProductID = null;
    private ProductAllObject product;

    /**
     * Creates new form RateGui
     */
    public RateGui() {        
        initComponents();
    }
    
    public RateGui(TreeTableWrapper wrapper, int[] selectedRows, int type) {                
        this.wrapper = wrapper;
        this.selectedRows = selectedRows;
        this.type = type;
        startUP();

    }

    public RateGui(TreeTableWrapper wrapper, ProductAllObject product, int type) {
        this.wrapper = wrapper;        
        this.product = product;
        this.ProductID = product.getID();
        this.type = type;
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        DelType = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        insertor = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        maCost = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        transRate = new javax.swing.JTextField();
        totPrice = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        specProject = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        notes = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("New rate");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Delivery details"));

        jLabel1.setText("Delivery type:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DelType, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(DelType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Exit16.png"))); // NOI18N
        jButton2.setText("Close");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        insertor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/ok16.png"))); // NOI18N
        insertor.setText("Insert");
        insertor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertorActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Rates"));

        jLabel3.setText("Material cost:");

        maCost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                maCostKeyReleased(evt);
            }
        });

        jLabel5.setText("Transport rate:");

        transRate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                transRateKeyReleased(evt);
            }
        });

        totPrice.setEnabled(false);

        jLabel6.setText("Total price Ex GST:");

        jLabel7.setText("Special project:");

        specProject.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                specProjectKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(totPrice))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(maCost, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(transRate, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(specProject, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(maCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(transRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(specProject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(totPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Notes"));

        notes.setColumns(20);
        notes.setRows(5);
        jScrollPane1.setViewportView(notes);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(insertor))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(insertor)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void insertorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertorActionPerformed
        if(prepareNewJobObject()) {
            wrapper.refreshTable();        
            this.dispose();
            if(wrapper.getOptionDialog("Do you want to create another rate?", "Question")==JOptionPane.YES_OPTION){
                System.out.println("clicked yes");
                if(product==null){
                    product = ObjectCollector.getProductAllByID(ProductID);                           
                }
                System.out.println(ProductID);
                System.out.println(product);
                wrapper.createNewTransportRate(product);
            }
        } else {
            wrapper.getInformationDialog("This product already have rate for selected truck group", "error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_insertorActionPerformed

    private void transRateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_transRateKeyReleased
        sumCount();
    }//GEN-LAST:event_transRateKeyReleased

    private void maCostKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_maCostKeyReleased
        sumCount();
    }//GEN-LAST:event_maCostKeyReleased

    private void specProjectKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_specProjectKeyReleased
        sumCount();
    }//GEN-LAST:event_specProjectKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<TruckGroupObject> DelType;
    private javax.swing.JButton insertor;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField maCost;
    private javax.swing.JTextArea notes;
    private javax.swing.JTextField specProject;
    private javax.swing.JTextField totPrice;
    private javax.swing.JTextField transRate;
    // End of variables declaration//GEN-END:variables

    private void sumCount() {
        Double tot = checkNumValidity(maCost)+checkNumValidity(transRate)+checkNumValidity(specProject);
        totPrice.setText(""+tot);
        
    }

    private boolean prepareNewJobObject() {   
        boolean success = true; //expecting succesful operation
        TruckGroupObject prod = (TruckGroupObject) DelType.getSelectedItem();
        Double materialCost = checkNumValidity(maCost);
        Double transport = checkNumValidity(transRate);
        Double specialProject = checkNumValidity(specProject);
        Double totalPrice = checkNumValidity(totPrice);
        String notes = this.notes.getText();        
        ProductID = ProductID==null?getProductID():ProductID;
        if(rate!=null){
            String ID = rate.getID();
            if(checkExistingRate(rate)){
                rate.setTransportRateObject(ProductID, ID, prod, materialCost, transport, specialProject, notes);
                rate.dbUpdate();
            } else {
                success = false;
            }
        } else {
            String ID = UUID.randomUUID().toString();
            rate = new TransportRateObject(ProductID, ID, prod, materialCost, transport, specialProject, notes);   
            if(checkExistingRate(rate)){
                ObjectCollector.addTransportRate(rate);
                rate.dbSave();
            } else {
                rate = null;
                success = false;
            }
        }
        
        return success;
                       
    }
    

    private Double checkNumValidity(JTextField field) {        
        String txt = field.getText().equals("")?"0":field.getText();        
        try {
            double num = Double.parseDouble(txt);
            field.setForeground(Color.BLACK);
            return num;
        } catch(Exception e) {
            field.setForeground(Color.RED);
            return 0D;
        }        
    }

    private void startUP() {
        GuiIcon guiIcon = new GuiIcon(this);
        initComponents();        
        initValues();        
    }

    private void initValues() {
        truckGroups = ObjectCollector.getTruckGroups();
        DelType.removeAllItems();
        for (TruckGroupObject truck : truckGroups) {
            DelType.addItem(truck);
        }
        if(type==2)
            editValues();        
    }

    private TransportRateObject getRateBySelection() {
        int row = selectedRows[0];        
        DefaultTreeTableModel model = wrapper.getModel();
        Object node = wrapper.getNodeFromRow(row);
        String RateID = (String) model.getValueAt(node, 3);
        System.out.println(RateID);
        return ObjectCollector.getTransportRateByID(RateID);                        
    }

    private void editValues() {
        insertor.setText("Edit");
        setTitle("Edit rate");
        
        rate = getRateBySelection();
        DelType.setSelectedItem(rate.getTruckGroupObject());   
        maCost.setText(rate.getMaterialCost().toString());
        transRate.setText(rate.getTransportRate().toString());
        specProject.setText(rate.getSpecialProject().toString());
        notes.setText(rate.getNotes());
        ProductID = rate.getProductID();
        
        sumCount();
        
    }

    private String getProductID() {
        int row = selectedRows[0];        
        DefaultTreeTableModel model = wrapper.getModel();
        Object node = wrapper.getNodeFromRow(row);        
        return (String) model.getValueAt(node, 2);
    }

    private boolean checkExistingRate(TransportRateObject rate) {
        List<TransportRateObject> rates = ObjectCollector.getTransportRateByProductID(rate.getProductID());
        for (TransportRateObject r : rates) {
            if(r.getTruckGroupObject().getGroupName().equals(rate.getTruckGroupObject().getGroupName())){
                if(!r.getID().equals(rate.getID())){
                    return false;
                }
            }
        }
        return true;
    }
}
