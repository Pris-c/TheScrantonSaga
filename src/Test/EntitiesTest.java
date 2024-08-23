package Test;

import Entities.*;
import Items.CombatConsumable;
import Test.TestHelper.HeroCreator;
import Util.ItemsCreator.CombatConsumableCreator;
import Util.ItemsCreator.NpcCreator;
import Util.ItemsCreator.PotionCreator;
import Util.ItemsCreator.WeaponCreator;

public class EntitiesTest {

    public static void main(String[] args) {
/*
        System.out.println(" ********************************************\n");
        System.out.println(" *********** TESTING SHOW DETAILS ***********\n");
        System.out.println(" ********************************************\n");
        System.out.println(" *********** HEROES CLASSES ***********\n\n");
        Receptionist receptionist = HeroCreator.createReceptionist();
        SalesRepresentative salesRepresentative = HeroCreator.createSalesRepresentative();

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
*/
/*

        System.out.println(" ********************************************\n");
        System.out.println(" *********** TESTING HERO METHODS ***********\n\n");
        System.out.println(" ********************************************\n");

        System.out.println(" *********** TESTING SET MAIN WEAPON ***********\n");
        SalesRepresentative salesRepresentative2 = HeroCreator.createSalesRepresentative();
        salesRepresentative2.showDetails();
        System.out.println(" *********** CHANGING MAIN WEAPON  ***********\n\n");
        salesRepresentative2.setMainWeapon(WeaponCreator.createSickRelativeExcuse());
        salesRepresentative2.showDetails();
*/

/*
        System.out.println(" *********** TESTING PAY ***********\n");
        SalesRepresentative salesRepresentative3 = HeroCreator.createSalesRepresentative();
        salesRepresentative3.showDetails();
        System.out.println(" *********** CHANGING MAIN WEAPON  ***********\n\n");
        System.out.println("PAGAR VALOR POSSIVEL: " + salesRepresentative3.pay(5));
        System.out.println("PAGAR VALOR IMPOSSIVEL: " + salesRepresentative3.pay(200));
*/

/*
        System.out.println(" *********** TESTING ADD CONSUMABLE ***********\n");
        Intern internToTestAddConsumable = HeroCreator.createIntern();
        internToTestAddConsumable.showDetails();
        System.out.println(" *********** ADD ITEMS  ***********\n\n");
        internToTestAddConsumable.addConsumableToInventory(CombatConsumableCreator.createDwightHelp());
        internToTestAddConsumable.addConsumableToInventory(PotionCreator.cerealBar());
        internToTestAddConsumable.showDetails();
*/
/*
        System.out.println(" *********** TESTING USE POTION ***********\n");
        Intern internToTestUsePotion = HeroCreator.createIntern();
        internToTestUsePotion.addConsumableToInventory(PotionCreator.croissant());
        internToTestUsePotion.showDetails();
        System.out.println(" *********** CALLING USE POTION ***********\n\n");
        internToTestUsePotion.usePotion();
        internToTestUsePotion.showDetails();
*/

/*

        System.out.println(" *********** TESTING INSTANT ATTACK ***********\n");
        Intern internToInstantAttack = HeroCreator.createIntern();
        internToInstantAttack.showDetails();
        System.out.println(" *********** USING ATTACK ***********\n\n");
        System.out.println("Intant attack: " + internToInstantAttack.instantAttack());

*/


        System.out.println(" **********************************************");
        System.out.println(" *********** TESTING INTERN METHODS ***********");
        System.out.println(" **********************************************\n");

        System.out.println(" *********** TESTING SHOW DETAILS ***********");
        Intern intern = HeroCreator.createIntern();
        intern.showDetails();

        System.out.println(" *********** TESTING ATTACK ***********");
        System.out.println("Attack result: " + intern.attack(NpcCreator.createChristmasParty()));







    }
}
