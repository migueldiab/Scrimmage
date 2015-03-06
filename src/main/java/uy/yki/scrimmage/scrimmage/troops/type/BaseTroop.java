package uy.yki.scrimmage.scrimmage.troops.type;

import uy.yki.scrimmage.scrimmage.world.Zone;

import java.util.logging.Logger;

/**
 * User: migueldiab@gmail.com
 * Date: 05/03/2015
 */

public class BaseTroop {
    private Logger log = Logger.getLogger(this.getClass().toString());

    private int POWER;
    private Zone zone;
    private boolean routed = false;
    private boolean canBeRouted = true;
    private boolean dead = false;
    private boolean landUnit = true;

    /**
     * CONSTRUCTORS
     */
    public BaseTroop(Zone zone) {
        this.zone = zone;
        log.info("Troop type " + this.getClass().getSimpleName() + " created in " + zone);
    }

    /**
     * GETTERS AND SETTERS
     */
    public int getPOWER() {
        return POWER;
    }

    public void setPOWER(int POWER) {
        this.POWER = POWER;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public boolean isRouted() {
        return routed;
    }

    public void setRouted(boolean routed) {
        this.routed = routed;
    }

    public boolean isCanBeRouted() {
        return canBeRouted;
    }

    public void setCanBeRouted(boolean canBeRouted) {
        this.canBeRouted = canBeRouted;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public boolean isLandUnit() {
        return landUnit;
    }

    public void setLandUnit(boolean landUnit) {
        this.landUnit = landUnit;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName()+"{" +
              "POWER=" + POWER +
              ", zone=" + zone +
              ", routed=" + routed +
              ", canBeRouted=" + canBeRouted +
              ", dead=" + dead +
              ", landUnit=" + landUnit +
              '}';
    }
}
