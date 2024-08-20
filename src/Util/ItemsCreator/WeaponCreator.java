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
                "Talvez você consiga ir embora mais cedo e se livrar da missão se convencer o Michael que um familiar doente precisa da sua ajuda."
        );
    }

    public static Weapon createSecretThreat() {
        return new Weapon(
                "Conhecer um Segredo dos Colegas",
                35,
                ItemsLimitationCreator.receptionistOnly(),
                12,
                28,
                "Você pode tentar escapar de uma missão ameaçando expor os segredos dos colegas envolvidos."
        );

    }

    public static Weapon createCEOFriendship() {
        return new Weapon(
                "Poder do CEO",
                25,
                ItemsLimitationCreator.internOnly(),
                8,
                20,
                "Ter uma amizade com o CEO pode te deixar livre das piores tarefas."
        );
    }

    public static Weapon createClientRecommendation() {

        return new Weapon(
                "Recomendação do Cliente",
                50,
                ItemsLimitationCreator.allHeroes(),
                20,
                30,
                "Tente trocar a recomendação de um cliente importante pela execução da tarefa."
        );
    }

}
