/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DO;

/**
 *
 * @author ldulka
 */
public class ContactObject extends AbstractDatabaseObject{
    
    private int ID;
    private int clientID;
    private String name, LastName, email, phone;        

    public ContactObject(int ID, int clientID, String name, String LastName, String email, String phone) {
        setContact(ID, clientID, name, LastName, email, phone);
    }

    public String getLastName() {
        return LastName;
    }
    
    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return getName()+ " " +getLastName()+ " - " +getPhone();
    }

    public void setContact(int ID, int clientID, String name, String LastName, String email, String phone) {
        this.ID = ID;
        this.clientID = clientID;
        this.name = name;
        this.LastName = LastName;
        this.email = email;
        this.phone = phone;
    }

    @Override
    public String getTableName() {
        return "QR_Contacts";
    }

    @Override
    public Object[][] getDBObject() {
        return new Object[][]{
            {"ID",
            "ClientID",
            "Name",
            "LastName",
            "email",
            "phone"},
            {getID(),
            getClientID(),
            getName(),
            getLastName(),
            getEmail(),
            getPhone()}}; 
    }
    
    @Override
    public Object[] getSearchObject() {
        return new Object[]{
            getID(),
            getClientID(),
            getName(),
            getLastName(),
            getEmail(),
            getPhone()
        };
    }         

    @Override
    public Object[][] getDBWhere() {
        return new Object[][]{
            {"ID","ClientID"},{"=","="},{getID(),getClientID()},{"AND"}
        };
    }
    
    @Override
    public Object getDBID() {
        return getID();
    }    
    
    
    
}
