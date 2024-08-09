package Test.TestHelper;

import Items.CombatConsumable;

import java.util.ArrayList;
import java.util.Arrays;

public class CombatConsumableCreator {

    public static CombatConsumable createDwightSchruteHelp() {
        return new CombatConsumable("Ajuda do Dwight Schrute", 10, new ArrayList<>(Arrays.asList("Intern", "SalesRepresentative", "Receptionist")), 40);
    }

    public static CombatConsumable createJimHalpertHelp() {
        return new CombatConsumable("Ajuda do Jim Halpert", 15, new ArrayList<>(Arrays.asList("Intern", "SalesRepresentative", "Receptionist")), 60);
    }

    public static CombatConsumable createPamBeeslyHelp() {
        return new CombatConsumable("Ajuda da Pam Beesly", 12, new ArrayList<>(Arrays.asList("Intern", "SalesRepresentative", "Receptionist")), 50);
    }

    public static CombatConsumable createPhyllisVanceHelp() {
        return new CombatConsumable("Ajuda da Phyllis Vance", 14, new ArrayList<>(Arrays.asList("Intern", "SalesRepresentative", "Receptionist")), 50);
    }

    public static CombatConsumable createAngelaMartinHelp() {
        return new CombatConsumable("Ajuda da Angela Martin", 10, new ArrayList<>(Arrays.asList("Intern", "SalesRepresentative", "Receptionist")), 40);
    }

    public static CombatConsumable createRyanHowardHelp() {
        return new CombatConsumable("Ajuda do Ryan Howard", 13, new ArrayList<>(Arrays.asList("Intern", "SalesRepresentative", "Receptionist")), 40);
    }

    public static CombatConsumable createStanleyHudsonHelp() {
        return new CombatConsumable("Ajuda do Stanley Hudson", 16, new ArrayList<>(Arrays.asList("Intern", "SalesRepresentative", "Receptionist")), 50);
    }
}
