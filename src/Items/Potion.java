package Items;

import java.util.ArrayList;

/**
 * Represents a Potion in the game, extending the Consumable class.
 * Potions can heal the hero and/or increase their strength.
 * This class includes attributes for healing and strength increment values.
 */
public class Potion extends Consumable {

    private int healing;
    private int strengthIncrement;

    /**
     * Constructs a Potion with specified attributes.
     *
     * @param name              The name of the potion.
     * @param price             The value that the Hero must pay to obtain the potion.
     * @param allowedTo         A list of Hero types that can use the potion.
     * @param healing           The amount of health the potion restores.
     * @param strengthIncrement The amount of strength the potion adds.
     */
    public Potion(String name, int price, ArrayList<String> allowedTo, int healing, int strengthIncrement) {
        super(name, price, allowedTo);
        this.healing = healing;
        this.strengthIncrement = strengthIncrement;
    }

    /**
     * Prints information about the Potion to the console.
     * This includes the potion's healing amount, strength increment, and price.
     */
    @Override
    public void showDetails() {
        String format = "| %-20s %-10s |\n";
        String headerFormat = "| %-31s |\n";

        System.out.println("+---------------------------------+");
        System.out.printf(headerFormat, super.name.toUpperCase());
        System.out.println("+---------------------------------+");

        System.out.printf(format, "Recuperação de vida:", this.healing);
        System.out.printf(format, "Incremento de força:", this.strengthIncrement);
        System.out.printf(format, "Preço:", this.price);
        System.out.println("+---------------------------------+\n");
    }


    /**
     * Print to the console the potion's benefits when offering it to the player.
     */
    public void presentPotionBenefits() {
        String format = "| %-20s %-10s |\n";
        String headerFormat = "| %-31s |\n";
        System.out.printf(headerFormat, super.name.toUpperCase());
        System.out.printf(format, "Recuperação de vida:", this.healing);
        System.out.printf(format, "Incremento de força:", this.strengthIncrement);
        System.out.println("+---------------------------------+\n");
    }

    public int getHealing() {
        return healing;
    }

    public int getStrengthIncrement() {
        return strengthIncrement;
    }

    /**
     * Provides a short description of the Potion,
     * witch can be used for quick reference.
     *
     * @return A short description of the Potion, including its name.
     */
    @Override
    public String shortDescription() {
        return "Lanche: " + super.name;
    }
}
