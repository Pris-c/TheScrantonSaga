package Test;

import Entities.Intern;
import Entities.Npc;
import Entities.Receptionist;
import Entities.SalesRepresentative;
import Test.TestHelper.HeroCreator;
import Util.ItemsCreator.NpcCreator;

public class EntitiesTest {

    public static void main(String[] args) {

        System.out.println(" ********************************************\n");
        System.out.println(" *********** TESTING SHOW DETAILS ***********\n");
        System.out.println(" ********************************************\n");
        System.out.println(" *********** HEROES CLASSES ***********\n\n");
        Receptionist receptionist = HeroCreator.createReceptionist();
        SalesRepresentative salesRepresentative = HeroCreator.createSalesRepresentative();
        Intern intern = HeroCreator.createIntern();
        receptionist.showDetails();
        salesRepresentative.showDetails();
        intern.showDetails();
        System.out.println(" *********** CHALLENGES ***********\n\n");
        Npc basketGame = NpcCreator.createBasketGame();
        Npc christmasParty = NpcCreator.createChristmasParty();
        Npc rhMeeting = NpcCreator.createRhMeeting();
        Npc fixingPrinter = NpcCreator.createFixingPrinter();
        Npc michaelLunch = NpcCreator.createMichaelLunch();
        Npc parkourChallenge = NpcCreator.createParkourChallenge();
        Npc recoveringCustomer = NpcCreator.createRecoveringCustomer();
        basketGame.showDetails();
        christmasParty.showDetails();
        rhMeeting.showDetails();
        fixingPrinter.showDetails();
        michaelLunch.showDetails();
        parkourChallenge.showDetails();
        recoveringCustomer.showDetails();


        System.out.println(" ****************************************************\n");
        System.out.println(" *********** TESTING ADD AND DECREMENT HP ***********\n");
        System.out.println(" ****************************************************\n");
        Receptionist receptionist2 = HeroCreator.createReceptionist();

        System.out.println("INICIAL");
        System.out.println("Recepcionist Hp: " + receptionist2.getHp());
        System.out.println("Recepcionist MaxHp: " + receptionist2.getMaxHp());
        receptionist.addHp(500);
        System.out.println("\nADICIONADAS 500 HP");
        System.out.println("Recepcionist Hp: " + receptionist2.getHp());
        System.out.println("Recepcionist MaxHp: " + receptionist2.getMaxHp());
        receptionist2.decrementHp(500);
        System.out.println("\nREMOVIDAS 500 HP");
        System.out.println("Recepcionist Hp: " + receptionist2.getHp());
        System.out.println("Recepcionist MaxHp: " + receptionist2.getMaxHp());


    }
}
