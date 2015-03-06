package uy.yki.scrimmage.scrimmage.player;

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

    /**
     * OVERRIDES
     */
    @Override
    public String toString() {
        return "Player{" +
              "name='" + name + '\'' +
              ", faction=" + faction +
              ", powerPoints=" + powerPoints +
              '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;

        Player player = (Player) o;

        if (name != null ? !name.equals(player.name) : player.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
