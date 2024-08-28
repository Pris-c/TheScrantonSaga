package Util.Creator.ItemsCreator;

import Items.Weapon;

import java.util.ArrayList;
import java.util.Arrays;

public class WeaponCreator {

    public static Weapon createSickRelativeExcuse() {
        return new Weapon(
                "Familiar Doente",
                30,
                ItemsLimitationCreator.salesOnly(),
                10,
                25
        );
    }

    public static Weapon createSecretThreat() {
        return new Weapon(
                "Conhecer Segredo dos Colegas",
                35,
                ItemsLimitationCreator.receptionistOnly(),
                12,
                28
        );

    }

    public static Weapon createCEOFriendship() {
        return new Weapon(
                "Amizade do CEO",
                25,
                ItemsLimitationCreator.internOnly(),
                8,
                20
        );
    }

    public static Weapon createClientRecommendation() {

        return new Weapon(
                "Recomendação de um Cliente",
                50,
                ItemsLimitationCreator.allHeroes(),
                20,
                30
        );
    }

    public static ArrayList<Weapon> initWeapons() {
        return new ArrayList<>(Arrays.asList(createSickRelativeExcuse(), createSecretThreat(), createCEOFriendship(), createClientRecommendation()));
    }
}
