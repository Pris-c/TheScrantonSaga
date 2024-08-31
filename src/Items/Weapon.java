package Items;

import java.util.ArrayList;

/**
 * Represents a weapon that a Hero can use,  extending the ItemHero class.
 * Weapons have its attack points summed to Hero strength to define an attack value.
 * A weapon add to the ItemHero specifics attacks values for standard and special attacks.
 */
public class Weapon extends ItemHero {

    private int standardAttack;
    private int specialAttack;

    /**
     * Constructs a Weapon with specified attributes.
     *
     * @param name The name of the Weapon.
     * @param price The value that the Hero must pay to obtain the item.
     * @param allowedTo A list of Hero types that can buy the item.
     * @param standardAttack The value to be added to the Hero strength during standards attacks
     * @param specialAttack The value to be added to the Hero strength during specials attacks
     */
    public Weapon(String name, int price, ArrayList<String> allowedTo, int standardAttack, int specialAttack) {
        super(name, price, allowedTo);
        this.standardAttack = standardAttack;
        this.specialAttack = specialAttack;
    }

    /**
     * Print to the console detailed information about the Weapon, as the price and the
     * standard and special attacks values.
     */
    @Override
    public void showDetails() {
        String format = "| %-20s %-10s |\n";
        String headerFormat = "| %-31s |\n";

        System.out.println("+---------------------------------+");
        System.out.printf(headerFormat, super.name.toUpperCase());
        System.out.println("+---------------------------------+");

        System.out.printf(format, "Uso Comum:", this.standardAttack);
        System.out.printf(format, "Uso Criativo:", this.specialAttack);
        System.out.printf(format, "Preço:", this.price);
        System.out.println("+---------------------------------+\n");
    }

    public int getStandardAttack() {
        return standardAttack;
    }

    public int getSpecialAttack() {
        return specialAttack;
    }
}
