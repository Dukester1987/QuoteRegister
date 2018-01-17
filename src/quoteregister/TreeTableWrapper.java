/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quoteregister;

import DBO.dbInit;
import DO.JobObject;
import DO.ObjectCollector;
import DO.ProductAllObject;
import DO.TransportRateObject;
import Functions.Functions;
import GUIs.ClientGui;
import GUIs.JobGui;
import GUIs.ProductGui;
import GUIs.RateGui;
import GUIs.addProductGui;
import Table.ChildNode;
import Table.Node;
import Table.RootNode;
import Table.TreeTableModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.tree.TreePath;
import localDB.LocalWraper;
import org.jdesktop.swingx.JXTreeTable;
import org.jdesktop.swingx.treetable.DefaultTreeTableModel;
import org.jdesktop.swingx.treetable.MutableTreeTableNode;
import org.jdesktop.swingx.treetable.TreeTableNode;

/**
 *
 * @author ldulka
 */
public class TreeTableWrapper {
   
    private String[] headings = {"ID", "jobID", "RateID", "TransID", "Status", "Verbal Quote", "Date", "Start Date", "End Date", "Client", "Delivery","Contact Details","Product Code","Volume", "Delivery Type", "Total Price ex GST", "Material Cost", "Transport Rate", "Special projects", "Comments"};    
    private Class<?>[] columnTypes = { String.class, Integer.class, String.class, String.class,String.class, String.class, Date.class, Date.class, Date.class, String.class, String.class, String.class, String.class, Double.class, String.class, Double.class, Double.class, Double.class, Double.class, String.class};
    private Node root;
    private TreeTableModel model;
    private JXTreeTable table = null;
    private List<String[]> content;    
    private LocalWraper db;
    private JobGui njGui = null;
    private ProductGui prGui;
    private RateGui rateGui;
    private ClientGui clGui;
    private JobGui ejGui;
    private ProductGui epGui;
    private RateGui erGui;
    private static String activeFilter = "Filter - All Jobs";
    private static String textFilter = "";
    private addProductGui aProdGui;
    private String productFilter = "";
    private String rateFilter = "";
    
    
    public TreeTableWrapper(){               
        
        //model.setColumnClass(columnTypes);
        model = new TreeTableModel(CreateNodes(getContent()), Arrays.asList(headings),columnTypes);             
                        
    }

    TreeTableWrapper(LocalWraper db) {
        model = new TreeTableModel(CreateNodes(getContent()), Arrays.asList(headings),columnTypes);   
        this.db = db;
    }
    
    
    
    private Node CreateNodes(List<Object[]> content) {
        root = new RootNode("root");
//        ChildNode Material = null;
//        ChildNode Transport = null;
//        
//        for (Object[] data : content){
//            ChildNode child = new ChildNode(data);
//            if(data.length <= 1){
//                root.add(child);
//                Material = child;
//            } else if(data.length <= 4) {
//                Material.add(child);
//                Transport = child;
//            } else {
//                Transport.add(child);
//            }
//        }    
        
        return root;
        
    }
    
    
    private List<Object[]> getContent() {
        List<Object[]> content = new ArrayList<>();
        
        return content;
    }    

    public DefaultTreeTableModel getModel() {  
        return model;
    }

    /**
     *
     * @param data
     * @param node
     */
    public void addNewNode(Object[] data,int action, int row) {     
        try {
        ChildNode myChild = new ChildNode(data);        
        switch (action){
            case 1:                
                model.insertNodeInto(myChild, root, 0);
                break;
            case 2:
                org.jdesktop.swingx.treetable.TreeTableModel treeModel = table.getTreeTableModel();
                model.setValueAt("Lukasek", getNodeFromRow(row), 4);
                System.out.println(model.getValueAt(getNodeFromRow(row), 4));
                break;
        }
        } catch (Exception e){
            System.out.println("error");
        }
    }
    
    public void removeAll(){ 
        try {
            int childCount = model.getChildCount(root); //get number of childs for root
            if(childCount>0){
                for (int i = 1; i <= childCount; i++) {
                    Object node = model.getChild(root, 0);
                    model.removeNodeFromParent((MutableTreeTableNode) node);
                }
            }  
        } catch(Exception e) {
            System.out.println(e.toString());
        }
    }
    
    public void setValueAt(Object value, int row, int column) {
        model.setValueAt(value,getNodeFromRow(row),column);
    }
    
    public void addNewNode(Object[] data, int[] nodeID) {           
        ChildNode myChild = new ChildNode(data);        
        model.insertNodeInto(myChild, getNodeFromSelectedRow(nodeID), 0);
        table.expandRow(nodeID[0]);        
    }    

    void setTable(JXTreeTable table) {
        this.table = table;
    }
    

    int getNodeLevel(int Row) {
        TreePath path = table.getPathForRow(Row);
        return path.getPathCount();
    }

    public void hideIDColumns() {
        table.removeColumn(table.getColumnModel().getColumn(1));
        table.removeColumn(table.getColumnModel().getColumn(1));
        table.removeColumn(table.getColumnModel().getColumn(1));
    }
   
    private ChildNode getNodeFromSelectedRow(int[] selectedRows) {
        if(selectedRows.length>=0){
            if(table!=null){
                TreePath path = table.getPathForRow(selectedRows[0]);
                return (ChildNode) path.getLastPathComponent();                                
            }            
        } 
        return (ChildNode) root;     
    }

    void expansionControll(int row) {
        try{
            if(table.isExpanded(row)){
                table.collapseRow(row);
            } else {
                table.expandRow(row);
            }
        } catch (Exception e){
            System.out.println("table is not set");
        }
    }

    public void editSelectedRow(int[] selectedRows) {
        int nodeLevel = getNodeLevel(selectedRows[0]);
        System.out.println(nodeLevel);
        
        switch(nodeLevel){
            case 2: //editing job            
                editJob(selectedRows[0]);
                break;
            case 3: //editing product
                editProduct(selectedRows);
                break;
            case 4: //editing rate
                editRate(selectedRows);
                break;
            default: // do nothing
                break;
        }
        
    }
    
    public void createNewJob() {          
        if(!Functions.isGuiShowing(njGui)){
            njGui = new JobGui(this);
            Functions.createModalGui(njGui);
        }
    }

    public void createNewProductRate(int[] selectedRows) {
        if(!Functions.isGuiShowing(prGui)){
            prGui = new ProductGui(this,selectedRows,1);
            Functions.createModalGui(prGui);            
        }
    }
    
    public void createNewPoductRate(JobObject job){
        if(!Functions.isGuiShowing(prGui)){
            prGui = new ProductGui(this,job,1);
            Functions.createModalGui(prGui);            
        }        
    }
    
    public void createNewTransportRate(int[] selectedRows) {
        if(!Functions.isGuiShowing(rateGui)){
            rateGui = new RateGui(this,selectedRows, 1);
            Functions.createModalGui(rateGui);
        }
    }       
    
    public void createNewTransportRate(ProductAllObject product) {
        if(!Functions.isGuiShowing(rateGui)){
            rateGui = new RateGui(this,product, 1);
            Functions.createModalGui(rateGui);
        }
    }     

    private void editJob(int selectedRow) {
        if(!Functions.isGuiShowing(ejGui)){
            ejGui = new JobGui(this, selectedRow);
            Functions.createModalGui(ejGui);
        }
    }

    private void editProduct(int[] selectedRow) {
        if(!Functions.isGuiShowing(epGui)){
            epGui = new ProductGui(this,selectedRow,2);
            Functions.createModalGui(epGui);
        }
    }

    private void editRate(int[] selectedRow) {
        if(!Functions.isGuiShowing(erGui)){
            erGui = new RateGui(this,selectedRow,2);
            Functions.createModalGui(erGui);
        }
    }

    public Object getNodeFromRow(int row) {
        TreePath path = table.getPathForRow(row);        
        return path.getLastPathComponent();
    }

    public JXTreeTable getTable() {
        return table;
    }

    void showClients() {
        if(!Functions.isGuiShowing(clGui)){
            clGui = new ClientGui();
            Functions.createGui(clGui);
        }
    }
    
    public void refreshDatabaseModel(){
        ObjectCollector.cleanCollections();
        dbInit init = new dbInit(db);
        refreshTable();
    }
    
    public void refreshTable() {
        System.err.println("REFRESHING TABLE");
        removeAll();
        
        try {
            List<JobObject> jobs = getJobsApplyingFilter();
            for (JobObject job : jobs) {
                ChildNode jobNode = new ChildNode(job.getTreeTableObject());
                model.insertNodeInto(jobNode, root, 0);                        

                List<ProductAllObject> products = ObjectCollector.getProductAllByJobID(job.getJobID());
                for (ProductAllObject product : products) {
                    ChildNode productNode = new ChildNode(product.getTableObject());
                    model.insertNodeInto(productNode, jobNode, 0);

                    List<TransportRateObject> transRates = ObjectCollector.getTransportRateByProductID(product.getID());
                    for (TransportRateObject transRate : transRates) {
                        ChildNode transNode = new ChildNode(transRate.getTableObject());
                        model.insertNodeInto(transNode, productNode, 0);
                    }
                }
            }   
            table.expandAll();
        } catch(Exception e) {
            System.out.println(e.toString());
        }               
    }

    void setSelectedFilter(String filterText) {
        activeFilter = filterText;      
        refreshTable();
    }
    
    private List<JobObject> getJobsApplyingFilter() {   
        
        List<JobObject> jobs = null;              
        
        if(activeFilter.equalsIgnoreCase("Filter - All Jobs")){ //no filter set
            jobs = ObjectCollector.getJobs();
        } else {
            jobs = ObjectCollector.getJobsByStatus(activeFilter);
        }  
                
        if(textFilter.isEmpty() && productFilter.isEmpty() && rateFilter.isEmpty()){
            return jobs;            
        } else {
            jobs = filterJobObject(jobs, textFilter);
            if(!productFilter.isEmpty()){
                jobs = filterProductObject(jobs);
            }
            
            return jobs;
        }         
    }    

    void removeSelectedRow(int[] selectedRows) {
        int nodeLevel = getNodeLevel(selectedRows[0]);
        //System.out.println(nodeLevel);
        
        switch(nodeLevel){
            case 2: //deleting job            
                deleteJob(selectedRows[0]);
                //JOptionPane.showMessageDialog(null,"Can't remove jobs yet");
                break;
            case 3: //deleting product
                deleteProduct(selectedRows[0]);
                break;
            case 4: //deleting rate
                deleteRate(selectedRows[0]);
                break;
            default: // do nothing
                break;
        }    
        refreshTable();
    }
    
    public int getOptionDialog(Object text, String title){
        return JOptionPane.showOptionDialog(null
                ,text
                ,title
                ,JOptionPane.YES_NO_OPTION
                ,JOptionPane.WARNING_MESSAGE
                ,null
                ,null
                ,null);  
    }
    
    private void deleteJob(int selectedRow) {
        JobObject job = getJobByRow(selectedRow);
        List<ProductAllObject> allocatedProducts = ObjectCollector.getProductAllByJobID(job.getJobID());
        
        String text = "Are you sure you want to delete selected Row?\nAll data will be permanently lost";
        String title = "Question";
        
        if(getOptionDialog(text, title) == JOptionPane.YES_OPTION){
            
            if(!allocatedProducts.isEmpty()){
                for (ProductAllObject allocatedProduct : allocatedProducts){                                        
                    deleteProduct(allocatedProduct);                    
                }
            }
            
            if(ObjectCollector.getJobs().remove(job)){
                job.dbDelete();
            }
            
        }
        
    }
    
    private void deleteProduct(ProductAllObject product){        
        List<TransportRateObject> transportRates = ObjectCollector.getTransportRateByProductID(product.getID());   
        String text = "Are you sure you want to delete selected Row?\nAll data will be permanently lost";
        String title = "Question";
                
        if(getOptionDialog(text, title) == JOptionPane.YES_OPTION){
        
            if(!transportRates.isEmpty()){             
                for (TransportRateObject transportRate : transportRates) {
                    transportRate.dbDelete();
                    ObjectCollector.getTransportRates().remove(transportRate);
                }
            }

            if(ObjectCollector.getProductRates().remove(product)){
                product.dbDelete();            
            }          
        }        
    }

    private void deleteProduct(int selectedRow) {
        ProductAllObject product = getProductByRow(selectedRow);
        deleteProduct(product);
    }

    private void deleteRate(int selectedRow) {
        String text = "Are you sure you want to delete selected Row?\nAll data will be permanently lost";
        String title = "Question";
        if(getOptionDialog(text, title)==JOptionPane.YES_OPTION){
            TransportRateObject rate = getRateByRow(selectedRow);
            if(ObjectCollector.getTransportRates().remove(rate)){
                rate.dbDelete();
            }   
        }
    }
    
    private JobObject getJobByRow(int row){
        Object node = getNodeFromRow(row);
        return ObjectCollector.getJobByID((int) model.getValueAt(node, 1));
    }
    
    private ProductAllObject getProductByRow(int row){        
        Object node = getNodeFromRow(row);
        return ObjectCollector.getProductAllByID((String) model.getValueAt(node, 2));
    }    
    
    private TransportRateObject getRateByRow(int row){        
        Object node = getNodeFromRow(row);
        return ObjectCollector.getTransportRateByID((String) model.getValueAt(node, 3));
    }        

    void filterByJob(String text) {
        textFilter = text;
        refreshTable();
    }
    
    void filterByProduct(String text) {
        productFilter = text;
        refreshTable();
    }

    void filterByRate(String text) {
        rateFilter = text;
        refreshTable();
    }    

    private List<JobObject> filterJobObject(List<JobObject> jobs, String textFilter) {      
        List<JobObject> thisJob = jobs.stream().collect(Collectors.toList());
        int startSize = thisJob.size();
        for (int i = thisJob.size()-1;i>=0;i--) {
            if(!thisJob.get(i).search(textFilter)){
               thisJob.remove(thisJob.get(i));
            }
        }
        System.out.println("original batch size: "+ startSize +" | filtered batch size: "+thisJob.size());
        return thisJob;
    }
    
    private List<JobObject> filterProductObject(List<JobObject> jobs) {
        for(int i = jobs.size()-1;i>=0;i--){
            boolean removeJob = true;
            List<ProductAllObject> AllProducts = ObjectCollector.getProductAllByJobID(jobs.get(i).getJobID());
            for (ProductAllObject AllProduct : AllProducts) {
                if(AllProduct.search(productFilter)){
                    removeJob = false;
                }
            }
            if(removeJob){
                jobs.remove(jobs.get(i));
            }
        }   
        return jobs;
    }    

    void addNewProduct(Gui aThis) {
        if(!Functions.isGuiShowing(aProdGui)){
            aProdGui = new addProductGui(this);
            Functions.createModalGui(aProdGui);
        }        
    }

    public void getInformationDialog(String message, String title, int msgType) {
        JOptionPane.showMessageDialog(null,message, title, msgType);        
    }
    
}


