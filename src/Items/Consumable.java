package Items;

import java.util.ArrayList;

/**
 * Represents an abstract Consumable item in the game, extending the ItemHero class.
 * Consumables are items that can be used by heroes to provide benefits to the Hero, such as healing, strength
 * increase or a stronger attack.
 * Subclasses must define specific types of Consumables.
 */
public abstract class Consumable extends ItemHero {

    /**
     * Constructs a Consumable item with specified attributes.
     *
     * @param name The name of the Item.
     * @param price The value that the Hero must pay to obtain the item.
     * @param allowedTo A list of Hero types that can buy the item.
     */
    public Consumable(String name, int price, ArrayList<String> allowedTo) {
        super(name, price, allowedTo);
    }

    /**
     * Subclasses must implement this method to give a short overview of the item,
     * which can be used for quick references during the game.
     *
     * @return A short description of the consumable item.
     */
    public abstract String shortDescription();
}
