package Test.TestHelper;

import Items.Weapon;

public class WeaponCreator {

    public static Weapon createSickRelativeExcuse() {
        return new Weapon("Fingir que tem um familiar doente e usar como desculpa para sair a qualquer momento", 0, LimitationsCreator.internAndSales(), 0, 0);
    }

    public static Weapon createSecretThreat() {
        return new Weapon("Conhecer um segredo dos colegas e ameaçar contá-lo", 0, LimitationsCreator.receptionistOnly(), 0, 0);
    }

    public static Weapon createCEOFriend() {
        return new Weapon("Ser amigo do CEO", 0, LimitationsCreator.salesAndReceptionist(), 0, 0);
    }

    public static Weapon createClientRecommendation() {
        return new Weapon("Ter uma recomendação pessoal de um cliente importante", 0, LimitationsCreator.allHeroes(), 10, 20);
    }

}
