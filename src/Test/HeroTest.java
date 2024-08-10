package Test;

import Entities.Npc;
import Entities.Receptionist;
import Entities.SalesRepresentative;
import Test.TestHelper.HeroCreator;
import Test.TestHelper.NpcCreator;

public class HeroTest {

    public static void main(String[] args) {


/*        SalesRepresentative hero = HeroCreator.createSalesRepresentative();
        hero.showDetails();
        hero.usePotion();
        hero.showDetails();*/

/*        Receptionist receptionist = HeroCreator.createReceptionist();
        receptionist.showDetails();
        receptionist.attack(NpcCreator.createChallenge2());*/

        SalesRepresentative salesRepresentative = HeroCreator.createSalesRepresentative();
        salesRepresentative.showDetails();
        salesRepresentative.attack(NpcCreator.createChallenge3());

    }
}
