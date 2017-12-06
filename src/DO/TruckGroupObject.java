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
public class TruckGroupObject {
    
    Integer ID;
    String GroupName;    

    public TruckGroupObject(int ID, String GroupName) {
        this.ID = ID;
        this.GroupName = GroupName;        
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getGroupName() {
        return GroupName;
    }

    public void setGroupName(String GroupName) {
        this.GroupName = GroupName;
    }

    @Override
    public String toString() {
        return getGroupName();
    }
    
    
    
    
}
