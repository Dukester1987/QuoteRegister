/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DO;

import localDB.LocalWraper;
import quoteregister.Gui;

/**
 *
 * @author ldulka
 */
public abstract class AbstractDatabaseObject {

    protected final LocalWraper db;      
    
    public AbstractDatabaseObject(){
        this.db = Gui.getDB();
    }
    
    public boolean search(String text){
        Object[] MyObject = getSearchObject();
        for (Object objects : MyObject) {
            if(objects instanceof String){
                if(objects.toString().toLowerCase().contains(text.toLowerCase()))
                    return true;
            }
        }
        return false;
    }
    
    public void dbSave(){
        db.dbInsert(getTableName(), getDBObject(),getDBID());
    };
    
    public void dbUpdate(){
        db.dbUpdate(getTableName(), getDBObject(), getDBWhere());
    }
    
    public void dbDelete(){
        if(getDBID() instanceof String){
            db.dbDelete(getTableName(), getDBWhere(),(String) getDBID());   
            System.out.println("ID is string");
        } else if (getDBID() instanceof Integer){            
            db.dbDelete(getTableName(), getDBWhere(),(int) getDBID());   
            System.out.println("ID is INT");
        }
    }
    
    public abstract Object[][] getDBObject();
    
    public abstract Object[][] getDBWhere();
    
    public abstract Object getDBID();
    
    public abstract Object[] getSearchObject();
    
    public abstract String getTableName();
    
}
