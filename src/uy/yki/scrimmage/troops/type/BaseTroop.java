package uy.yki.scrimmage.troops.type;

import uy.yki.scrimmage.world.Zone;

/**
 * User: migueldiab@gmail.com
 * Date: 05/03/2015
 */

public class BaseTroop {
    private int POWER;
    private Zone zone;
    private boolean routed = false;
    private boolean canBeRouted = true;
    private boolean dead = false;
    private boolean landUnit = true;

}
