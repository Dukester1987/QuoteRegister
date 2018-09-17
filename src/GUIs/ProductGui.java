/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIs;

import DO.AddressObject;
import DO.JobObject;
import DO.ObjectCollector;
import DO.ProductAllObject;
import DO.ProductObject;
import java.util.List;
import java.util.UUID;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.jdesktop.swingx.treetable.DefaultTreeTableModel;
import quoteregister.GuiIcon;
import quoteregister.TreeTableWrapper;

/**
 *
 * @author ldulka
 */
public class ProductGui extends javax.swing.JFrame {

    private TreeTableWrapper wrapper;
    private int[] selectedRows;
    private List<ProductObject> products;
    private ProductObject prod;
    private String Notes;
    private double vol;
    private String ID;
    private int type = 1;
    private int jobID = 0;
    private int selectedRow;
    private ProductAllObject myProduct;
    private boolean ongoingpr;
    private boolean direction;
    private AddressObject address;
    private boolean isChanging = false;
    private String jobSuffix;
    private JobObject job;

    /**
     * Creates new form ProductGui
     */
    public ProductGui() {
        startUP();        
    }  
    
    public ProductGui(TreeTableWrapper wrapper,int[] selectedRows, int type) {
        GuiIcon ico = new GuiIcon(this);
        this.selectedRows = selectedRows;
        this.wrapper = wrapper;
        this.type = type;
        startUP();     
    }          

    public ProductGui(TreeTableWrapper wrapper, JobObject job, int type) {
        GuiIcon ico = new GuiIcon(this);
        this.selectedRows = null;
        this.wrapper = wrapper;
        this.type = type;
        this.jobID = job.getJobID();
        this.jobSuffix = job.getSuffix();
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

        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        volume = new javax.swing.JTextField();
        product = new javax.swing.JComboBox<>();
        ongoing = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        insertor = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        notes = new javax.swing.JTextArea();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Street = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        GlobeID3 = new javax.swing.JTextField();
        Zip = new javax.swing.JTextField();
        State = new javax.swing.JComboBox<>();
        City = new javax.swing.JTextField();
        From = new javax.swing.JRadioButton();
        To = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("New Product Order");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Product details"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Volume:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));
        jPanel1.add(volume, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 95, -1));

        product.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productActionPerformed(evt);
            }
        });
        jPanel1.add(product, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 300, -1));

        ongoing.setText("Ongoing");
        ongoing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ongoingActionPerformed(evt);
            }
        });
        jPanel1.add(ongoing, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, -1, -1));

        jLabel3.setText("Product:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

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

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Notes"));

        notes.setColumns(20);
        notes.setRows(5);
        jScrollPane3.setViewportView(notes);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Address"));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setText("Street:");
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 36, -1, -1));

        Street.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                StreetKeyReleased(evt);
            }
        });
        jPanel6.add(Street, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 300, -1));

        jLabel10.setText("City:");
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel11.setText("State:");
        jPanel6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, -1, -1));

        jLabel12.setText("ZIP:");
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        GlobeID3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                GlobeID3KeyReleased(evt);
            }
        });
        jPanel6.add(GlobeID3, new org.netbeans.lib.awtextra.AbsoluteConstraints(499, 76, 95, -1));

        Zip.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ZipKeyReleased(evt);
            }
        });
        jPanel6.add(Zip, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 95, -1));

        State.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NSW", "VIC", "QLD", "WA", "SA", "TAS", "ACT", "NT" }));
        jPanel6.add(State, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, -1, -1));

        City.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CityKeyReleased(evt);
            }
        });
        jPanel6.add(City, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 95, -1));

        buttonGroup2.add(From);
        From.setText("From");
        jPanel6.add(From, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, -1));

        buttonGroup2.add(To);
        To.setSelected(true);
        To.setText("To");
        jPanel6.add(To, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(insertor))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
        try {
            prepareVariables();
            if(prepareNewJobObject(selectedRows)){
                if(wrapper.getOptionDialog("Do you want to add rate for this product", "Question")==JOptionPane.YES_OPTION){
                    wrapper.createNewTransportRate(myProduct);
                }
                wrapper.refreshTable();                    
                this.dispose();
            } else {
                wrapper.getInformationDialog("This product is already allocated to the job", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {            
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this,"Value has to be number","Warning",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_insertorActionPerformed

    private void ongoingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ongoingActionPerformed
        if(ongoing.isSelected()){
            volume.setEnabled(false);
            volume.setText("0.0");
        } else {
            volume.setEnabled(true);
        }
    }//GEN-LAST:event_ongoingActionPerformed

    private void StreetKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_StreetKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_StreetKeyReleased

    private void GlobeID3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GlobeID3KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_GlobeID3KeyReleased

    private void ZipKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ZipKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_ZipKeyReleased

    private void CityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CityKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_CityKeyReleased

    private void productActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productActionPerformed
        if(isChanging){
            System.out.println("changed");
            
            ProductObject selectedProduct = (ProductObject) product.getSelectedItem();
            
            if(selectedProduct.getAddrss()!=null){
                fillAddress(
                        selectedProduct.getAddrss().getStreet(),
                        selectedProduct.getAddrss().getCity(),
                        selectedProduct.getAddrss().getZip(),
                        selectedProduct.getAddrss().getState()                        
                );
            } else {
                fillAddress("", "", "", "");
            }
            
        }
    }//GEN-LAST:event_productActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField City;
    private javax.swing.JRadioButton From;
    private javax.swing.JTextField GlobeID3;
    private javax.swing.JComboBox<String> State;
    private javax.swing.JTextField Street;
    private javax.swing.JRadioButton To;
    private javax.swing.JTextField Zip;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton insertor;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea notes;
    private javax.swing.JCheckBox ongoing;
    private javax.swing.JComboBox<ProductObject> product;
    private javax.swing.JTextField volume;
    // End of variables declaration//GEN-END:variables

    private boolean prepareNewJobObject(int[] selectedRows) throws Exception{ 
        boolean success = false;
        if(myProduct==null){ // creating new
            if(selectedRows!=null){
                jobID=getJobID(selectedRows); 
                jobSuffix = getJobSuffix(selectedRows);
            }
            myProduct = new ProductAllObject(ID, jobID, jobSuffix, prod, vol, Notes, ongoingpr, direction, address);     
            if(checkExistingProduct(myProduct)){
                ObjectCollector.addProductRate(myProduct);
                myProduct.dbSave();       
                success = true;
                System.out.println("Creating new product");
            } else {
                myProduct = null;
            }
        } else { // update existing            
            myProduct.setProductAllObject(ID, jobID, jobSuffix, prod, vol, Notes, ongoingpr, direction, address);            
            if(checkExistingProduct(myProduct)){            
                myProduct.dbUpdate();           
                success = true;
                System.out.println("Editing product");
            }
        }
        return success;
    }

    private void startUP() {
        initComponents();
        initProductList();
        AutoCompleteDecorator.decorate(product);
        this.address = null;
        if(type==2){
            System.out.println("getting values");
            initValues();           
        }
        isChanging = true;
    }      

    private void initProductList() {
        products = ObjectCollector.getProducts();
        product.removeAllItems();
        for (ProductObject prod : products) {
            product.addItem(prod);
        }
    }

    private void prepareVariables() throws NumberFormatException{
        prod = (ProductObject) product.getSelectedItem();
        Notes = this.notes.getText();       
        vol = Double.parseDouble(volume.getText());            
        ID = myProduct==null?UUID.randomUUID().toString():myProduct.getID();     
        ongoingpr = ongoing.isSelected();
        if(address==null){
            address = createAddressObject();
        } else {
            address = editAddressObject(address);
        }        
        direction = prepareDirections();
    }

    private int getJobID(int[] selectedRows) {
        return (int) getValueFromTable(selectedRows[0], 1);        
    }
    
    private String getJobSuffix(int[] selectedRows) {
        try { 
            return (String) getValueFromTable(selectedRows[0], 20);        
        } catch(NullPointerException e){
            return "";
        }
    }    

    private Object getValueFromTable(int row,int column){        
        Object node = wrapper.getNodeFromRow(row);
        DefaultTreeTableModel model = wrapper.getModel();
        return model.getValueAt(node, column);       
    }
    
    private void initValues() {
        setTitle("Edit Product");
        insertor.setText("Edit");        
        myProduct = getProductByRow(selectedRows[0]);
        product.setSelectedItem(myProduct.getProduct());
        volume.setText(myProduct.getVolume().toString());
        notes.setText(myProduct.getNotes());
        jobID = myProduct.getJobID();       
        jobSuffix = myProduct.getSuffix();
        ongoing.setSelected(myProduct.isOngoing());
        setSelectedRadio(myProduct.isDirection());
        setAddress(myProduct.getAddress());
                
        if(myProduct.isOngoing())
            volume.setEnabled(false);
    }
    
    private ProductAllObject getProductByRow(int row){
        DefaultTreeTableModel model = wrapper.getModel();
        Object node = wrapper.getNodeFromRow(row);
        return ObjectCollector.getProductAllByID((String) model.getValueAt(node, 2));
    }

    private void setSelectedRadio(boolean direction) {
        if(direction){
            To.setSelected(true);
        } else {
            From.setSelected(true);
        }
    }

    private void setAddress(AddressObject address) {
        if(address != null){
            this.address = address;
            Street.setText(address.getStreet());
            City.setText(address.getCity());
            Zip.setText(address.getZip());
            State.setSelectedItem(address.getState());
        }
    }

    private AddressObject editAddressObject(AddressObject address) {
        address.setStreet(Street.getText());
        address.setCity(City.getText());
        address.setState(State.getSelectedItem().toString());
        address.setZip(Zip.getText());
        return address;
    }

    private AddressObject createAddressObject() {
        return new AddressObject(Street.getText(), City.getText(), Zip.getText(), State.getSelectedItem().toString());
    }

    private boolean prepareDirections() {
        return To.isSelected();
    }

    private void fillAddress(String street, String city, String zip, String state) {
        Street.setText(street);
        City.setText(city);
        Zip.setText(zip);
        State.setSelectedItem(state);
    }

    private boolean checkExistingProduct(ProductAllObject myProduct) {        
        System.out.printf("checking existing product for job ID is %s and suffix is %s\n",myProduct.getJobID(),myProduct.getSuffix());
        List<ProductAllObject> prods = ObjectCollector.getProductAllByJobID(myProduct.getJobID(), myProduct.getSuffix());
        for (ProductAllObject prd : prods) {
            if(prd.getProduct().getCODE().equals(myProduct.getProduct().getCODE())){
                if(!prd.getID().equals(myProduct.getID())){
                    System.out.println(prd.getProduct().getCODE()+" / "+myProduct.getProduct().getCODE());
                    return false;
                }
            }
        }
        return true;
    }
}
