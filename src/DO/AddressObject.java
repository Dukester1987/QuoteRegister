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
public class AddressObject {

    private String street, city, zip, state;
    
    public AddressObject(String Street, String City, String Zip, String State) {
        this.street = Street;
        this.city = City;
        this.zip = Zip;
        this.state = State;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getStreet() {
        return street;
    }

    public String getZip() {
        return zip;
    }    

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        String street = getStreet().isEmpty()?"":getStreet()+" / ";
        String city = getCity().isEmpty()?"":getCity()+" ";
        String zip = getZip().isEmpty()?"":getZip()+" ";        

        return street+city+zip+getState();    
    }                
    
}
