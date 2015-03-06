package uy.yki.scrimmage.scrimmage.player;

import uy.yki.scrimmage.scrimmage.world.Port;
import uy.yki.scrimmage.scrimmage.world.Stronghold;

import java.util.List;
import java.util.logging.Logger;

/**
 * User: migueldiab@gmail.com
 * Date: 05/03/2015
 */

public class Faction {
    private Logger log = Logger.getLogger(this.getClass().toString());

    private Army army;
    private List<Stronghold> strongholds;
    private List<ControlZone> controlZones;
    private List<Port> ports;

    /**
     * CONSTRUCTORS
     */
    public Faction(Army army) {
        this.army = army;
        log.info("New faction controlling " + army);

    }

    /**
     * GETTERS AND SETTERS
     */

    public Army getArmy() {
        return army;
    }

    public void setArmy(Army army) {
        this.army = army;
    }

    public List<Stronghold> getStrongholds() {
        return strongholds;
    }

    public void setStrongholds(List<Stronghold> strongholds) {
        this.strongholds = strongholds;
    }

    public List<ControlZone> getControlZones() {
        return controlZones;
    }

    public void setControlZones(List<ControlZone> controlZones) {
        this.controlZones = controlZones;
    }

    public List<Port> getPorts() {
        return ports;
    }

    public void setPorts(List<Port> ports) {
        this.ports = ports;
    }
}
