package Test.TestHelper;

import Items.CombatConsumable;

import java.util.ArrayList;
import java.util.Arrays;

public class CombatConsumableCreator {

    public static CombatConsumable createDwightHelp() {
        return new CombatConsumable(
                "Ajuda do Dwight",
                35,
                LimitationsCreator.internAndReceptionist(),
                40,
                "Dwight alcança uma arma escondida e amedronta o inimigo."
        );
    }

    public static CombatConsumable createJimHelp() {
        return new CombatConsumable(
                "Ajuda do Jim",
                50,
                LimitationsCreator.allHeroes(),
                45,
                "Jim prega uma pegadinha no inimigo, distraindo-o."
        );
    }

    public static CombatConsumable createPamHelp() {
        return new CombatConsumable(
                "Ajuda da Pam",
                45,
                LimitationsCreator.salesAndReceptionist(),
                43,
                "Pam usa suas habilidades com pessoas para enganar o inimigo."
        );
    }

    public static CombatConsumable createPhyllisHelp() {
        return new CombatConsumable(
                "Ajuda da Phyllis",
                40, LimitationsCreator.allHeroes(),
                30,
                "Phyllis usa sua diplomacia para entediar o inimigo."
        );
    }

    public static CombatConsumable createAngelaHelp() {
        return new CombatConsumable(
                "Ajuda da Angela",
                45, LimitationsCreator.allHeroes(),
                35,
                "Angela convoca seus gatos para distrair o inimigo."
        );
    }

    public static CombatConsumable createRyanHelp() {
        return new CombatConsumable(
                "Ajuda do Ryan",
                50, LimitationsCreator.internOnly(),
                40,
                "Ryan oferece ideias 'inovadoras' que confundem o inimigo."
        );

    }

    public static CombatConsumable createStanleyHudsonHelp() {
        return new CombatConsumable(
                "Ajuda do Stanley",
                50,
                LimitationsCreator.salesAndReceptionist(),
                48,
                "Stanley usa sua paciência para cansar o inimigo."
        );
    }
}
