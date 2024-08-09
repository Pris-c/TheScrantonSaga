package Test;

import Entities.SalesRepresentative;
import Test.TestHelper.HeroCreator;

public class HeroTest {

    public static void main(String[] args) {
        SalesRepresentative hero = HeroCreator.createSalesRepresentative();

        hero.showDetails();
        hero.usePotion();
        hero.showDetails();


    }
}
