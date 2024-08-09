package Test.TestHelper;

import Entities.Intern;
import Entities.Receptionist;
import Entities.SalesRepresentative;
import Items.Consumable;
import Items.Potion;
import Items.Weapon;

import java.util.ArrayList;

public class HeroCreator {

    public static Intern createIntern() {
        WeaponCreator WeaponCreator;
        Weapon weapon = Test.TestHelper.WeaponCreator.createSickRelativeExcuse();
        ArrayList<Consumable> inventory = new ArrayList<>();
        inventory.add(PotionCreator.coffee());
        inventory.add(PotionCreator.cerealBar());
        inventory.add(CombatConsumableCreator.createRyanHowardHelp());
        inventory.add(CombatConsumableCreator.createStanleyHudsonHelp());

        return new Intern("José", 100, 10, 50, weapon, new ArrayList<>(inventory));
    }

    public static SalesRepresentative createSalesRepresentative() {
        Weapon weapon = WeaponCreator.createSecretThreat();
        ArrayList<Consumable> inventory = new ArrayList<>();
        inventory.add(PotionCreator.eggSalad());
        inventory.add(PotionCreator.soda());
        inventory.add(CombatConsumableCreator.createDwightSchruteHelp());
        inventory.add(CombatConsumableCreator.createAngelaMartinHelp());
        return new SalesRepresentative("Jéssica", 120, 12, 75, weapon, new ArrayList<>(inventory));
    }

    public static Receptionist createReceptionist() {
        Weapon weapon = WeaponCreator.createCEOFriend();
        ArrayList<Consumable> inventory = new ArrayList<>();
        inventory.add(PotionCreator.tunaSandwich());
        inventory.add(PotionCreator.fullMeal());
        inventory.add(CombatConsumableCreator.createPamBeeslyHelp());
        inventory.add(CombatConsumableCreator.createJimHalpertHelp());
        return new Receptionist("Diego", 110, 11, 60, weapon, new ArrayList<>(inventory));
    }
}
