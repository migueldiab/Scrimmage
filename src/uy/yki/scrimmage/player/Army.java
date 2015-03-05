package uy.yki.scrimmage.player;

import uy.yki.scrimmage.troops.type.BaseTroop;

import java.util.List;

/**
 * User: migueldiab@gmail.com
 * Date: 05/03/2015
 */

public class Army {
    Integer supply;
    List<BaseTroop> troops;

    /**
     * CONSTRUCTOR
     */
    public Army(List<BaseTroop> troops) {
        this.troops = troops;
    }

    /**
     * GETTERS AND SETTERS
     */

    public Integer getSupply() {
        return supply;
    }

    public void setSupply(Integer supply) {
        this.supply = supply;
    }

    public List<BaseTroop> getTroops() {
        return troops;
    }

    public void setTroops(List<BaseTroop> troops) {
        this.troops = troops;
    }

    /**
     * METHODS
     */

    public void addTroop(BaseTroop aTroop) {
        troops.add(aTroop);
    }
}
