package Items;

import java.util.ArrayList;

/**
 * Represents an abstract item in the game, that can be used by certain types of Heroes.
 * It has the attributes name, price, and allowedTo, an ArrayList to define witch Hero can use each item.
 * Subclasses must define specific types of ItemHero.
 */
public abstract class ItemHero {

    protected String name;
    protected int price;
    protected ArrayList<String> allowedTo;

    /**
     * Constructs an ItemHero with specified attributes.
     *
     * @param name      The name of the Item.
     * @param price     The value that the Hero must pay to obtain the item.
     * @param allowedTo A list of Hero types that can buy the item.
     */
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

    /**
     * Abstract method to be implemented by subclasses to displays the details of the item.
     */
    public abstract void showDetails();
}
