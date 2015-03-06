package uy.yki.scrimmage.scrimmage.troops.type;

import uy.yki.scrimmage.scrimmage.world.Zone;

/**
 * User: migueldiab@gmail.com
 * Date: 05/03/2015
 */

public class Ship extends BaseTroop {
    private int POWER = 1;
    private boolean landUnit = false;
    private boolean canBeRouted = false;

    /**
     * CONSTRUCTORS
     */
    public Ship(Zone zone) {
        super(zone);
    }
}
