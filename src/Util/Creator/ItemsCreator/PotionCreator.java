package Util.Creator.ItemsCreator;

import Items.Potion;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A utility class for centralize the creation of Potion items.
 */
public class PotionCreator {

    public static Potion coffee() {
        // common to all heroes
        return new Potion("Café", 25, ItemsLimitationCreator.allHeroes(), 25, 2);
    }

    public static Potion cerealBar() {
        return new Potion("Barra de Cereal", 20, ItemsLimitationCreator.internOnly(), 25, 3);
    }

    public static Potion eggSalad() {
        return new Potion("Salada de Ovo", 35, ItemsLimitationCreator.allHeroes(), 40, 8);
    }

    public static Potion tunaSandwich() {
        return new Potion("Sanduíche de Atum", 30, ItemsLimitationCreator.salesOnly(), 35, 5);
    }

    public static Potion soda() {
        return new Potion("Refrigerante", 20, ItemsLimitationCreator.allHeroes(), 10, 2);
    }

    public static Potion chocolateBar() {
        return new Potion("Barra de Chocolate", 25, ItemsLimitationCreator.receptionistOnly(), 30, 2);
    }

    public static Potion croissant() {
        return new Potion("Croissant", 28, ItemsLimitationCreator.allHeroes(), 20, 2);
    }

    public static Potion fullMeal() {
        return new Potion("Refeição Completa", 50, ItemsLimitationCreator.allHeroes(), 50, 10);
    }

    public static ArrayList<Potion> initPotions() {
        return new ArrayList<>(Arrays.asList(coffee(), cerealBar(), eggSalad(), tunaSandwich(), soda(), chocolateBar(), croissant(), fullMeal()));
    }

}
