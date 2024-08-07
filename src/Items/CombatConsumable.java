package Items;

import java.util.ArrayList;

public class CombatConsumable extends Consumable{

    private int instantAttack;

    public CombatConsumable(String name, int price, ArrayList<String> allowedTo, int instantAttack) {
        super(name, price, allowedTo);
        this.instantAttack = instantAttack;
    }

    @Override
    public void showDetails() {
        // Shows important information about the Combat Consumable
    }

}
