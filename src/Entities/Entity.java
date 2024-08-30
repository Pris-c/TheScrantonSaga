package Entities;

/**
 * Represents an abstract entity in the game, with the attributes
 * name, health points (hp), strength, and gold.
 * Subclasses must define specific types of entities.
 */
public abstract class Entity {

    protected String name;
    protected int hp;
    protected int strength;
    protected int gold;

    /**
     * Constructs an Entity with specified attributes.
     *
     * @param name     The name of the Entity.
     * @param hp       The amount of health points the Entity has.
     * @param strength The strength value of the Entity, used during attacks.
     * @param gold     The amount of money the Entity has, used to obtain items during the game.
     */
    public Entity(String name, int hp, int strength, int gold) {
        this.name = name;
        this.hp = hp;
        this.strength = strength;
        this.gold = gold;
    }

    /**
     * Prints the Entity's HP, strength, and gold to the console.
     * Subclasses are responsible for print the Entity's name to ensure
     * the appropriate organization of the information.
     */
    protected void showDetails() {
        String tableFormat = "| %-25s : %-47s |\n";
        System.out.printf(tableFormat, "Vida atual", this.hp);
        System.out.printf(tableFormat, "Força", this.strength);
        System.out.printf(tableFormat, "Moedas", this.gold);
    }

    /**
     * This method decreases the hp by a specified amount, ensuring a lower limit of 0.
     * If the specified amount is negative, the hp is not changed.
     *
     * @param hp The amount of HP to decrease. Must be non-negative.
     * @return The new hp value after the decrease.
     */
    public int decreaseHp(int hp) {
        if (hp > 0) {
            int newHp = this.hp - hp;
            this.hp = Math.max(0, newHp);
        }
        return this.hp;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getStrength() {
        return strength;
    }

    public int getGold() {
        return gold;
    }
}
