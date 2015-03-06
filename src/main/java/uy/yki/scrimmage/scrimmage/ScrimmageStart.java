package uy.yki.scrimmage.scrimmage;

import com.ebay.sdk.helper.ConsoleUtil;
import uy.yki.scrimmage.scrimmage.game.Game;
import uy.yki.scrimmage.scrimmage.player.Army;
import uy.yki.scrimmage.scrimmage.player.Faction;
import uy.yki.scrimmage.scrimmage.player.Player;
import uy.yki.scrimmage.scrimmage.troops.type.BaseTroop;
import uy.yki.scrimmage.scrimmage.troops.type.Footman;
import uy.yki.scrimmage.scrimmage.world.Map;
import uy.yki.scrimmage.scrimmage.world.Port;
import uy.yki.scrimmage.scrimmage.world.Stronghold;
import uy.yki.scrimmage.scrimmage.world.Zone;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.logging.Logger;

/**
 * User: migueldiab@gmail.com
 * Date: 05/03/2015
 */

public class ScrimmageStart {
    private Logger log = Logger.getLogger(this.getClass().toString());

    private static ScrimmageStart instance;
    private Game theGame;
    private int maxPlayers;

    private static final String NORTH_WESTEROS = "North Westeros";
    public enum ZoneNames {
        BAY_OF_ICE("Bay of Ice")
        ,SHIVERING_SEA("The Shivering Sea")
        ,CASTLE_BLACK("Castle Black")
        , WINTERFELL_STRONGHOLD("Winterfell Stronghold")
        ,WINTERFELL_PORT("Winterfell Port")
        ,WINTERFELL("Winterfell")
        ,KARHOLD("Karhold")
        ,WHITE_HARBOR_STRONGHOLD("White Harbor Stronghold")
        ,WHITE_HARBOR_PORT("White Harbor Port")
        ,WHITE_HARBOR("White Harbor")
        ,WIDOWS_WATCH("Widow's Watch")
        ,STONY_SHORE("Stony Shore")
        ;
        private String name;

        ZoneNames(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    private ScrimmageStart() {
        log.info("Welcome to Scrimmage");
    }

    public static synchronized ScrimmageStart getInstance() {
        if (null == instance) {
            instance = new ScrimmageStart();
        }
        return instance;
    }

    public static void main(String [] args) {
        ScrimmageStart start = ScrimmageStart.getInstance();

        try {
            start.startGame();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void startGame() throws IOException {
        theGame = new Game();
        theGame.loadMap(createStubMap());
        maxPlayers = theGame.getMaxPlayers();

        int numPlayers = ConsoleUtil.readInt("Number of Players (2-"+maxPlayers+"): ");
        if (1 < numPlayers && numPlayers <= maxPlayers) {
            log.info("Playing with " + numPlayers + " players");
            Set<Player> players = readPlayerNames(numPlayers);
            theGame.loadFactions(createStubFactions(players, theGame.getMap()));
            while (!theGame.gameOver()) {
                for (Player player : theGame.getPlayers()) {

                }
                theGame.nextRound();
            }
        }

    }

    private Set<Player> readPlayerNames(int numPlayer) throws IOException {
        Set<Player> players = new HashSet<Player>(numPlayer);
        while (players.size() < numPlayer) {
            String name = ConsoleUtil.readString("Player " + (players.size()+1) + " name : ");
            Player aPlayer = new Player(name);
            players.add(aPlayer);
        }
        return players;
    }

    private HashMap<Player, Faction> createStubFactions(Set<Player> players, Map map) {
        Stack<Faction> factionSet = new Stack<Faction>();

        Zone zone = map.getZoneByName(ZoneNames.CASTLE_BLACK);
        List<BaseTroop> troops = new ArrayList<BaseTroop>();
        Footman footman = new Footman(zone);
        troops.add(footman);
        Army army = new Army(2, troops);
        Faction blue = new Faction(army);
        factionSet.add(blue);

        zone = map.getZoneByName(ZoneNames.WIDOWS_WATCH);
        troops = new ArrayList<BaseTroop>();
        footman = new Footman(zone);
        troops.add(footman);
        army = new Army(2, troops);
        Faction red = new Faction(army);
        factionSet.add(red);

        zone = map.getZoneByName(ZoneNames.STONY_SHORE);
        troops = new ArrayList<BaseTroop>();
        footman = new Footman(zone);
        troops.add(footman);
        army = new Army(2, troops);
        Faction green = new Faction(army);
        factionSet.add(green);

        HashMap<Player, Faction> factions = new HashMap<Player, Faction>();
        for (Player player : players) {
            factions.put(player, factionSet.pop());
        }
        return factions;
    }

    private Map createStubMap() {
        Map map = new Map(NORTH_WESTEROS, 3);
        /**
         * Seas
         */
        Zone bayOfIce = new Zone(ZoneNames.BAY_OF_ICE, null, null, 0, 0, true);
        Zone shiveringSea = new Zone(ZoneNames.SHIVERING_SEA, null, null, 0, 0, true);
        /**
         * Land
         */
        Zone castleBlack = new Zone(ZoneNames.CASTLE_BLACK, null, null, 0, 1);

        Stronghold winterfellSHold = new Stronghold(ZoneNames.WINTERFELL_STRONGHOLD, 2);
        Port winterfellPort = new Port(ZoneNames.WINTERFELL_PORT);
        Zone winterfell = new Zone(ZoneNames.WINTERFELL, winterfellSHold, winterfellPort, 1, 1);

        Zone karhold = new Zone(ZoneNames.KARHOLD, null, null, 0, 1);

        Stronghold whiteHarborSHold = new Stronghold(ZoneNames.WHITE_HARBOR_STRONGHOLD, 1);
        Port whiteHarborPort = new Port(ZoneNames.WHITE_HARBOR_PORT);
        Zone whiteHarbor = new Zone(ZoneNames.WHITE_HARBOR, whiteHarborSHold, whiteHarborPort, 0, 0);

        Zone widowsWatch = new Zone(ZoneNames.WIDOWS_WATCH, null, null, 1, 0);

        Zone stonyShore = new Zone(ZoneNames.STONY_SHORE, null, null, 1, 0);

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
