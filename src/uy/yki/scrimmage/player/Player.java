package uy.yki.scrimmage.player;

/**
 * User: migueldiab@gmail.com
 * Date: 05/03/2015
 */

public class Player {
    private String name;
    private Faction faction;
    private int powerPoints = 5;

    /**
     * CONSTRUCTORS
     */
    public Player(String name) {
        this.name = name;
    }

    /**
     * GETTERS and SETTERS
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Faction getFaction() {
        return faction;
    }

    public void setFaction(Faction faction) {
        this.faction = faction;
    }
}
