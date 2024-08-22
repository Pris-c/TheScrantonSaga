package Items;

import java.util.ArrayList;

public class Weapon extends ItemHero {

    private int standardAttack;
    private int specialAttack;
    private String standarAttackddescription;
    private String specialAttackdescription;

    public Weapon(String name, int price, ArrayList<String> allowedTo, int standardAttack, int specialAttack, String standarAttackddescription, String specialAttackdescription) {
        super(name, price, allowedTo);
        this.standardAttack = standardAttack;
        this.specialAttack = specialAttack;
        this.standarAttackddescription = standarAttackddescription;
        this.specialAttackdescription = specialAttackdescription;
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

    public String getStandarAttackddescription() {
        return standarAttackddescription;
    }

    public String getSpecialAttackdescription() {
        return specialAttackdescription;
    }

    public int getStandardAttack() {
        return standardAttack;
    }

    public int getSpecialAttack() {
        return specialAttack;
    }
}
