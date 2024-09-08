package Test.GameTest;

import Entities.Hero;
import Game.Challenge;
import Util.Creator.EnvironmentCreator.ChallengeCreator;
import Test.TestHelper.HeroCreator;

/**
 * This class is used to test Challenge methods
 */
public class ChallengeTest {

    public static void main(String[] args) {

        Challenge challengeTest7 = ChallengeCreator.getInstance().getById(7);
        Challenge challengeTest6 = ChallengeCreator.getInstance().getById(6);
        Challenge challengeTest5 = ChallengeCreator.getInstance().getById(5);
        Challenge challengeTest4 = ChallengeCreator.getInstance().getById(4);
        Challenge challengeTest3 = ChallengeCreator.getInstance().getById(3);
        Challenge challengeTest2 = ChallengeCreator.getInstance().getById(2);
        Challenge challengeTest1 = ChallengeCreator.getInstance().getById(1);

        //Hero hero = HeroCreator.createSalesRepresentative();
        Hero hero = HeroCreator.createReceptionist();
        System.out.println();
        System.out.println("---------------- Challenge 1: ");
        challengeTest1.run(hero);
        System.out.println();
        System.out.println("---------------- Challenge 2: ");
        challengeTest2.run(hero);
        System.out.println();
        System.out.println("---------------- Challenge 3: ");
        challengeTest3.run(hero);
        System.out.println();
        System.out.println(" ---------------- Challenge 4: ");
        challengeTest4.run(hero);
        System.out.println();
        System.out.println(" --------------- Challenge 5: ");
        challengeTest5.run(hero);
        System.out.println();
        System.out.println("--------------- Challenge 6: ");
        challengeTest6.run(hero);
        System.out.println();
        System.out.println(" -------------- Challenge 7: ");
        challengeTest7.run(hero);
    }

}
