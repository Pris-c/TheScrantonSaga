package Items;

import java.util.ArrayList;

public class Weapon extends ItemHero{

    private int standardAttack;
    private int specialAttack;

    public Weapon(String name, int price, ArrayList<String> allowedTo, int standardAttack, int specialAttack) {
        super(name, price, allowedTo);
        this.standardAttack = standardAttack;
        this.specialAttack = specialAttack;
    }

    @Override
    public void showDetails() {
        System.out.println("** Arma: " + super.name + " **");
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
