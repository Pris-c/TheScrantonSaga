package Items;

import java.util.ArrayList;

public class Potion extends Consumable {

    private int healing;
    private int strengthIncrement;

    public Potion(String name, int price, ArrayList<String> allowedTo, int healing, int strengthIncrement) {
        super(name, price, allowedTo);
        this.healing = healing;
        this.strengthIncrement = strengthIncrement;
    }

    @Override
    public void showDetails() {
        String format = "| %-20s %-10s |\n";
        String headerFormat = "| %-31s |\n";

        System.out.println("+---------------------------------+");
        System.out.printf(headerFormat, super.name.toUpperCase());
        System.out.println("+---------------------------------+");

        System.out.printf(format, "Recuperação de Hp:", this.healing + " %");
        System.out.printf(format, "Incremento de força:", this.strengthIncrement);
        System.out.printf(format, "Preço:", this.price);
        System.out.println("+---------------------------------+\n");
    }


    public void offerPotion() {
        String format = "| %-20s %-10s |\n";
        String headerFormat = "| %-31s |\n";
        System.out.printf(headerFormat, super.name.toUpperCase());
        System.out.printf(format, "Recuperação de Hp:", this.healing + " %");
        System.out.printf(format, "Incremento de força:", this.strengthIncrement);
        System.out.println("+---------------------------------+\n");
    }

    public int getHealing() {
        return healing;
    }

    public int getStrengthIncrement() {
        return strengthIncrement;
    }

    @Override
    public String shortDescription() {
        return "Lanche: " + super.name;
    }
}
