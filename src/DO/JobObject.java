/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DO;

import DBO.User;
import java.sql.Date;
import localDB.LocalWraper;
import quoteregister.Gui;

/**
 *
 * @author ldulka
 */
public class JobObject extends AbstractDatabaseObject{
    
    private int jobID;
    private User user;
    private String quote, status, notes;    
    private Date dateQuoted, startDate, endDate;    
    private ClientObject client;
    private ContactObject contact;
    private AddressObject address;
    private String WANID;    

    public JobObject(int jobID, User user, String quote, String status, Date dateQuoted, Date startDate, Date endDate, ClientObject client, ContactObject contact, AddressObject address, String notes, String WANID) {
        editObject(jobID, user, quote, status, dateQuoted, startDate, endDate, client, contact, address, notes, WANID);
    }

    public int getJobID() {
        return jobID;
    }

    public void setJobID(int jobID) {
        this.jobID = jobID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getDateQuoted() {
        return dateQuoted;
    }

    public void setDateQuoted(Date dateQuoted) {
        this.dateQuoted = dateQuoted;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public ClientObject getClient() {
        return client;
    }

    public void setClient(ClientObject client) {
        this.client = client;
    }

    public ContactObject getContact() {
        return contact;
    }

    public void setContact(ContactObject contact) {
        this.contact = contact;
    }

    public AddressObject getAddress() {
        return address;
    }

    public void setAddress(AddressObject address) {
        this.address = address;
    }
    
    public String getJobConst(){
        return user.getName().substring(0,1)+user.getLastName().substring(0,1)+"-"+getJobID();
    }

    public Object[] getTreeTableObject() {        
        Object[] obj = new Object[] {getJobConst(),
            getJobID(),
            null,null,
            getStatus(),
            getQuote(),
            getDateQuoted(),
            getStartDate(),
            getEndDate(),
            getClient(),
            getAddress(),
            getContact(),
            null,null,null,null,null,null,null,
            getNotes()};
        return obj;
    }

    public void editObject(int jobID, User user, String quote, String status, Date dateQuoted, Date startDate, Date endDate, ClientObject client, ContactObject contact, AddressObject address, String notes, String WANID) {
        this.jobID = jobID;
        this.user = user;
        this.quote = quote;
        this.status = status;
        this.dateQuoted = dateQuoted;
        this.startDate = startDate;
        this.endDate = endDate;
        this.client = client;
        this.contact = contact;
        this.address = address;
        this.notes = notes;
        this.WANID = WANID;
    }

    public String getWANID() {
        return WANID;
    }

    public void setWANID(String WANID) {
        this.WANID = WANID;
    }        

    @Override
    public Object[][] getDBObject() {
        return new Object[][]{
            {"ID",
            "UserID",
            "DateQuoted",
            "StartDate",
            "EndDate",
            "QuoteType",
            "Status",
            "Notes",
            "ClientID",
            "ContactID",
            "WANID",
            "Street",
            "City",
            "ZIP",
            "State"},
            {getJobID(),
            getUser().getId(),
            getDateQuoted(),
            getStartDate(),
            getEndDate(),
            getQuote(),
            getStatus(),
            getNotes(),
            getClient().getID(),
            getContact().getID(),
            getWANID(),
            getAddress().getStreet(),
            getAddress().getCity(),
            getAddress().getZip(),
            getAddress().getState()}};
    }
    
    @Override
    public Object[] getSearchObject() {
        return new Object[]{
            getJobID(),
            getDateQuoted(),
            getStartDate(),
            getEndDate(),
            getQuote(),
            getStatus(),
            getNotes(),
            getClient().getClientName(),
            getContact().getName(),
            getContact().getLastName(),
            getContact().getPhone(),
            getWANID(),
            getAddress().getStreet(),
            getAddress().getCity(),
            getAddress().getState(),
            getAddress().getZip(),            
        };
    }    

    @Override
    public String getTableName() {
        return "QR_Jobs";
    }
    
    @Override
    public Object[][] getDBWhere() {
        return new Object[][]{
            {"ID","UserID"},{"=","="},{getJobID(),user.getId()},{"AND","AND"}
        };
    } 
    
    @Override
    public Object getDBID() {
        return getJobID();
    }    
    
    
    
        
}