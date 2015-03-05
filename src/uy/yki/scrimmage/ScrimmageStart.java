package uy.yki.scrimmage;

import uy.yki.scrimmage.game.Game;
import uy.yki.scrimmage.player.Faction;
import uy.yki.scrimmage.player.Player;
import uy.yki.scrimmage.world.Map;
import uy.yki.scrimmage.world.Port;
import uy.yki.scrimmage.world.Stronghold;
import uy.yki.scrimmage.world.Zone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * User: migueldiab@gmail.com
 * Date: 05/03/2015
 */

public class ScrimmageStart {
    private static ScrimmageStart instance;
    private Game theGame;
    private int maxPlayers;

    private ScrimmageStart() {
        System.out.println("Welcome to Scrimmage");
    }

    public static synchronized ScrimmageStart getInstance() {
        if (null == instance) {
            instance = new ScrimmageStart();
        }
        return instance;
    }

    public static void main(String [] args) {
        ScrimmageStart start = ScrimmageStart.getInstance();
        start.startGame();
    }

    private void startGame() {
        theGame = new Game();
        theGame.loadMap(createStubMap());
        maxPlayers = theGame.getMaxPlayers();

        System.out.print("Number of Players (2-"+maxPlayers+"): ");
        int numPlayers = readPlayers();
        if (1 < numPlayers && numPlayers <= maxPlayers) {
            System.out.println("Playing with " + numPlayers + " players");
            List<Player> players = readPlayerNames(numPlayers);
            theGame.loadFactions(createStubFactions(players));
            while (!theGame.gameOver()) {
                for (Player player : theGame.getPlayers()) {

                }
            }
        }

    }

    private List<Player> readPlayerNames(int numPlayer) {
        List<Player> players = new ArrayList<Player>(numPlayer);
        for (int i = 0; i < numPlayer; i++) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Player " + i + " name : ");
            try{
                String name = br.readLine();
                Player aPlayer = new Player(name);
                players.add(aPlayer);
            }catch(NumberFormatException nfe){
                System.err.println("Invalid Format!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return players;
    }

    private int readPlayers() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numPlayers = -1;
        try{
            String s = br.readLine();
            numPlayers = Integer.parseInt(s);
        }catch(NumberFormatException nfe){
            System.err.println("Invalid Format!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numPlayers;
    }

    private HashMap<Player, Faction> createStubFactions(List<Player> players) {
        Stack<Faction> factionSet = new Stack<Faction>();
        Faction blue = new Faction();
        factionSet.add(blue);
        Faction red = new Faction();
        factionSet.add(red);
        Faction green = new Faction();
        factionSet.add(green);

        HashMap<Player, Faction> factions = new HashMap<Player, Faction>();
        for (Player player : players) {
            factions.put(player, factionSet.pop());
        }
        return factions;
    }

    private Map createStubMap() {
        Map map = new Map("North Westeros", 3);
        /**
         * Seas
         */
        Zone bayOfIce = new Zone("Bay of Ice", null, null, 0, 0, true);
        Zone shiveringSea = new Zone("The Shivering Sea", null, null, 0, 0, true);
        /**
         * Land
         */
        Zone castleBlack = new Zone("Castle Black", null, null, 0, 1);

        Stronghold winterfellSHold = new Stronghold("Winterfell Stronghold", 2);
        Port winterfellPort = new Port("Winterfell Port");
        Zone winterfell = new Zone("Winterfell", winterfellSHold, winterfellPort, 1, 1);

        Zone karhold = new Zone("Karhold", null, null, 0, 1);

        Stronghold whiteHarborSHold = new Stronghold("Winterfell Stronghold", 1);
        Port whiteHarborPort = new Port("White Harbor Port");
        Zone whiteHarbor = new Zone("White Harbor", whiteHarborSHold, whiteHarborPort, 0, 0);

        Zone widowsWatch = new Zone("Widow's Watch", null, null, 1, 0);

        Zone stonyShore = new Zone("Stony Shore", null, null, 1, 0);

        /**
         * Adjacent Zones
         */
        castleBlack.addAdjacentZone(bayOfIce);
        castleBlack.addAdjacentZone(karhold);
        castleBlack.addAdjacentZone(winterfell);
        castleBlack.addAdjacentZone(shiveringSea);

        karhold.addAdjacentZone(shiveringSea);
        karhold.addAdjacentZone(winterfell);

        winterfell.addAdjacentZone(bayOfIce);
        winterfell.addAdjacentZone(shiveringSea);
        winterfell.addAdjacentZone(whiteHarbor);
        winterfell.addAdjacentZone(stonyShore);

        whiteHarbor.addAdjacentZone(widowsWatch);
        whiteHarbor.addAdjacentZone(shiveringSea);

        widowsWatch.addAdjacentZone(shiveringSea);

        stonyShore.addAdjacentZone(bayOfIce);

        /**
         * Map Layout
         */
        map.addZone(shiveringSea);
        map.addZone(bayOfIce);
        map.addZone(castleBlack);
        map.addZone(karhold);
        map.addZone(winterfell);
        map.addZone(whiteHarbor);
        map.addZone(widowsWatch);
        map.addZone(stonyShore);

        return map;
    }
}
