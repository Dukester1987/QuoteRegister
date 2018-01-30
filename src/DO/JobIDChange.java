/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DO;

import java.sql.Timestamp;

/**
 *
 * @author ldulka
 */
public class JobIDChange extends AbstractDatabaseObject{
    
    private int ID, oldJobID, newJobID;
    private String suffix, suffixOld;
    private boolean executed;
    
    public JobIDChange(int ID, int OldJobID, int newJobID, String suffix, String suffixOld, boolean executed) {
        this.editObject(ID,OldJobID,newJobID,suffix,suffixOld,executed);
    }
    
    private void editObject(int ID, int OldJobID, int newJobID, String suffix, String suffixOld, boolean executed) {
        this.ID = ID;
        this.oldJobID = OldJobID;
        this.newJobID = newJobID;
        this.suffix = suffix;
        this.suffixOld = suffixOld;
        this.executed = executed;
    }    

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getSuffixOld() {
        return suffixOld;
    }

    public void setSuffixOld(String suffixOld) {
        this.suffixOld = suffixOld;
    }       

    public int getOldJobID() {
        return oldJobID;
    }

    public void setOldJobID(int oldJobID) {
        this.oldJobID = oldJobID;
    }

    public int getNewJobID() {
        return newJobID;
    }

    public void setNewJobID(int newJobID) {
        this.newJobID = newJobID;
    }

    public boolean isExecuted() {
        return executed;
    }

    public void setExecuted(boolean executed) {
        this.executed = executed;
    }
    
    

    @Override
    public Object[][] getDBObject() {
        return new Object[][] {
                {
                    "ID","OldJobID","NewJobID","suffix","suffixOld","executed"
                },
                {
                    getID(),getOldJobID(),getNewJobID(),getSuffix(),getSuffixOld(),isExecuted()
                }
        };
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

    @Override
    public Object[] getSearchObject() {
        return new Object[] {
           getID(),getOldJobID(),getNewJobID(),isExecuted() 
        };
    }

    @Override
    public String getTableName() {
        return "QR_JobIDChange";
    }
    
}
