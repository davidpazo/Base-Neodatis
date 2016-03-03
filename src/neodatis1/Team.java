package neodatis1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author oracle
 */
public class Team {
    
    private String name;
    private List players;
    
    public Team(String name, ArrayList <Player> players) {
        this.name = name;
        this.players = players;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getPlayers() {
        return players;
    }

    public void setPlayers(List players) {
        this.players = players;
    }
    
    
}
