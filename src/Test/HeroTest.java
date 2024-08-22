package Test;

import Entities.Intern;
import Entities.Npc;
import Entities.Receptionist;
import Entities.SalesRepresentative;
import Test.TestHelper.HeroCreator;
import Util.ItemsCreator.NpcCreator;

public class HeroTest {

    public static void main(String[] args) {

        System.out.println(" ----------- TESTING SHOW DETAILS -----------\n");
        System.out.println(" ----------- HEROES CLASSES -----------\n");
        Receptionist receptionist = HeroCreator.createReceptionist();
        SalesRepresentative salesRepresentative = HeroCreator.createSalesRepresentative();
        Intern intern = HeroCreator.createIntern();
        receptionist.showDetails();
        salesRepresentative.showDetails();
        intern.showDetails();
        System.out.println(" ----------- CHALLENGES -----------\n");
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


/*

        System.out.println(receptionist.getClass().getSimpleName());
        receptionist.showDetails();
        receptionist.attack(NpcCreator.createMichaelLunch());


        salesRepresentative.showDetails();
        salesRepresentative.attack(NpcCreator.createMichaelLunch());


        intern.showDetails();
        System.out.println();
        if (intern.attack(NpcCreator.createMichaelLunch())){
            System.out.println("Parabens, voce venceu");
        } else{
            System.out.println("Fim de jogo");
        }

        Npc npc = NpcCreator.createBasketGame();
        npc.showDetails();


        Weapon weapon = WeaponCreator.createSecretThreat();
        weapon.showDetails();*/

    }
}
