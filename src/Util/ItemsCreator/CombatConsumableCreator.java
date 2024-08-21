package Util.ItemsCreator;

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
                40,
                "Dwight alcança uma arma escondida assustando a todos e facilitando sua esquiva da missão."
        );
    }

    public static CombatConsumable createJimHelp() {
        return new CombatConsumable(
                "Jim",
                50,
                ItemsLimitationCreator.allHeroes(),
                45,
                "Jim faz uma piada perfeita, distraindo todos enquanto você tenta escapar do problema."
        );
    }

    public static CombatConsumable createPamHelp() {
        // default to SalesRepresentative
        return new CombatConsumable(
                "Pam",
                45,
                ItemsLimitationCreator.salesAndReceptionist(),
                43,
                "Pam chama toda gente para ver o novo quadro que pintou da Dunder Mifflin. Aproveite a distração!"
        );
    }

    public static CombatConsumable createPhyllisHelp() {
        return new CombatConsumable(
                "Phyllis",
                40,
                ItemsLimitationCreator.allHeroes(),
                30,
                "Phyllis interrompe a missão para pedir dinheiro para a próxima festa. Aproveite o tempo extra."
        );
    }

    public static CombatConsumable createAngelaHelp() {
        return new CombatConsumable(
                "Angela",
                45,
                ItemsLimitationCreator.allHeroes(),
                35,
                "Angela usa um vídeo dos seus gatos para distrair a todos enquanto você tenta sair de fininho."
        );
    }

    public static CombatConsumable createRyanHelp() {
        // default to Intern
        return new CombatConsumable(
                "Ryan",
                50,
                ItemsLimitationCreator.internOnly(),
                40,
                "Ryan oferece ideias 'inovadoras' para solucionar o problema por você."
        );

    }

    public static CombatConsumable createStanleyHelp() {
        return new CombatConsumable(
                "Stanley",
                50,
                ItemsLimitationCreator.internAndSales(),
                48,
                "Stanley simula um novo ataque cardiaco e ganha a atenção de todos, te dando tempo extra para resolver o problema"
        );
    }

    public static ArrayList<CombatConsumable> initCombatConsumables() {
        return new ArrayList<>(Arrays.asList(createPamHelp(), createAngelaHelp(), createDwightHelp(), createJimHelp(), createRyanHelp(), createPhyllisHelp()));
    }
}
