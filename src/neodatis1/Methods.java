package neodatis1;

import java.util.ArrayList;
import static neodatis1.Sport.ODB_NAME;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

/**
 * 
 * @author oracle
 */
public class Methods {
    
    public static void amosar_deportes(ODB odb) {
        
        try {
            // Open the database
            odb = ODBFactory.open(ODB_NAME);
            IQuery query = new CriteriaQuery(Sport.class);
            Objects <Sport> sports = odb.getObjects(query);
            
            System.out.println("Amosando os nomes de todos os deportes");
            
            // display each object
            while (sports.hasNext()) {
                System.out.println(sports.next().getName());
            }
            
        } finally {
            if (odb != null) {
                odb.close();
            }
        }
        
    }
    
    public static void  consulta_xogadores(ODB odb) {
        // amosar nome de xogador, nome do seu deporte favorito e o seu salario
        
        try {
            // Open the database
            odb = ODBFactory.open(ODB_NAME);
            IQuery query = new CriteriaQuery(Player.class);
            Objects <Player> players = odb.getObjects(query);
            
            System.out.println("Amosando os nomes, deportes e salarios de todos os xogadores");
            
            // display each object
            while (players.hasNext()) {
                Player player = players.next();
                System.out.println(player.getName() + ", " + player.getFavoriteSport().getName() + ", " + player.getSalario());
            }
            
        } finally {
            if (odb != null) {
                odb.close();
            }
        }
        
    }
    
    public static void actualiza_por_nome_xogador(ODB odb, String nome_antigo, String nome_novo) {
        // ter en conta que pode haber mais dun xogador co mesmo nome
        
        try {
            // Open the database
            odb = ODBFactory.open(ODB_NAME);
            IQuery query = new CriteriaQuery(Player.class, Where.equal("name", nome_antigo));
            Objects <Player> players = odb.getObjects(query);
            
            System.out.println("Actualizado o xogador: " + nome_antigo + " polo nome: " + nome_novo);
            
            // display each object
            while (players.hasNext()) {
                Player player = players.next();
                player.setName(nome_novo);
            }
            
        } finally {
            if (odb != null) {
                odb.close();
            }
        }
        
    }
    
    public static void xogadoresDeporte(ODB odb, String deporte) {
        // amosar os nomes dos xogadores dun deporte
        
        try {
            // Open the database
            odb = ODBFactory.open(ODB_NAME);
            IQuery query = new CriteriaQuery(Player.class, Where.equal("favoriteSport.name", deporte));
            Objects <Player> players = odb.getObjects(query);
            
            System.out.println("Amosando os nomes dos xogadores, do deporte " + deporte);
            
            // display each object
            while (players.hasNext()) {
                System.out.println(players.next().getName());
            }
            
        } finally {
            if (odb != null) {
                odb.close();
            }
        }
        
    }
    
    public static void devoltar_equipos_con_xogadores_menos_dunha_cantidade(ODB odb,int cantidade) {
        // amosa xogador e equipo dos xogadores que cobren menos da cantidade indicada
        
        try {
            // Open the database
            odb = ODBFactory.open(ODB_NAME);
            IQuery query = new CriteriaQuery(Team.class);
            Objects <Team> teams = odb.getObjects(query);
            
            System.out.println("Amosando os nomes dos xogadores e o seu equipo cando cobran menos de: " + cantidade);
            
            // display each object
            while (teams.hasNext()) {
                Team team = teams.next();
                ArrayList <Player> players = (ArrayList) team.getPlayers();
                for ( Player player : players ) {
                    if ( player.getSalario() < cantidade ) {
                        System.out.println(player.getName() + ", " + team.getName() + ", " + player.getSalario());
                    }
                }
            }
            
        } finally {
            if (odb != null) {
                odb.close();
            }
        }
        
    }
}
