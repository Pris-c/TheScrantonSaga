package Test.TestHelper;

import Entities.Intern;
import Entities.Receptionist;
import Entities.SalesRepresentative;
import Items.Potion;
import Items.Weapon;

import java.util.ArrayList;

public class HeroCreator {

    public static Intern createIntern() {
        WeaponCreator WeaponCreator;
        Weapon weapon = Test.TestHelper.WeaponCreator.createSickRelativeExcuse();
        ArrayList<Potion> inventory = new ArrayList<>();
        inventory.add(PotionCreator.coffee());
        inventory.add(PotionCreator.cerealBar());
        return new Intern("José", 100, 10, 50, weapon, new ArrayList<>(inventory));
    }

    public static SalesRepresentative createSalesRepresentative() {
        Weapon weapon = WeaponCreator.createSecretThreat();
        ArrayList<Potion> inventory = new ArrayList<>();
        inventory.add(PotionCreator.eggSalad());
        inventory.add(PotionCreator.soda());
        return new SalesRepresentative("Jéssica", 120, 12, 75, weapon, new ArrayList<>(inventory));
    }

    public static Receptionist createReceptionist() {
        Weapon weapon = WeaponCreator.createCEOFriend();
        ArrayList<Potion> inventory = new ArrayList<>();
        inventory.add(PotionCreator.tunaSandwich());
        inventory.add(PotionCreator.fullMeal());
        return new Receptionist("Diego", 110, 11, 60, weapon, new ArrayList<>(inventory));
    }
}
