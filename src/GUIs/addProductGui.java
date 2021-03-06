/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIs;

import DO.AWSAddressObject;
import DO.ObjectCollector;
import DO.ProductObject;
import java.util.List;
import javax.swing.JCheckBox;
import quoteregister.GuiIcon;
import quoteregister.TreeTableWrapper;

/**
 *
 * @author ldulka
 */
public class addProductGui extends javax.swing.JFrame {

    private boolean addAddressToDB;
    private boolean directions;
    private String selectedAddrID;
    private AWSAddressObject selectedAddr;
    private ProductObject AWSProduct;

    /**
     * Creates new form addProductGui
     */
    public addProductGui() {
        initComponents();
        initFunctions();
    }

    public addProductGui(TreeTableWrapper aThis) {
        initComponents();
        initFunctions();
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
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        AddressSelect = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        insertor = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ProductName = new javax.swing.JTextField();
        ProductCode = new javax.swing.JTextField();
        addAddr = new javax.swing.JCheckBox();
        jPanel8 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        From1 = new javax.swing.JRadioButton();
        To1 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Product");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Select Address"));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 36, -1, -1));

        jPanel6.add(AddressSelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 370, -1));

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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Product details"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Product Name:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jLabel3.setText("Product Code:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        ProductName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ProductNameKeyReleased(evt);
            }
        });
        jPanel1.add(ProductName, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 250, -1));

        ProductCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ProductCodeKeyReleased(evt);
            }
        });
        jPanel1.add(ProductCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 110, -1));

        addAddr.setText("Add Default Address");
        addAddr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAddrActionPerformed(evt);
            }
        });

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Direction"));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel8.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 36, -1, -1));

        buttonGroup1.add(From1);
        From1.setText("From");
        jPanel8.add(From1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        buttonGroup1.add(To1);
        To1.setSelected(true);
        To1.setText("To");
        jPanel8.add(To1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(insertor))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addAddr)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addAddr)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        insertProduct();
    }//GEN-LAST:event_insertorActionPerformed

    private void ProductNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ProductNameKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_ProductNameKeyReleased

    private void ProductCodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ProductCodeKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_ProductCodeKeyReleased

    private void addAddrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAddrActionPerformed
        setAddress(addAddr);
    }//GEN-LAST:event_addAddrActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<AWSAddressObject> AddressSelect;
    private javax.swing.JRadioButton From1;
    private javax.swing.JTextField ProductCode;
    private javax.swing.JTextField ProductName;
    private javax.swing.JRadioButton To1;
    private javax.swing.JCheckBox addAddr;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton insertor;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    // End of variables declaration//GEN-END:variables

    private void initFunctions() {
        initAddresses();
        setAddress(addAddr);
        GuiIcon ico = new GuiIcon(this);
        
    }

    private void setAddress(JCheckBox addAddr) {
        addAddressToDB = addAddr.isSelected();
        To1.setEnabled(addAddressToDB);
        From1.setEnabled(addAddressToDB);
        AddressSelect.setEnabled(addAddressToDB);
    }

    private void initAddresses() {
        List<AWSAddressObject> Addresses = ObjectCollector.getAWSAddresses();
        for (AWSAddressObject Address : Addresses) {
            System.out.println(Address.getID()+" "+Address.getStreet());
            AddressSelect.addItem(Address);
        }
    }

    private void insertProduct() {
        //Is address copming                
        if(addAddressToDB){
            directions = To1.isSelected();
            selectedAddr = (AWSAddressObject) AddressSelect.getSelectedItem();            
        }
        
        AWSProduct = new ProductObject(ProductCode.getText(), ProductName.getText(), selectedAddr, directions);
        ObjectCollector.addProduct(AWSProduct);
        AWSProduct.dbSave();          
        this.dispose();
    }
}
