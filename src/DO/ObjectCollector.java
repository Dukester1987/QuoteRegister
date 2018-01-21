/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DO;

import DBO.User;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import localDB.LocalWraper;

/**
 *
 * @author ldulka
 */
public class ObjectCollector {
    
    private static List<ClientObject> clients;
    private static List<ContactObject> contacts;
    private static List<JobObject> jobs;
    private static List<ProductObject> products;
    private static List<ProductAllObject> productRates;
    private static List<TransportRateObject> transportRate;
    private static List<TruckGroupObject> truckGroups;
    private static List<User> users;
    private static List<AWSAddressObject> AWSAddress;
    private static ArrayList<JobIDChange> JobIDChanges;

    public static void cleanCollections(){
        clients.clear();
        contacts.clear();
        jobs.clear();
        products.clear();
        productRates.clear();
        transportRate.clear();
        truckGroups.clear();
        users.clear();
        JobIDChanges.clear();
    }
    
    public static List<User> getUsers(){
        return users;
    }
    
    public static List<User> getUsersForList(){
        return users.stream()
                .filter(p -> p.hasRights("admin", "Sales"))
                .collect(Collectors.toList());
    }    
    
    public static void addUser(User u){
        users.add(u);
    }
    
    public static User getUserByID(int ID){
        List<User> uu = users.stream()
                .filter(u -> u.getId() == ID)
                .collect(Collectors.toList());
        return uu.get(0);
    }
    
    public static List<TruckGroupObject> getTruckGroups(){
        return truckGroups;
    }
    
    public static TruckGroupObject getTruckGroupByID(int ID){
        List<TruckGroupObject> filtered = truckGroups.stream()
                .filter(p -> p.getID() == ID)
                .collect(Collectors.toList());
        return filtered.get(0);        
    }
    
    public static void addTruckToGroup(TruckGroupObject truck){
        truckGroups.add(truck);
    }
    
    public static void setTruckGroups(List<TruckGroupObject> trucks){
        truckGroups = trucks;
    }
    
    public static List<ContactObject> getContactsForClient(int selectedClientID) {
        List<ContactObject> filteredContacts = contacts.stream()
                .filter(p -> p.getClientID() == selectedClientID)
                .collect(Collectors.toList());
        return filteredContacts;
    }    
    
    public static void addProduct(ProductObject product) {
        products.add(product);
    }
    
    public static ProductObject getProductByID(String ID) {
        List<ProductObject> list = products.stream()
                .filter(p -> p.getCODE().equalsIgnoreCase(ID))
                .collect(Collectors.toList());             
        return list.get(0);
    }
    
    public static List<ProductObject> getProducts(){
        products.sort(Comparator.comparing(ProductObject::getCODE));
        return products;  
    }    

    public static void addProductRate(ProductAllObject pao) {
        productRates.add(pao);
    }
    
    public static List<ProductAllObject> getProductRates(){
        return productRates;
    }

    public static ProductAllObject getProductAllByID(String ID) {
        List<ProductAllObject> result = productRates.stream()
                .filter(item -> item.getID()==ID)
                .collect(Collectors.toList());
        return result.get(0);
    }    
    
    public static List<ProductAllObject> getProductAllByJobID(int ID) {
        List<ProductAllObject> result = productRates.stream()
                .filter(item -> item.getJobID()==ID)
                .collect(Collectors.toList());
        return result;
    }        

    public static List<JobObject> getJobsByStatus(String activeFilter) {
        List<JobObject> result = jobs.stream()
                .filter(item -> item.getStatus().equalsIgnoreCase(activeFilter))
                .collect(Collectors.toList());
        return result;
    }

    public static int getNextJobID() {
        String year = getYear();
        String defaultID = year+"0000";
        try{            
            String id = Integer.toString(jobs.get(jobs.size()-1).getJobID()+1);
            if(id.substring(0, 2).equals(year)){
                return Integer.parseInt(id);
            } else {
                return Integer.parseInt(defaultID);
            }
        } catch(IndexOutOfBoundsException E){
            return Integer.parseInt(defaultID);
        }
    }

    private static String getYear() {
        DateFormat df = new SimpleDateFormat("yy");        
        return df.format(Calendar.getInstance().getTime());        
    }

    public static List<AWSAddressObject> getAWSAddresses() {
        return AWSAddress;
    }

    public static void addJobIDChange(JobIDChange jic) {
        JobIDChanges.add(jic);
    }
    
    public static List<JobIDChange> getJobIDChanges(){
        return JobIDChanges;
    }
    
    public static int getNextIDForJobIDChanges(){        
        try{
            return JobIDChanges.get(JobIDChanges.size()-1).getID()+1;            
        } catch (IndexOutOfBoundsException e) {
            return 1;
        }
    }
    
    private LocalWraper db;

    public ObjectCollector(LocalWraper db){
        listInit();
        this.db = db;
    }
    
    public ObjectCollector(){
        listInit();
    }
    
    private void listInit(){
        clients = new ArrayList<>();                
        contacts = new ArrayList<>();
        jobs = new ArrayList<>();
        products = new ArrayList<>();
        productRates = new ArrayList<>();
        transportRate = new ArrayList<>();
        truckGroups = new ArrayList<>();        
        users = new ArrayList<>();    
        AWSAddress = new ArrayList<>();
        JobIDChanges = new ArrayList<>();
    }
    
    //TRANSPORT RATE
    public static List<TransportRateObject> getTransportRates() {
        return transportRate;
    }
    
    public static void setTransportRates(List<TransportRateObject> rates) {
        transportRate = rates;
    }
    
    public static void addTransportRate(TransportRateObject tr){
        transportRate.add(tr);
    }
    
    public static TransportRateObject getTransportRateByID(String ID){
        List<TransportRateObject> result = transportRate.stream()
                .filter(item -> item.getID().equals(ID))
                .collect(Collectors.toList());
        return result.get(0);        
    }
    
    public static List<TransportRateObject> getTransportRateByProductID(String ID){
        List<TransportRateObject> result = transportRate.stream()
                .filter(item -> item.getProductID().equals(ID))
                .collect(Collectors.toList());
        return result;        
    }    
    
    public static AWSAddressObject getAWSAddressByID(String ID) {
        try {
            List<AWSAddressObject> result = AWSAddress.stream()
                    .filter(item -> item.getID().equals(ID))
                    .collect(Collectors.toList());
            return result.get(0);
        } catch(Exception e) {
            //System.err.println(e.getMessage());
            return null;
        }
    }    

    public static List<ClientObject> getClients() {
        if(clients != null)
            clients.sort(Comparator.comparing(ClientObject::getClientName));
        return clients;
    }
    
    public static void addClientObject(ClientObject co) {
        clients.add(co);
    }

    public static void setClients(List<ClientObject> aClients) {
        clients = aClients;
    }

    public static List<ContactObject> getContacts() {
        if(contacts != null)
            contacts.sort(Comparator.comparing(ContactObject::getID));
        return contacts;
    }
    
    public static void addContactObject(ContactObject co){
        contacts.add(co);
    }
    
    public static ContactObject getContactByID(int contactID){
        try {
            List<ContactObject> co = contacts.stream()
                    .filter(item -> item.getID()==contactID)
                    .collect(Collectors.toList());
            return co.get(0);
        } catch(Exception e) {
            System.err.println("CANT FIND CONTACT ID "+ contactID);
            //e.printStackTrace();
            return null;
        }
    }
        

    public static void setContacts(List<ContactObject> aContacts) {
        contacts = aContacts;
    }    
    
    public static ClientObject getClientByID(int clientID) {
        try {
            List<ClientObject> result = clients.stream()
                    .filter(item -> item.getID() == clientID)
                    .collect(Collectors.toList());
            return result.get(0);
        } catch(Exception e) {
            System.err.println("CANT FIND CLIENT ID "+clientID);
            //e.printStackTrace();
            return null;
        }
    }
        

    public static List<JobObject> getJobs() {        
        return jobs;
    }

    public static void addJob(JobObject job) {
        ObjectCollector.jobs.add(job);
        sortJobs();
    }
    
    private static void sortJobs(){
        jobs.sort(Comparator.comparing(JobObject::getJobID));
    }
    
    public static JobObject getJobByID(int ID){
        try{
        List<JobObject> result = jobs.stream()
                .filter(item -> item.getJobID() == ID)
                .collect(Collectors.toList());
        return result.get(0);
        } catch(Exception e) {
            return null;
        }
    }
    
    public static void addAWSAddress(AWSAddressObject address) {
        ObjectCollector.AWSAddress.add(address);
    }
    
    
            
}
