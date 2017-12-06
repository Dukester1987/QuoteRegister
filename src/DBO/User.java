package DBO;


import Functions.FileLogger;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import static java.util.Collections.list;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import localDB.LocalWraper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class User {
    private int id;    
    private String rights, Name, LastName, loginName, password, siteName;
    private int status;
    private Timestamp lastUpload, lastDownload;    
    private static long siteID = 0;    
    private static Date date;

    public User(int id, String loginName, String password, String rights, int status, Timestamp lastUpload, Timestamp lastDownload, String Name, String LastName) {
        this.id = id;
        this.loginName = loginName;
        this.password = password;
        this.rights = rights;
        this.status = status;
        this.lastUpload = lastUpload;
        this.lastDownload = lastDownload;
        this.Name = Name;
        this.LastName = LastName;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }
    
    
    
    public long getUserPermissions(){
        long permission = 1;
        try {
            JSONObject jString = (JSONObject) new JSONParser().parse(rights);
                if(jString.get("Rights")!=null){
                    permission = (long) jString.get("Rights");
                }
                
        } catch (ParseException ex) {
            ex.printStackTrace();
            new FileLogger(ex.getStackTrace());
        }
        return permission;        
    }
    
    public long getSiteID(){
        try {
            JSONObject jString = (JSONObject) new JSONParser().parse(rights);
            if(siteID==0){
                if(jString.get("SiteID")!=null){
                    siteID = (long) jString.get("SiteID");
                } else {
                    siteID = getSiteID(rights);
                }
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
            new FileLogger(ex.getStackTrace());
        }
        return siteID;
    } 
    
    public void setSiteID(int ID){
        siteID = ID;
    }
    
    public void setDate(Date date){
        this.date = date;
    }
    
    public Date getDate(){
        return date;
    }
    
    public long getSiteID(String JSONString){ 
        System.out.println(JSONString);
        return getSiteIDs(JSONString).get(0);
    }  
    
    public int getAmountOfSites(){
        return (int) getSiteIDs(rights).stream().count();
    }    
    
    public ArrayList<Long> getSiteIDs(String JSONString){
        ArrayList list = new ArrayList<String>();
        Long siteID = 0L;
        try {
            JSONObject jString = (JSONObject) new JSONParser().parse(JSONString);
            if(jString.get("Sites")!=null){
                JSONArray msg = (JSONArray) jString.get("Sites");
                Iterator<String> iterator = msg.iterator();
                while (iterator.hasNext()) {
                        list.add(iterator.next());
                }
            } else {
                list.add(siteID);
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }        
        return list;
    }    
    
    public String getSiteName(LocalWraper db){
        System.out.println(getSiteID());
        String query = String.format("SELECT SiteName FROM SiteList WHERE ID = %s",getSiteID());
        String toReturn = getLoginName();
        ResultSet rs = db.runQuery(query);
        if(db.getRowCount(rs)>0){
            try {
                rs.next();
                toReturn = rs.getString("SiteName");
            } catch (SQLException ex) {
                ex.printStackTrace();
                new FileLogger(ex.toString());
            }
        }
        return toReturn;
    }

    public int getId() {
        return id;
    }

    public String getLoginName() {
        return loginName;
    }

    public String getPassword() {
        return password;
    }

    public String getRights() {
        return rights;
    }
    
    public boolean hasRights(String key, String value){
        List<String> list = new ArrayList<>();        
        try {                
            JSONObject jString = (JSONObject) new JSONParser().parse(rights);
                if(jString.get(key)!=null){
                    JSONArray msg = (JSONArray) jString.get(key);
                    Iterator<String> iterator = msg.iterator();
                    while (iterator.hasNext()) {
                            list.add(iterator.next());
                    }
                    List<String> filteredList = list.stream().filter(p -> p.equals(value)).collect(Collectors.toList());
                    if(!filteredList.isEmpty()){
                        return true;
                    }
                }
                
        } catch (ParseException ex) {
            System.out.println("getting rights for user: "+loginName);
            //ex.printStackTrace();
            //new FileLogger(ex.getStackTrace());
        }        
        return false;
    }

    public int getStatus() {
        return status;
    }

    public Timestamp getLastUpload() {
        if(lastUpload == null){
           return new Timestamp(1L);
        } else {
           return lastUpload;            
        }

    }

    public Timestamp getLastDownload() {
        if(lastDownload == null){
           return new Timestamp(1L);
        } else {
           return lastDownload;            
        }
    }

    @Override
    public String toString() {
        return getName()+" "+getLastName();
    }
    
    
    
    
    
    
    
}
