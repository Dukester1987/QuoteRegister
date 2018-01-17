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
public class ProductObject extends AbstractDatabaseObject{
        
    String CODE, NAME;   
    AWSAddressObject Addrss;
    boolean direction;
    
    public ProductObject(String CODE, String NAME, AWSAddressObject Address, boolean direction) {        
        this.CODE = CODE;
        this.NAME = NAME;
        this.Addrss = Address;
        this.direction = direction;
    }

    public String getCODE() {
        return CODE;
    }

    public AWSAddressObject getAddrss() {
        return Addrss;
    }

    public void setAddrss(AWSAddressObject Addrss) {
        this.Addrss = Addrss;
    }

    public boolean isDirection() {
        return direction;
    }

    public void setDirection(boolean direction) {
        this.direction = direction;
    }

    public void setCODE(String CODE) {
        this.CODE = CODE;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }   

    @Override
    public String toString() {
        return getCODE();
    }

    @Override
    public Object[][] getDBObject() {
        return new Object[][] {
                {"CODE",
                 "NAME",
                 "Direction",
                 "Address"
                },{
                    getCODE(),
                    getNAME(),
                    isDirection(),
                    getAddrss().getID()
                }
        };
    }

    @Override
    public Object[][] getDBWhere() {
        return new Object[][]{
            {"CODE"},{"="},{getDBID()},{"AND"}
        };
    }

    @Override
    public Object getDBID() {
        return getCODE();
    }

    @Override
    public Object[] getSearchObject() {
        return new Object[] {
            getCODE(),
            getNAME(),
            isDirection(),
            getAddrss()
        };
    }

    @Override
    public String getTableName() {
        return "AWS_Products";
    }
                
}
