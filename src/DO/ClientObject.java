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
public class ClientObject extends AbstractDatabaseObject {
    
    private int ID;
    private String globeID;
    private String clientName;    

    public ClientObject(int ID, String globeID, String clientName) {
        createClientObject(ID, globeID, clientName);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getGlobeID() {
        return globeID;
    }

    public void setGlobeID(String globeID) {
        this.globeID = globeID;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }  
    
    public void createClientObject(int ID, String globeID, String clientName){
        this.ID = ID;
        this.globeID = globeID;
        this.clientName = clientName;        
    }

    @Override
    public String toString() {
        return getClientName()+" ("+getID()+")";
    }

    @Override
    public Object[][] getDBObject() {
        return new Object[][]{
            {"ID",
            "GlobeID",
            "ClientName"},
            {getID(),
            getGlobeID(),
            getClientName()}};        
    }
    
    @Override
    public Object[] getSearchObject() {
        return new Object[]{
            getID(),
            getGlobeID(),
            getClientName(),            
        };
    }       

    @Override
    public String getTableName() {
        return "QR_Clients";
    }

    @Override
    public Object[][] getDBWhere() {
        return new Object[][]{
            {"ID"},{"="},{getID()},{"AND"}
        };
    }

    @Override
    public Object getDBID() {
        return getID();
    }
    
    
    
}
