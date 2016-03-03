package neodatis1;

/**
  * @author oracle
 */
public class Sport {
    
    private String name;
    
    public static final String ODB_NAME = "tutorial_seijas.neodatis";
    
    public Sport (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
    
    
}
