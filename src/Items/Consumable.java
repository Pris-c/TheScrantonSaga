package Items;

import java.util.ArrayList;

public abstract class Consumable extends ItemHero {

    public Consumable(String name, int price, ArrayList<String> allowedTo) {
        super(name, price, allowedTo);
    }

}
