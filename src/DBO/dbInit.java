/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBO;

import DO.AWSAddressObject;
import DO.AddressObject;
import DO.ClientObject;
import DO.ContactObject;
import DO.JobObject;
import DO.ObjectCollector;
import DO.ProductAllObject;
import DO.ProductObject;
import DO.TransportRateObject;
import DO.TruckGroupObject;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import localDB.LocalWraper;

/**
 *
 * @author ldulka
 */
public class dbInit {

    LocalWraper db;

    public dbInit(LocalWraper db) {
        this.db = db;
        db.userData.setDate(new Date(System.currentTimeMillis()));
        
        addCollections();
        
    }

    private void addCollections() {
        createAddreses();
        createProducts();
        createTruckGroups();
        createTransportRates();
        createContacts();
        createClients();
        createUsers();
        createJobs();
        createJobProducts();        
    }
    
    private void createAddreses() {
        ResultSet pr = db.dbSelect("AWS_ADDRESS");
        try {
            say("INIT AWS_ADDRESS table");
            while(pr.next()) {
                AWSAddressObject address = new AWSAddressObject(
                        pr.getString("ID"),
                        pr.getString("Name"),
                        pr.getString("Street"),
                        pr.getString("City"),
                        pr.getString("ZIP"),
                        pr.getString("State"));
                ObjectCollector.addAWSAddress(address);
            }
            say("---- DONE ----");
        } catch (SQLException ex) {
            say("---- ERROR ----");
            Logger.getLogger(dbInit.class.getName()).log(Level.SEVERE, null, ex);            
        }
    }

    private void createProducts() {                
        ResultSet pr = db.dbSelect("AWS_Products");
        try {
            say("init AWS_PRODUCTS table");
            while(pr.next()){
                
                AWSAddressObject addresss = ObjectCollector.getAWSAddressByID(pr.getString("Address"));
                
                ProductObject product = new ProductObject(                     
                        pr.getString("CODE"),
                        pr.getString("NAME"),
                        addresss,
                        pr.getBoolean("Direction"));
                ObjectCollector.addProduct(product);                
            }
            //System.out.println(ObjectCollector.getAWSAddresses().size());
            say("---- DONE ----");
        } catch (SQLException ex) {
            say("---- ERROR ----");
            Logger.getLogger(dbInit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void createTruckGroups() {
        ResultSet pr = db.dbSelect("QR_TruckGroups");
        try {
            say("init TruckGroups table");
            while(pr.next()){
                TruckGroupObject tgO = new TruckGroupObject(pr.getInt("ID")
                        ,pr.getString("GroupName"));
                ObjectCollector.addTruckToGroup(tgO);                
            }
            say("---- DONE ----");
        } catch (SQLException ex) {
            say("---- ERROR ----");
            Logger.getLogger(dbInit.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    private void createTransportRates() {
        ResultSet pr = db.dbSelect("QR_TransportRate");
        try {
            say("init QR_TransportRate table");
            while(pr.next()){
                TransportRateObject tgO = new TransportRateObject(pr.getString("ProductAllID")
                        ,pr.getString("ID")
                        ,ObjectCollector.getTruckGroupByID(pr.getInt("TruckGroupID"))                        
                        ,pr.getDouble("MaterialCost")
                        ,pr.getDouble("TransportRate")
                        ,pr.getDouble("SpecialProject")
                        ,pr.getString("Notes"));
                ObjectCollector.addTransportRate(tgO);                
            }
            say("---- DONE ----");
        } catch (SQLException ex) {
            say("---- ERROR ----");
            Logger.getLogger(dbInit.class.getName()).log(Level.SEVERE, null, ex);
        }   
    } 
    
    private void createContacts() {
        ResultSet pr = db.dbSelect("QR_Contacts");
        try {
            say("init QR_Contacts table");
            while(pr.next()){
                ContactObject tgO = new ContactObject(pr.getInt("ID")
                        ,pr.getInt("ClientID")
                        ,pr.getString("Name")
                        ,pr.getString("LastName")
                        ,pr.getString("email")
                        ,pr.getString("phone"));
                ObjectCollector.addContactObject(tgO);                
            }
            say("---- DONE ----");
        } catch (SQLException ex) {
            say("---- ERROR ----");
            Logger.getLogger(dbInit.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }     
    
    private void createClients() {
        ResultSet pr = db.dbSelect("QR_Clients");
        try {
            say("init QR_Clients table");
            while(pr.next()){
                ClientObject tgO = new ClientObject(pr.getInt("ID")
                        ,pr.getString("GlobeID")
                        ,pr.getString("ClientName"));
                ObjectCollector.addClientObject(tgO);                
            }
            say("---- DONE ----");
        } catch (SQLException ex) {
            say("---- ERROR ----");
            Logger.getLogger(dbInit.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }   
    
    private void createUsers(){
         ResultSet rs = db.dbSelect("Login");
        try {
            say("init Login table");
            while(rs.next()){
                User tgO = new User(rs.getInt("ID"), rs.getString("LoginName"), rs.getString("Password"), rs.getString("Rights"), rs.getInt("Status"), rs.getTimestamp("LastUpload"), rs.getTimestamp("LastDownload"), rs.getString("Name"), rs.getString("LastName"));
                ObjectCollector.addUser(tgO);                
            }
            say("---- DONE ----");
        } catch (SQLException ex) {
            say("---- ERROR ----");
            Logger.getLogger(dbInit.class.getName()).log(Level.SEVERE, null, ex);
        }                  
    }

    private void createJobs(){
        ResultSet pr = db.dbSelect("QR_Jobs");
        try {
            say("init QR_Jobs table");
            int i = 1;
            while(pr.next()){
                AddressObject Delivery = new AddressObject(pr.getString("Street"), pr.getString("City"),pr.getString("ZIP"),pr.getString("State"));       
                
                ClientObject client = null;
                ContactObject contact = null;

                client = ObjectCollector.getClientByID(pr.getInt("ClientID"));               
                contact = ObjectCollector.getContactByID(pr.getInt("ContactID"));          
                
                JobObject tgO = new JobObject(pr.getInt("ID")
                        ,ObjectCollector.getUserByID(pr.getInt("UserID"))
                        ,pr.getString("QuoteType")
                        ,pr.getString("Status")
                        ,pr.getDate("DateQuoted")
                        ,pr.getDate("StartDate")
                        ,pr.getDate("EndDate")
                        ,client
                        ,contact
                        ,Delivery
                        ,pr.getString("Notes")
                        ,pr.getString("WANID"));
                ObjectCollector.addJob(tgO);
            }
            say("---- DONE ----");
        } catch (SQLException ex) {
            say("---- ERROR ----");
            Logger.getLogger(dbInit.class.getName()).log(Level.SEVERE, null, ex);
        }          
    }
    
    private void createJobProducts(){
         ResultSet rs = db.dbSelect("QR_JobProducts");
        try {
            say("init QR_JobProducts table");
            while(rs.next()){
                AddressObject address = new AddressObject(rs.getString("Street"), rs.getString("City"), rs.getString("ZIP"), rs.getString("State"));
                
                ProductAllObject tgO = new ProductAllObject(rs.getString("ID"),
                        rs.getInt("JobID"), 
                        ObjectCollector.getProductByID(rs.getString("ProductID")), 
                        rs.getDouble("Volume"), 
                        rs.getString("Notes"),
                        rs.getBoolean("Ongoing"),
                        rs.getBoolean("Direction"),
                        address);
                ObjectCollector.addProductRate(tgO);                
            }
            say("---- DONE ----");
        } catch (Exception ex) {
            say("---- ERROR ----");
            ex.printStackTrace();
            Logger.getLogger(dbInit.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }    

    private void say(String text) {
        System.out.println(text);
    }
    
    
}
