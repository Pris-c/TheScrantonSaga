package Items;

import java.util.ArrayList;

/**
 * Represents a Combat Consumable item in the game, extending the Consumable class.
 * This item offers the Hero an instant Attack, witch replaces Hero's attack strength when used.
 * A CombatConsumable adds to the Consumable the specific value of its instantAttack.
 */
public class CombatConsumable extends Consumable {

    private int instantAttack;

    /**
     * Constructs a CombatConsumable with specified attributes.
     *
     * @param name          The name of the Weapon.
     * @param price         The value that the Hero must pay to obtain the item.
     * @param allowedTo     A list of Hero types that can buy the item.
     * @param instantAttack The value of the instant attack that will replace the Hero's attack value when used.
     */
    public CombatConsumable(String name, int price, ArrayList<String> allowedTo, int instantAttack) {
        super(name, price, allowedTo);
        this.instantAttack = instantAttack;
    }

    /**
     * Prints to the console detailed information about the CombatConsumable, as the price and the
     * instant attack value.
     */
    @Override
    public void showDetails() {
        String format = "| %-20s %-10s |\n";
        String headerFormat = "| %-31s |\n";

        System.out.println("+---------------------------------+");
        System.out.printf(headerFormat, shortDescription().toUpperCase());
        System.out.println("+---------------------------------+");

        System.out.printf(format, "Ataque Instântaneo:", this.instantAttack);
        System.out.printf(format, "Preço:", this.price);
        System.out.println("+---------------------------------+\n");

    }

    /**
     * Prints the consumable's name and corresponding instant attack value to the console.
     * This method is useful for showing the combat potential of the item.
     */
    public void showAttackInfo() {
        String headerFormat = "| %-31s |\n";
        System.out.printf(headerFormat, super.name.toUpperCase());
        System.out.printf(headerFormat, "Força: " + this.instantAttack);
    }

    public int getInstantAttack() {
        return instantAttack;
    }

    /**
     * Provides a short description of the CombatConsumable,
     * witch can be used for quick reference.
     *
     * @return A short description of the consumable, including its name.
     */
    @Override
    public String shortDescription() {
        return "Ajuda extra: " + super.name;
    }
}
