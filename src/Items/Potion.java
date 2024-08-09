package Items;

import java.util.ArrayList;

public class Potion extends Consumable{

    private int healing;
    private int strengthIncrement;

    public Potion(String name, int price, ArrayList<String> allowedTo, int healing, int strengthIncrement) {
        super(name, price, allowedTo);
        this.healing = healing;
        this.strengthIncrement = strengthIncrement;
    }

    @Override
    public void showDetails() {
        System.out.println("** Detalhes da Poção **");
        System.out.println("Recuperação de Hp: " + this.healing);
        System.out.println("Incremento de força: " + this.strengthIncrement);
        super.showDetails();
    }

    public int getHealing() {
        return healing;
    }

    public int getStrengthIncrement() {
        return strengthIncrement;
    }
}
