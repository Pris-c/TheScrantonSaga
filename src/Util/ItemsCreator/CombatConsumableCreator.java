package Util.ItemsCreator;

import Items.CombatConsumable;

public class CombatConsumableCreator {

    public static CombatConsumable createDwightHelp() {
        return new CombatConsumable(
                "Ajuda do Dwight",
                35,
                ItemsLimitationCreator.internAndReceptionist(),
                40,
                "Dwight alcança uma arma escondida e amedronta o inimigo."
        );
    }

    public static CombatConsumable createJimHelp() {
        return new CombatConsumable(
                "Ajuda do Jim",
                50,
                ItemsLimitationCreator.allHeroes(),
                45,
                "Jim prega uma pegadinha no inimigo, distraindo-o."
        );
    }

    public static CombatConsumable createPamHelp() {
        return new CombatConsumable(
                "Ajuda da Pam",
                45,
                ItemsLimitationCreator.salesAndReceptionist(),
                43,
                "Pam usa suas habilidades com pessoas para enganar o inimigo."
        );
    }

    public static CombatConsumable createPhyllisHelp() {
        return new CombatConsumable(
                "Ajuda da Phyllis",
                40,
                ItemsLimitationCreator.allHeroes(),
                30,
                "Phyllis usa sua diplomacia para entediar o inimigo."
        );
    }

    public static CombatConsumable createAngelaHelp() {
        return new CombatConsumable(
                "Ajuda da Angela",
                45,
                ItemsLimitationCreator.allHeroes(),
                35,
                "Angela convoca seus gatos para distrair o inimigo."
        );
    }

    public static CombatConsumable createRyanHelp() {
        return new CombatConsumable(
                "Ajuda do Ryan",
                50,
                ItemsLimitationCreator.internOnly(),
                40,
                "Ryan oferece ideias 'inovadoras' que confundem o inimigo."
        );

    }

    public static CombatConsumable createStanleyHudsonHelp() {
        return new CombatConsumable(
                "Ajuda do Stanley",
                50,
                ItemsLimitationCreator.salesAndReceptionist(),
                48,
                "Stanley usa sua paciência para cansar o inimigo."
        );
    }
}
