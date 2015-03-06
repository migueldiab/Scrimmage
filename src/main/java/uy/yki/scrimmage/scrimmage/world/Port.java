package uy.yki.scrimmage.scrimmage.world;

import uy.yki.scrimmage.scrimmage.ScrimmageStart.ZoneNames;

/**
 * User: migueldiab@gmail.com
 * Date: 05/03/2015
 */

public class Port {
    String name;

    public Port(ZoneNames zoneNames) {
        this(zoneNames.toString());
    }
    public Port(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
