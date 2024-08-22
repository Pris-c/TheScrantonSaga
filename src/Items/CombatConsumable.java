package Items;

import java.util.ArrayList;

public class CombatConsumable extends Consumable {

    private int instantAttack;
    private String description;

    public CombatConsumable(String name, int price, ArrayList<String> allowedTo, int instantAttack, String description) {
        super(name, price, allowedTo);
        this.instantAttack = instantAttack;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public void showDetails() {
        String format = "| %-20s %-10s |\n";
        String headerFormat = "| %-31s |\n";

        System.out.println("+---------------------------------+");
        System.out.printf(headerFormat, "AJUDA DA " + super.name.toUpperCase());
        System.out.println("+---------------------------------+");

        System.out.printf(format, "Ataque Instântaneo:", this.instantAttack);
        System.out.printf(format, "Preço:", this.price);
        System.out.println("+---------------------------------+\n");

    }

    public void showAttackInfo() {
        System.out.println("\t" + super.name);
        System.out.println("\tForça da ajuda: " + this.instantAttack);
    }

    public int getInstantAttack() {
        return instantAttack;
    }
}
