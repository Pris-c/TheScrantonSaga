package Entities.Test;

import Entities.Hero;
import Test.TestHelper.HeroCreator;

public class HeroTest {

    public static void main(String[] args) {

        Hero hero = HeroCreator.createReceptionist();

/*        System.out.println("------ Testing changes in HP ------ ");
        System.out.println("Hp: " + hero.getHp());
        System.out.println("Decrement 30");
        hero.decrementHp(30);
        System.out.println("Hp: " + hero.getHp());
        System.out.println("Increment 10%");
        hero.incrementHp(10);
        System.out.println("Hp: " + hero.getHp());*/

/*        System.out.println("------ Testing use Potion ------ ");
        hero.decrementHp(50);
        System.out.println("Hp: " + hero.getHp());
        System.out.println("Strength: " + hero.getStrength());
        System.out.println("Using potion");
        hero.usePotion();
        System.out.println("Hp: " + hero.getHp());
        System.out.println("Strength: " + hero.getStrength());*/

        hero.showDetails();

    }
}
