package uy.yki.scrimmage.world;

/**
 * User: migueldiab@gmail.com
 * Date: 05/03/2015
 */

public class Stronghold {
    String name;
    Integer defense;

    public Stronghold(String name, Integer defense) {
        this.name = name;
        this.defense = defense;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDefense() {
        return defense;
    }

    public void setDefense(Integer defense) {
        this.defense = defense;
    }
}
