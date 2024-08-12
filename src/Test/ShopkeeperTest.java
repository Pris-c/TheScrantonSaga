package Test;

import Entities.Receptionist;
import Entities.Shopkeeper;
import Test.TestHelper.CombatConsumableCreator;
import Test.TestHelper.HeroCreator;
import Test.TestHelper.PotionCreator;
import Test.TestHelper.WeaponCreator;

public class ShopkeeperTest {

    public static void main(String[] args) {
        Shopkeeper shopkeeper = new Shopkeeper();
        shopkeeper.addItemToStore(CombatConsumableCreator.createAngelaMartinHelp());
        shopkeeper.addItemToStore(WeaponCreator.createCEOFriend());
        shopkeeper.addItemToStore(PotionCreator.chocolateBar());
        shopkeeper.addItemToStore(WeaponCreator.createUnpayableWeapon());

        Receptionist receptionist = HeroCreator.createReceptionist();

        receptionist.showDetails();
        System.out.println();
        shopkeeper.showsStore(receptionist);
        System.out.println();
        receptionist.showDetails();

    }


}
