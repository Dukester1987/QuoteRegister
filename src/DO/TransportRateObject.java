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
public class TransportRateObject extends AbstractDatabaseObject {
    
    private String ProductID,ID,Notes;
    private TruckGroupObject truckGroupObject;
    private Double materialCost, transportRate, externalTipping;
    private Double specialProject;

    public TransportRateObject(String ProductID, String ID, TruckGroupObject truckGroupObject, Double materialCost, Double transportRate, Double specialProject, Double externalTipping, String notes) {
        setTransportRateObject(ProductID, ID, truckGroupObject, materialCost, transportRate, specialProject, externalTipping, notes);
    }

    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String ProductID) {
        this.ProductID = ProductID;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public TruckGroupObject getTruckGroupObject() {
        return truckGroupObject;
    }

    public void setTruckGroupObject(TruckGroupObject truckGroupObject) {
        this.truckGroupObject = truckGroupObject;
    }

    public Double getMaterialCost() {
        return materialCost;
    }

    public void setMaterialCost(Double materialCost) {
        this.materialCost = materialCost;
    }

    public Double getTransportRate() {
        return transportRate;
    }

    public void setTransportRate(Double transportRate) {
        this.transportRate = transportRate;
    }

    public Double getTotalCost() {
        return transportRate+materialCost+specialProject+externalTipping;
    }
    
    public String getNotes() {
        return Notes;
    }

    public void setNotes(String Notes) {
        this.Notes = Notes;
    }    
    
    public void setTransportRateObject(String ProductID, String ID, TruckGroupObject truckGroupObject, Double materialCost, Double transportRate, Double specialProject, Double externalTipping, String notes){
        this.ProductID = ProductID;
        this.ID = ID;
        this.truckGroupObject = truckGroupObject;
        this.materialCost = materialCost;
        this.transportRate = transportRate; 
        this.specialProject = specialProject;
        this.externalTipping = externalTipping;
        this.Notes = notes;
    }

    public Double getSpecialProject() {
        return specialProject;
    }
    
    public Double getExternalTipping() {
        return externalTipping;
    }

    public void setSpecialProject(Double specialProject) {
        this.specialProject = specialProject;
    }
    
    public void setExternalTipping(Double externalTipping){
        this.externalTipping = externalTipping;
    }
    
    public Object[] getTableObject(){        
        return new Object[] {getTruckGroupObject(),null,null,ID,null,null,null,null,null,null,null,null,null,null,getTruckGroupObject(),getTotalCost(),getMaterialCost(),getTransportRate(),getSpecialProject(),getExternalTipping(),getNotes()};        
    }

    @Override
    public Object[][] getDBObject() {
        return new Object[][]{
                {"ID",
                "ProductAllID",
                "TruckGroupID",
                "Notes",
                "MaterialCost",
                "TransportRate",
                "SpecialProject",
                "ExternalTipping"},
                {getID(),
                getProductID(),
                getTruckGroupObject().getID(),
                getNotes(),
                getMaterialCost(),
                getTransportRate(),
                getSpecialProject(),
                getExternalTipping()}
        };
    }
    
    @Override
    public Object[] getSearchObject() {
        return new Object[]{
            getID(),
            getProductID(),
            getTruckGroupObject().getGroupName(),
            getNotes(),
            getMaterialCost(),
            getTransportRate(),
            getSpecialProject(),
            getExternalTipping()
        };
    }         

    @Override
    public Object[][] getDBWhere() {
        return new Object[][]{
            {"ID","ProductAllID"},{"=","="},{getID(),getProductID()},{"AND","AND"}
        };
    }

    @Override
    public String getTableName() {
        return "QR_TransportRate";
    }

    @Override
    public Object getDBID() {
        return getID();
    }



}
