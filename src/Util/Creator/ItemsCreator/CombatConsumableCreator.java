package Util.Creator.ItemsCreator;

import Items.CombatConsumable;

import java.util.ArrayList;
import java.util.Arrays;

public class CombatConsumableCreator {

    public static CombatConsumable createDwightHelp() {
        // default to Recepcionist
        return new CombatConsumable(
                "Dwight",
                35,
                ItemsLimitationCreator.internAndReceptionist(),
                40
        );
    }

    public static CombatConsumable createJimHelp() {
        return new CombatConsumable(
                "Jim",
                50,
                ItemsLimitationCreator.allHeroes(),
                45
        );
    }

    public static CombatConsumable createPamHelp() {
        // default to SalesRepresentative
        return new CombatConsumable(
                "Pam",
                45,
                ItemsLimitationCreator.salesAndReceptionist(),
                43
        );
    }

    public static CombatConsumable createPhyllisHelp() {
        return new CombatConsumable(
                "Phyllis",
                40,
                ItemsLimitationCreator.allHeroes(),
                30
        );
    }

    public static CombatConsumable createAngelaHelp() {
        return new CombatConsumable(
                "Angela",
                45,
                ItemsLimitationCreator.allHeroes(),
                35
        );
    }

    public static CombatConsumable createRyanHelp() {
        // default to Intern
        return new CombatConsumable(
                "Ryan",
                50,
                ItemsLimitationCreator.internOnly(),
                40
        );

    }

    public static CombatConsumable createStanleyHelp() {
        return new CombatConsumable(
                "Stanley",
                50,
                ItemsLimitationCreator.internAndSales(),
                48
        );
    }

    public static ArrayList<CombatConsumable> getCombatConsumables() {
        return new ArrayList<>(Arrays.asList(createPamHelp(), createAngelaHelp(), createDwightHelp(), createJimHelp(), createRyanHelp(), createPhyllisHelp()));
    }
}
