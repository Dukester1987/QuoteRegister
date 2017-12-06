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
public class ProductAllObject extends AbstractDatabaseObject{
    
    private String ID;
    private int JobID;
    private ProductObject Product;
    private String notes;
    private Double volume;
    private boolean ongoing;
    private AddressObject address;
    private boolean direction;

    public ProductAllObject(String ID, int JobID, ProductObject Product, Double volume, String notes, boolean ongoing, boolean direction, AddressObject address) {
        setProductAllObject(ID, JobID, Product, volume, notes, ongoing, direction, address);        
    }
    
    public boolean isOngoing() {
        return ongoing;
    }    

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getJobID() {
        return JobID;
    }

    public void setJobID(int JobID) {
        this.JobID = JobID;
    }

    public ProductObject getProduct() {
        return Product;
    }

    public void setProduct(ProductObject Product) {
        this.Product = Product;
    }
    
    public String getTableNotes(){
        if(ongoing){
            return notes.isEmpty()?"On going":"On going | "+notes;
        }
        return notes;        
    }
    
    public String getOnGoingText(){
        if(ongoing)
            return "On going";        
        return null;
    }

    public AddressObject getAddress() {
        return address;
    }

    public boolean isDirection() {
        return direction;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
    
    public void setProductAllObject(String ID, int JobID, ProductObject Product, Double volume, String notes, boolean ongoing, boolean direction, AddressObject address){
        this.ID = ID;        
        this.JobID = JobID;        
        this.Product = Product;        
        this.volume = volume;        
        this.notes = notes;                
        this.ongoing = ongoing;
        this.direction = direction;
        this.address = address;
    }
    
    public Object[] getTableObject(){
        return new Object[] {getProduct(),null,getID(),null,null,null,null,null,null,null,null,null,getProduct(),getVolume(),getOnGoingText(),null,null,null,null,getTableNotes()};
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    @Override
    public Object[][] getDBObject() {
        String Street = "";
        String City = "";
        String Zip = "";
        String State = "";
                
        if(getAddress()!=null){            
            Street = getAddress().getStreet();
            City = getAddress().getCity();
            Zip = getAddress().getZip();
            State = getAddress().getState();
        }
        return new Object[][]{
                {"ID",
                "JobID",
                "ProductID",
                "Notes",
                "Volume",
                "Ongoing",
                "Direction",
                "Street",
                "City",
                "Zip",
                "State"},
                {getID(),
                getJobID(),
                getProduct().getCODE(),
                getNotes(),
                getVolume(),
                isOngoing(),
                isDirection(),
                Street,
                City,
                Zip,
                State}
        };
    }
    
    @Override
    public Object[] getSearchObject() {
        return new Object[]{
            getID(),
            getJobID(),
            getProduct().getCODE(),
            getNotes(),
            getVolume(),
            isOngoing(),
            isDirection(),
            getAddress().getStreet(),
            getAddress().getCity(),
            getAddress().getState(),
            getAddress().getZip()
        };
    }         

    @Override
    public Object[][] getDBWhere() {
        return new Object[][]{
            {"ID","JobID"},{"=","="},{getID(),getJobID()},{"AND","AND"}
        };
    }

    @Override
    public String getTableName() {
        return "QR_JobProducts";
    }

    @Override
    public Object getDBID() {
        return getID();
    }
    
    
    
}
