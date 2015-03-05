package uy.yki.scrimmage.world;

import java.util.ArrayList;
import java.util.List;

/**
 * User: migueldiab@gmail.com
 * Date: 05/03/2015
 */

public class Zone {

    String name;
    /**
     * Constructions
     */
    Stronghold stronghold;
    Port port;
    /**
     *
     */
    Integer supplies;
    Integer influence;

    boolean isLand;
    boolean isWater;

    List<Zone> adjacentZones;

    public Zone(String name, Stronghold stronghold, Port port, Integer supplies, Integer influence, boolean isLand) {
        this.name = name;
        this.stronghold = stronghold;
        this.port = port;
        this.supplies = supplies;
        this.influence = influence;
        this.isLand = isLand;
        this.isWater = !isLand;
        this.adjacentZones = new ArrayList<Zone>();
    }

    public void addAdjacentZone(Zone zone) {
        this.adjacentZones.add(zone);
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

    public Stronghold getStronghold() {
        return stronghold;
    }

    public void setStronghold(Stronghold stronghold) {
        this.stronghold = stronghold;
    }

    public Port getPort() {
        return port;
    }

    public void setPort(Port port) {
        this.port = port;
    }

    public Integer getSupplies() {
        return supplies;
    }

    public void setSupplies(Integer supplies) {
        this.supplies = supplies;
    }

    public Integer getInfluence() {
        return influence;
    }

    public void setInfluence(Integer influence) {
        this.influence = influence;
    }

    public boolean isLand() {
        return isLand;
    }

    public void setLand(boolean isLand) {
        this.isLand = isLand;
    }

    public boolean isWater() {
        return isWater;
    }

    public void setWater(boolean isWater) {
        this.isWater = isWater;
    }

    public List<Zone> getAdjacentZones() {
        return adjacentZones;
    }

    public void setAdjacentZones(List<Zone> adjacentZones) {
        this.adjacentZones = adjacentZones;
    }
}
