package uy.yki.scrimmage.world;

import java.util.List;

/**
 * User: migueldiab@gmail.com
 * Date: 05/03/2015
 */

public class Map  {
    String name;
    int maxPlayers;
    List<Zone> zonesList;

    /**
     * CONSTRUCTORS
     */
    public Map(String name, int maxPlayers) {
        this.name = name;
        this.maxPlayers = maxPlayers;
    }

    /**
     * METHODS
     */
    public void addZone(Zone newZone) {
        zonesList.add(newZone);
    }

    /**
     * GETTERS AND SETTERS
     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public List<Zone> getZonesList() {
        return zonesList;
    }

    public void setZonesList(List<Zone> zonesList) {
        this.zonesList = zonesList;
    }
}
