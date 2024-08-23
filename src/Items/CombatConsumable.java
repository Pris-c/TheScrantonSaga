package Items;

import java.util.ArrayList;

public class CombatConsumable extends Consumable {

    private int instantAttack;

    public CombatConsumable(String name, int price, ArrayList<String> allowedTo, int instantAttack) {
        super(name, price, allowedTo);
        this.instantAttack = instantAttack;
    }

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

    public void showAttackInfo() {
        String headerFormat = "| %-31s |\n";
        System.out.printf(headerFormat, super.name.toUpperCase());
        System.out.printf(headerFormat, "Força: " + this.instantAttack);
    }

    public int getInstantAttack() {
        return instantAttack;
    }

    @Override
    public String shortDescription() {
        return "Ajuda extra: " + super.name;
    }
}
