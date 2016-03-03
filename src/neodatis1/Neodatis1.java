package neodatis1;

import java.util.ArrayList;
import java.util.Date;
import static neodatis1.Sport.ODB_NAME;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

/**
 * 
 * @author oracle
 */
public class Neodatis1 {

    public static void main(String[] args) {
        
        // storeData();
        
        Methods.amosar_deportes(null);
        
        Methods.consulta_xogadores(null);
        
        Methods.actualiza_por_nome_xogador(null, "carlos", "calros");
        
        Methods.xogadoresDeporte(null, "volley-ball");
        
        Methods.devoltar_equipos_con_xogadores_menos_dunha_cantidade(null, 1400);
        
    }
    
    private static void storeData() {
        
        ODB odb = null;
        
        try {
            // Open the database
            odb = ODBFactory.open(ODB_NAME);
            
            Sport sport1 = new Sport("volley-ball");
            Sport sport2 = new Sport("tennis");
            
            Player player1 = new Player("oliver", new Date(), sport1, 1000);
            Player player2 = new Player("pierre", new Date(), sport1, 1500);
            Player player3 = new Player("elohim", new Date(), sport1, 2000);
            Player player4 = new Player("minh", new Date(), sport1, 1300);
            Player player5 = new Player("luis", new Date(), sport2, 1600);
            Player player6 = new Player("carlos", new Date(), sport2, 2000);
            Player player7 = new Player("luis", new Date(), sport2, 1500);
            Player player8 = new Player("jose", new Date(), sport2, 3000);
            
            ArrayList <Player> teamplayers1 = new ArrayList<>();
            teamplayers1.add(player1);
            teamplayers1.add(player2);
            ArrayList <Player> teamplayers2 = new ArrayList<>();
            teamplayers2.add(player3);
            teamplayers2.add(player4);
            ArrayList <Player> teamplayers3 = new ArrayList<>();
            teamplayers3.add(player5);
            teamplayers3.add(player6);
            ArrayList <Player> teamplayers4 = new ArrayList<>();
            teamplayers4.add(player7);
            teamplayers4.add(player8);
            
            Team team1 = new Team("Paris", teamplayers1);
            Team team2 = new Team("Montpellier", teamplayers2);
            Team team3 = new Team("Boreux", teamplayers3);
            Team team4 = new Team("Lion", teamplayers4);
            
            Game game1 = new Game(new Date(), sport1, team1, team2);
            Game game2 = new Game(new Date(), sport2, team3, team4);
            
            // Store the object
            odb.store(sport1);
            odb.store(sport2);
            
            odb.store(player1);
            odb.store(player2);
            odb.store(player3);
            odb.store(player4);
            odb.store(player5);
            odb.store(player6);
            odb.store(player7);
            odb.store(player8);
            
            odb.store(team1);
            odb.store(team2);
            odb.store(team3);
            odb.store(team4);
            
            odb.store(game1);
            odb.store(game2);
            
        } catch (Exception ex) {
            
        } finally {
            if(odb!=null){
                odb.close();
            }
        }
        
    }
    
    /*
    
    public static void displaySports() {
        
        // Open the database
        ODB odb = ODBFactory.open(ODB_NAME);
        
        // Get all object of type Sport
        Objects<Sport> sports = odb.getObjects(Sport.class);
        
        // display each object
        Sport sport = null;
        
        while(sports.hasNext()){
            sport = sports.next();
            System.out.println(sport.getName());
        }
        
        // Closes the database
        odb.close();
        
    }
    
    */
    
}
