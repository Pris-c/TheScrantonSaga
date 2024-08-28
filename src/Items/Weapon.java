package Items;

import java.util.ArrayList;

public class Weapon extends ItemHero {

    private int standardAttack;
    private int specialAttack;

    public Weapon(String name, int price, ArrayList<String> allowedTo, int standardAttack, int specialAttack) {
        super(name, price, allowedTo);
        this.standardAttack = standardAttack;
        this.specialAttack = specialAttack;
    }

    @Override
    public void showDetails() {
        String format = "| %-20s %-10s |\n";
        String headerFormat = "| %-31s |\n";

        System.out.println("+---------------------------------+");
        System.out.printf(headerFormat, super.name.toUpperCase());
        System.out.println("+---------------------------------+");

        System.out.printf(format, "Ataque comum:", this.standardAttack);
        System.out.printf(format, "Ataque especial:", this.specialAttack);
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
