package uy.yki.scrimmage.game;

import uy.yki.scrimmage.player.Faction;
import uy.yki.scrimmage.player.Player;
import uy.yki.scrimmage.world.Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

/**
 * User: migueldiab@gmail.com
 * Date: 05/03/2015
 */

public class Game {
    List<Player> players;
    Map map;

    /**
     * CONSTRUCTORS
     */
    public Game() {

    }

    /**
     * GETTERS AND SETTERS
     */

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    /**
     * METHODS
     */


    public void loadMap(Map newMap) {
        this.map = newMap;
        players = new ArrayList<Player>(newMap.getMaxPlayers());

    }


    public int getMaxPlayers() {
        return this.map.getMaxPlayers();
    }

    public void loadFactions(HashMap<Player, Faction> stubFactions) {
        for (Entry<Player, Faction> playerFactionEntry : stubFactions.entrySet()) {
            Player player = playerFactionEntry.getKey();
            Faction faction = playerFactionEntry.getValue();
            player.setFaction(faction);
            addPlayer(player);
        }
    }

    public void addPlayer(Player aPlayer) {
        this.players.add(aPlayer);
    }

    public boolean gameOver() {
        return false;
    }
}
