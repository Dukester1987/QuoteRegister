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
public class AWSAddressObject extends AddressObject {
    private String ID;
    private String Name;    
       
    public AWSAddressObject(String ID, String Name, String Street, String City, String Zip, String State) {
        super(Street, City, Zip, State);
        this.ID = ID;
        this.Name = Name;        
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }
    
    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String Name) {
        this.Name = Name;
    }    

    @Override
    public String toString() {
        return getID()+ " "+ getName()+" "+super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
