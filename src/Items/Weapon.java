package Items;

import java.util.ArrayList;

public class Weapon extends ItemHero{

    private int standardAttack;
    private int specialAttack;
    private String description;

    public Weapon(String name, int price, ArrayList<String> allowedTo, int standardAttack, int specialAttack, String description) {
        super(name, price, allowedTo);
        this.standardAttack = standardAttack;
        this.specialAttack = specialAttack;
        this.description = description;
    }

    @Override
    public void showDetails() {
        System.out.println("** Arma: " + super.name + " **");
        System.out.println("Descrição: " + this.description);
        System.out.println("Ataque comum: " + this.standardAttack);
        System.out.println("Ataque especial: " + this.specialAttack);
        super.showDetails();
    }

    public int getStandardAttack() {
        return standardAttack;
    }

    public int getSpecialAttack() {
        return specialAttack;
    }
}
