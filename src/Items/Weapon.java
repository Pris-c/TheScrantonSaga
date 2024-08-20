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
        System.out.println("** Arma: " + super.name + " **");
        System.out.println("Descrição: " + this.standarAttackddescription);
        System.out.println("Ataque comum: " + this.standardAttack);
        System.out.println("Ataque especial: " + this.specialAttack);
        super.showDetails();
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
