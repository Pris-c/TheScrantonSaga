package Util.Creator.ItemsCreator;

import Items.CombatConsumable;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A utility class for centralize the creation of CombatConsumable items.
 */
public class CombatConsumableCreator {

    public static CombatConsumable createDwightHelp() {
        // default to Recepcionist
        return new CombatConsumable(
                "Dwight",
                35,
                ItemsLimitationCreator.internAndReceptionist(),
                70
        );
    }

    public static CombatConsumable createJimHelp() {
        return new CombatConsumable(
                "Jim",
                40,
                ItemsLimitationCreator.allHeroes(),
                80
        );
    }

    public static CombatConsumable createPamHelp() {
        // default to SalesRepresentative
        return new CombatConsumable(
                "Pam",
                50,
                ItemsLimitationCreator.salesAndReceptionist(),
                100
        );
    }

    public static CombatConsumable createPhyllisHelp() {
        return new CombatConsumable(
                "Phyllis",
                30,
                ItemsLimitationCreator.allHeroes(),
                70
        );
    }

    public static CombatConsumable createAngelaHelp() {
        return new CombatConsumable(
                "Angela",
                35,
                ItemsLimitationCreator.allHeroes(),
                75
        );
    }

    public static CombatConsumable createRyanHelp() {
        // default to Intern
        return new CombatConsumable(
                "Ryan",
                40,
                ItemsLimitationCreator.internOnly(),
                80
        );

    }

    public static CombatConsumable createStanleyHelp() {
        return new CombatConsumable(
                "Stanley",
                50,
                ItemsLimitationCreator.internAndSales(),
                110
        );
    }

    public static ArrayList<CombatConsumable> getCombatConsumables() {
        return new ArrayList<>(Arrays.asList(createPamHelp(), createAngelaHelp(), createDwightHelp(), createJimHelp(), createRyanHelp(), createPhyllisHelp()));
    }
}
