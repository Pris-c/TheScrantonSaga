package Test.GameTest;

import Entities.Hero;
import Game.Shopkeeper;
import Test.TestHelper.HeroCreator;
import Util.Creator.EnvironmentCreator.ShopkeeperCreator;

/**
 * This class is used to test Shopkeeper methods
 */
public class ShopkeeperTest {

    public static void main(String[] args) {

        Shopkeeper shopkeeper1 = ShopkeeperCreator.getInstance().getShopkeeperById(1);
        Shopkeeper shopkeeper2 = ShopkeeperCreator.getInstance().getShopkeeperById(2);
        Shopkeeper shopkeeper3 = ShopkeeperCreator.getInstance().getShopkeeperById(3);

        Hero hero = HeroCreator.createReceptionist();

        System.out.println("Shopkeeper 1");
        shopkeeper1.run(hero);
        System.out.println();

     /*   System.out.println("Shopkeeper 2");
        shopkeeper2.run(hero);
        System.out.println();

        System.out.println("Shopkeeper 3");
        shopkeeper3.run(hero);
        System.out.println();
*/
    }

}
