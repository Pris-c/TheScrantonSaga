package Util.ItemsCreator;

import Items.Potion;

public class PotionCreator {

    public static Potion coffee() {
        return new Potion("Café", 25, ItemsLimitationCreator.allHeroes(), 25, 2);
    }

    public static Potion cerealBar() {
        return new Potion("Barra de Cereal", 20, ItemsLimitationCreator.internOnly(), 15, 1);
    }

    public static Potion eggSalad() {
        return new Potion("Salada de Ovo", 30, ItemsLimitationCreator.allHeroes(), 10, 2);
    }

    public static Potion tunaSandwich() {
        return new Potion("Sanduíche de Atum", 35, ItemsLimitationCreator.salesOnly(), 15, 1);
    }

    public static Potion soda() {
        return new Potion("Refrigerante", 20, ItemsLimitationCreator.allHeroes(), 5, 2);
    }

    public static Potion chocolateBar() {
        return new Potion("Barra de Chocolate", 22, ItemsLimitationCreator.receptionistOnly(), 18, 2);
    }

    public static Potion croissant() {
        return new Potion("Croissant", 28, ItemsLimitationCreator.allHeroes(), 20, 0);
    }

    public static Potion fullMeal() {
        return new Potion("Refeição Completa", 40, ItemsLimitationCreator.allHeroes(), 25, 4);
    }

}