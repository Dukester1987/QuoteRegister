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
    private Double materialCost, transportRate;
    private Double specialProject;

    public TransportRateObject(String ProductID, String ID, TruckGroupObject truckGroupObject, Double materialCost, Double transportRate, Double specialProject, String notes) {
        setTransportRateObject(ProductID, ID, truckGroupObject, materialCost, transportRate, specialProject, notes);
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
        return transportRate+materialCost;
    }
    
    public String getNotes() {
        return Notes;
    }

    public void setNotes(String Notes) {
        this.Notes = Notes;
    }    
    
    public void setTransportRateObject(String ProductID, String ID, TruckGroupObject truckGroupObject, Double materialCost, Double transportRate, Double specialProject, String notes){
        this.ProductID = ProductID;
        this.ID = ID;
        this.truckGroupObject = truckGroupObject;
        this.materialCost = materialCost;
        this.transportRate = transportRate; 
        this.specialProject = specialProject;
        this.Notes = notes;
    }

    public Double getSpecialProject() {
        return specialProject;
    }

    public void setSpecialProject(Double specialProject) {
        this.specialProject = specialProject;
    }
    
    public Object[] getTableObject(){        
        return new Object[] {getTruckGroupObject(),null,null,ID,null,null,null,null,null,null,null,null,null,null,getTruckGroupObject(),getTotalCost(),getMaterialCost(),getTransportRate(),getSpecialProject(),getNotes()};        
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
                "SpecialProject"},
                {getID(),
                getProductID(),
                getTruckGroupObject().getID(),
                getNotes(),
                getMaterialCost(),
                getTransportRate(),
                getSpecialProject()}
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
            getSpecialProject()
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
