/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quoteregister;

import DBO.dbInit;
import DO.ObjectCollector;
import Functions.FileLogger;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFileChooser;
import localDB.LocalWraper;
import org.jdesktop.swingx.decorator.HighlighterFactory;
import org.jdesktop.swingx.prompt.PromptSupport;
import org.jdesktop.swingx.treetable.DefaultTreeTableModel;
import remoteDB.DBWrapper;

/**
 *
 * @author ldulka
 */
public class Gui extends javax.swing.JFrame {

    public static boolean isSyncNeeded = true;
    public static boolean isAnyChangesApplicable = false;
    public static int jobID = 10000;    

    public static int getNextID() {
        return jobID++;
    }

    private DefaultTreeTableModel model;
    private TreeTableWrapper wrapper;    
    public static LocalWraper db;
    private ObjectCollector oc;
    private DBWrapper db1;
    private Thread t;

    /**
     * Creates new form Gui
     */
    public Gui() {        
        startUP();               
    }

    Gui(LocalWraper db) {
        this.db = db;
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

        popupMenu = new javax.swing.JPopupMenu();
        newJob = new javax.swing.JMenuItem();
        newRate = new javax.swing.JMenuItem();
        newTransRate = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        editRow = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        packColumns = new javax.swing.JMenuItem();
        deleteSeparator = new javax.swing.JPopupMenu.Separator();
        deleteSelectedItem = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        QuoteRegisterTable = new org.jdesktop.swingx.JXTreeTable(model);
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        addRate = new javax.swing.JButton();
        TransRate = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jobFilter = new javax.swing.JTextField();
        sync = new javax.swing.JButton();
        productFilter = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        newMenuJob = new javax.swing.JMenuItem();
        menuNewRate = new javax.swing.JMenuItem();
        menuNewTransRate = new javax.swing.JMenuItem();
        newProduct = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();

        newJob.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        newJob.setText("New Job");
        newJob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newJobActionPerformed(evt);
            }
        });
        popupMenu.add(newJob);

        newRate.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        newRate.setText("New Product");
        newRate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newRateActionPerformed(evt);
            }
        });
        popupMenu.add(newRate);

        newTransRate.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        newTransRate.setText("New Rate");
        newTransRate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newTransRateActionPerformed(evt);
            }
        });
        popupMenu.add(newTransRate);
        popupMenu.add(jSeparator1);

        editRow.setMnemonic('p');
        editRow.setText("Edit");
        editRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editRowActionPerformed(evt);
            }
        });
        popupMenu.add(editRow);
        popupMenu.add(jSeparator2);

        packColumns.setMnemonic('p');
        packColumns.setText("Pack Columns");
        packColumns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                packColumnsActionPerformed(evt);
            }
        });
        popupMenu.add(packColumns);
        popupMenu.add(deleteSeparator);

        deleteSelectedItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/No-entry16.png"))); // NOI18N
        deleteSelectedItem.setText("Remove selected");
        deleteSelectedItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteSelectedItemActionPerformed(evt);
            }
        });
        popupMenu.add(deleteSelectedItem);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quote Register v1.0");
        setLocationByPlatform(true);

        QuoteRegisterTable.setAutoCreateRowSorter(true);
        QuoteRegisterTable.setClosedIcon(null);
        QuoteRegisterTable.setSortable(true);
        QuoteRegisterTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                QuoteRegisterTableMouseReleased(evt);
            }
        });
        QuoteRegisterTable.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                QuoteRegisterTableValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(QuoteRegisterTable);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Filter - All Jobs", "Recieved", "Approved", "Waiting for answer", "Canceled", "WON" }));
        jComboBox1.setToolTipText("");
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Add.png"))); // NOI18N
        jButton1.setText("New Job");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Up.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Down.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        addRate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Dollar.png"))); // NOI18N
        addRate.setText("New Product");
        addRate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRateActionPerformed(evt);
            }
        });

        TransRate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Delivery.png"))); // NOI18N
        TransRate.setText("New Rate");
        TransRate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TransRateActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/People.png"))); // NOI18N
        jButton4.setText("Clients");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Table.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel2.setText("Status: Ready");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        jobFilter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jobFilterKeyReleased(evt);
            }
        });

        sync.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Refresh.png"))); // NOI18N
        sync.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                syncActionPerformed(evt);
            }
        });

        productFilter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                productFilterKeyReleased(evt);
            }
        });

        jMenu1.setText("File");

        jMenuItem2.setText("Create CHL Record from File");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Settings");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        newMenuJob.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        newMenuJob.setText("New Job");
        newMenuJob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newMenuJobActionPerformed(evt);
            }
        });
        jMenu2.add(newMenuJob);

        menuNewRate.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        menuNewRate.setText("New Product");
        menuNewRate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNewRateActionPerformed(evt);
            }
        });
        jMenu2.add(menuNewRate);

        menuNewTransRate.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menuNewTransRate.setText("New Rate");
        menuNewTransRate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNewTransRateActionPerformed(evt);
            }
        });
        jMenu2.add(menuNewTransRate);

        newProduct.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        newProduct.setText("New Product");
        newProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newProductActionPerformed(evt);
            }
        });
        jMenu2.add(newProduct);
        jMenu2.add(jSeparator3);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("New Cient");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sync)
                        .addGap(15, 15, 15)
                        .addComponent(jobFilter, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(productFilter, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                        .addGap(24, 24, 24)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TransRate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addRate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sync, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)
                        .addComponent(jButton2)
                        .addComponent(jButton3)
                        .addComponent(addRate)
                        .addComponent(TransRate)
                        .addComponent(jButton4)
                        .addComponent(jButton5)
                        .addComponent(jobFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(productFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        wrapper.setSelectedFilter(jComboBox1.getSelectedItem().toString());
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        wrapper.createNewJob();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        QuoteRegisterTable.collapseAll();        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        QuoteRegisterTable.expandAll();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void QuoteRegisterTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_QuoteRegisterTableMouseReleased
        int Row = QuoteRegisterTable.rowAtPoint(evt.getPoint());
            try {                                     
                if(evt.isPopupTrigger()){                   
                    QuoteRegisterTable.setRowSelectionInterval(Row, Row);
                    popupMenu.show(QuoteRegisterTable, evt.getX(), evt.getY());
                } else if(evt.getClickCount()==2) {
                    wrapper.expansionControll(Row);
                }
            } catch(Exception e){
                System.err.println("No rows available");
            }        
    }//GEN-LAST:event_QuoteRegisterTableMouseReleased

    private void addRateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRateActionPerformed
        wrapper.createNewProductRate(QuoteRegisterTable.getSelectedRows());        
    }//GEN-LAST:event_addRateActionPerformed

    private void TransRateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TransRateActionPerformed
        wrapper.createNewTransportRate(QuoteRegisterTable.getSelectedRows());
    }//GEN-LAST:event_TransRateActionPerformed

    private void QuoteRegisterTableValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_QuoteRegisterTableValueChanged
        try{    
            buttonController(wrapper.getNodeLevel(QuoteRegisterTable.getSelectedRow()));     
        }catch(Exception e){
            
        }
            
    }//GEN-LAST:event_QuoteRegisterTableValueChanged

    private void newJobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newJobActionPerformed
        wrapper.createNewJob();        
    }//GEN-LAST:event_newJobActionPerformed

    private void newRateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newRateActionPerformed
        wrapper.createNewProductRate(QuoteRegisterTable.getSelectedRows());
    }//GEN-LAST:event_newRateActionPerformed

    private void newTransRateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newTransRateActionPerformed
        wrapper.createNewTransportRate(QuoteRegisterTable.getSelectedRows());
    }//GEN-LAST:event_newTransRateActionPerformed

    private void newMenuJobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newMenuJobActionPerformed
        wrapper.createNewJob();
    }//GEN-LAST:event_newMenuJobActionPerformed

    private void menuNewRateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNewRateActionPerformed
        wrapper.createNewProductRate(QuoteRegisterTable.getSelectedRows());
    }//GEN-LAST:event_menuNewRateActionPerformed

    private void menuNewTransRateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNewTransRateActionPerformed
        wrapper.createNewTransportRate(QuoteRegisterTable.getSelectedRows());
    }//GEN-LAST:event_menuNewTransRateActionPerformed

    private void packColumnsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_packColumnsActionPerformed
        QuoteRegisterTable.packAll();
    }//GEN-LAST:event_packColumnsActionPerformed

    private void editRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editRowActionPerformed
        wrapper.editSelectedRow(QuoteRegisterTable.getSelectedRows());
    }//GEN-LAST:event_editRowActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        wrapper.showClients();        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        QuoteRegisterTable.packAll();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void deleteSelectedItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteSelectedItemActionPerformed
        wrapper.removeSelectedRow(QuoteRegisterTable.getSelectedRows());
    }//GEN-LAST:event_deleteSelectedItemActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        installFromFile();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed

    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jobFilterKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jobFilterKeyReleased
        //Filter is utilised
        wrapper.filterByJob(jobFilter.getText());
    }//GEN-LAST:event_jobFilterKeyReleased

    private void syncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_syncActionPerformed
        t.interrupt();
    }//GEN-LAST:event_syncActionPerformed

    private void newProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newProductActionPerformed
        wrapper.addNewProduct(this);
    }//GEN-LAST:event_newProductActionPerformed

    private void productFilterKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_productFilterKeyReleased
        wrapper.filterByProduct(productFilter.getText());
    }//GEN-LAST:event_productFilterKeyReleased

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public org.jdesktop.swingx.JXTreeTable QuoteRegisterTable;
    private javax.swing.JButton TransRate;
    private javax.swing.JButton addRate;
    private javax.swing.JMenuItem deleteSelectedItem;
    private javax.swing.JPopupMenu.Separator deleteSeparator;
    private javax.swing.JMenuItem editRow;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JTextField jobFilter;
    private javax.swing.JMenuItem menuNewRate;
    private javax.swing.JMenuItem menuNewTransRate;
    private javax.swing.JMenuItem newJob;
    private javax.swing.JMenuItem newMenuJob;
    private javax.swing.JMenuItem newProduct;
    private javax.swing.JMenuItem newRate;
    private javax.swing.JMenuItem newTransRate;
    private javax.swing.JMenuItem packColumns;
    private javax.swing.JPopupMenu popupMenu;
    private javax.swing.JTextField productFilter;
    private javax.swing.JButton sync;
    // End of variables declaration//GEN-END:variables

    private void buttonController(int nodeLevel) {
        if(nodeLevel<2){
            //menu            
            setRateEnabled(false);
            setTransRateEnabled(false);
        } else {
            if(nodeLevel>2){
                setRateEnabled(false);
            } else {
                setRateEnabled(true);
            }  
            if(nodeLevel==3){
                setTransRateEnabled(true);
            } else {
                setTransRateEnabled(false);
            }
        }
    }

    public void refreshLists() {
        wrapper.refreshTable();
    }
    
    public void refreshDB(){
        wrapper.refreshDatabaseModel();
    }
    
    public static LocalWraper getDB(){
        return db;
    }

    private void startUP() {               
        
        oc = new ObjectCollector();
        wrapper = new TreeTableWrapper(db);   
        model = wrapper.getModel();     
        GuiIcon GuiIcon = new GuiIcon(this);
        initComponents();
        
        PromptSupport.setPrompt("type to filter jobs", jobFilter);
        PromptSupport.setPrompt("type to filter products", productFilter);        
        
        setMinimumSize(getSize());
        
        buttonController(0);
        initDBO();
        
        wrapper.setTable(QuoteRegisterTable);
        wrapper.hideIDColumns();
        
        refreshLists();
                
        QuoteRegisterTable.setHighlighters(HighlighterFactory.createSimpleStriping());        
        QuoteRegisterTable.setShowGrid(true,true);
        QuoteRegisterTable.setColumnControlVisible(true);                
        QuoteRegisterTable.setEditable(true);
        QuoteRegisterTable.packAll();        
        
        rightClickOptions();
        
        db1 = new DBWrapper(jLabel2,db,this);
        t = new Thread(db1);
        t.start();        
        
    }

    private void setTransRateEnabled(boolean b) {
        TransRate.setEnabled(b);
        newTransRate.setEnabled(b);
        menuNewTransRate.setEnabled(b);
    }

    private void setRateEnabled(boolean b) {
        addRate.setEnabled(b);
        newRate.setEnabled(b);
        menuNewRate.setEnabled(b);
    }

    private void initDBO() {
        dbInit dbInit = new dbInit(db);
    }

    private void rightClickOptions() {
        deleteSeparator.setVisible(false);
        deleteSelectedItem.setVisible(false);
        if(db.userData.hasRights("admin", "SalesDel")){
            deleteSeparator.setVisible(true);
            deleteSelectedItem.setVisible(true);            
        }
    }

    private void installFromFile() {
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Select File you want to upload from");
        
        int result = fc.showOpenDialog(null);
        File file = fc.getSelectedFile();
        
        //file selected
        if(result == JFileChooser.APPROVE_OPTION){
            grabFileAndRunInstall(file);
        }
        
    }

    private void grabFileAndRunInstall(File f) {
        if(f.exists()){ 
            try {          
                String query = "";
                BufferedReader bf = new BufferedReader(new FileReader(f));
                String s;
                Statement st = db.con.createStatement();
                int i=0;
                boolean newBatch = false;                
                while ((s = bf.readLine())!=null){
                    i++;
                    String operation = "";
                    if(s.startsWith("INSERT") || s.startsWith("CREATE") || s.startsWith("ALTER")){
                        if(s.startsWith("INSERT")){
                            operation = "insert";
                        }
                        newBatch = true;
                    }
                    if(newBatch){
                        if(s.trim().endsWith(";")){
                            query += s+"\n";
                            db.changeLog(getTable(s), getID(s), operation, s, db.userData.getId());
                            newBatch = false;
                            st.addBatch(query);
                            query = "";
                        } else {
                            query += s+"\n";
                        }                         
                    }
                   
                }                
                st.executeBatch();
                bf.close();
                //delete file
                //f.renameTo(new File("./inc/DBCreate-DONE.sql"));
                new FileLogger("Database Sucessfully initialised");
            } catch (FileNotFoundException ex) {                
                ex.printStackTrace();
                new FileLogger(ex.toString());
            } catch (IOException ex) {
                ex.printStackTrace();
                new FileLogger(ex.toString());
            } catch (SQLException ex) {
                ex.printStackTrace();
                new FileLogger(ex.toString());
            }            
        }        
    }
    
    private String getTable(String data){
        return data.substring(data.indexOf("INTO")+5,data.indexOf(" ("));
    }
    
    private String getID(String data){
        String firstSubString = data.substring(data.indexOf("VALUES(")+7);
        String result = firstSubString.substring(0, firstSubString.indexOf(", "));
        if(result.startsWith("'")){
            return result.substring(1, result.length()-1);
        }
        return result;
    }
    
    
}
