package Test.TestHelper;

import Items.Potion;

public class PotionCreator {

    public static Potion coffee() {
        return new Potion("Café", 2, LimitationsCreator.allHeroes(), 25, 5);
    }

    public static Potion cerealBar() {
        return new Potion("Barra de Cereal", 3, LimitationsCreator.internOnly(), 15, 3);
    }

    public static Potion eggSalad() {
        return new Potion("Salada de Ovo", 5, LimitationsCreator.salesAndReceptionist(), 10, 4);
    }

    public static Potion tunaSandwich() {
        return new Potion("Sanduíche de Atum", 7, LimitationsCreator.salesOnly(), 20, 6);
    }

    public static Potion soda() {
        return new Potion("Refrigerante", 4, LimitationsCreator.internAndSales(), 15, 3);
    }

    public static Potion chocolateBar() {
        return new Potion("Barra de Chocolate", 6, LimitationsCreator.salesAndReceptionist(), 20, 5);
    }

    public static Potion croissant() {
        return new Potion("Croissant", 5, LimitationsCreator.allHeroes(), 15, 4);
    }

    public static Potion fullMeal() {
        return new Potion("Refeição Completa", 10, LimitationsCreator.receptionistOnly(), 50, 10);
    }

}
