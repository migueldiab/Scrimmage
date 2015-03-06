package uy.yki.scrimmage.scrimmage.world;

import uy.yki.scrimmage.scrimmage.ScrimmageStart.ZoneNames;

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
    boolean isSea;

    List<Zone> adjacentZones;

    /**
     * CONSTRUCTORS
     */
    public Zone(ZoneNames zName, Stronghold stronghold, Port port, Integer supplies, Integer influence, boolean isSea) {
        this(zName.toString(), stronghold, port, supplies, influence, isSea);

    }
    public Zone(ZoneNames zName, Stronghold stronghold, Port port, Integer supplies, Integer influence) {
        this(zName.toString(), stronghold, port, supplies, influence);

    }

    public Zone(String name, Stronghold stronghold, Port port, Integer supplies, Integer influence, boolean isSea) {
        this.name = name;
        this.stronghold = stronghold;
        this.port = port;
        this.supplies = supplies;
        this.influence = influence;
        this.isLand = !isSea;
        this.isSea = isSea;
        this.adjacentZones = new ArrayList<Zone>();
    }

    public Zone(String name, Stronghold stronghold, Port port, Integer supplies, Integer influence) {
        this.name = name;
        this.stronghold = stronghold;
        this.port = port;
        this.supplies = supplies;
        this.influence = influence;
        this.isLand = true;
        this.isSea = false;
        this.adjacentZones = new ArrayList<Zone>();
    }

    /**
     * METHODS
     */

    /**
     * Sets a bidirectional link between zones.
     *
     * @param zone
     */
    public void addAdjacentZone(Zone zone) {
        if (!this.adjacentZones.contains(zone)) {
            this.adjacentZones.add(zone);
            zone.addAdjacentZone(this);
        }
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Zone)) return false;

        Zone zone = (Zone) o;

        if (name != null ? !name.equals(zone.name) : zone.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
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

    public boolean isSea() {
        return isSea;
    }

    public void setSea(boolean isWater) {
        this.isSea = isWater;
    }

    public List<Zone> getAdjacentZones() {
        return adjacentZones;
    }

    public void setAdjacentZones(List<Zone> adjacentZones) {
        this.adjacentZones = adjacentZones;
    }


}
