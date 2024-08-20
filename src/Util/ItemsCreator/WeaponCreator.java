package Util.ItemsCreator;

import Items.Weapon;

public class WeaponCreator {

    public static Weapon createSickRelativeExcuse() {
        return new Weapon(
                "Arma do Falso Familiar Doente",
                30,
                ItemsLimitationCreator.salesOnly(),
                10,
                25,
                "Você tentou convencer o Michael que precisa ir embora para ajudar um familiar doente.",
                "Você tentou convencer o Michael de que sua avó acabou de morrer e que você precisa ir para o funeral."
        );
    }

    public static Weapon createSecretThreat() {
        return new Weapon(
                "Conhecer um Segredo dos Colegas",
                35,
                ItemsLimitationCreator.receptionistOnly(),
                12,
                28,
                "Você ameaçou expor um grande segredo sobre alguém do departamento se não for liberado da missão.",
                "Você ameaçou mencionar uma história do Michael para a Jan se não for liberado da missão."
        );

    }

    public static Weapon createCEOFriendship() {
        return new Weapon(
                "Poder do CEO",
                25,
                ItemsLimitationCreator.internOnly(),
                8,
                20,
                "Você lembra a todos sobre sua amizade com o CEO da Dunder Mifflin.",
                "Você lembra a todos que é sobrinho do CEO da Dunder Mifflin."
        );
    }

    public static Weapon createClientRecommendation() {

        return new Weapon(
                "Recomendação do Cliente",
                50,
                ItemsLimitationCreator.allHeroes(),
                20,
                30,
                "Você ofereceu o contacto de um possível grande cliente em troca de não precisar cumprir a missão.",
                "Você ofereceu o contacto do maior cliene da empresa concorrente em troca de não precisar cumprir a missão."
        );
    }

}
