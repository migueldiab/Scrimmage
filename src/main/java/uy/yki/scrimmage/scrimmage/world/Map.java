package uy.yki.scrimmage.scrimmage.world;

import uy.yki.scrimmage.scrimmage.ScrimmageStart.ZoneNames;

import java.util.ArrayList;
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
        zonesList = new ArrayList<Zone>();
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

    public Zone getZoneByName(ZoneNames zoneName) {
        synchronized (zonesList) {
            for (Zone zone : zonesList) {
                if (zoneName.toString().equals(zone.getName())) {
                    return zone;
                }
            }
        }
        return null;
    }
}
