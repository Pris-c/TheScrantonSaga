package Items;

import java.util.ArrayList;

public abstract class ItemHero {

    protected String name;
    protected int price;
    protected ArrayList<String> allowedTo;

    public ItemHero(String name, int price, ArrayList<String> allowedTo) {
        this.name = name;
        this.price = price;
        this.allowedTo = allowedTo;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public ArrayList<String> getAllowedTo() {
        return allowedTo;
    }

    public abstract void showDetails();
}
