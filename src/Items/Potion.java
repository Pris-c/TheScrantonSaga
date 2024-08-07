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
        // Shows important information about the Potion
    }
}
