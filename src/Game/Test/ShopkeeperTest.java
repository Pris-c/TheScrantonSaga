package Game.Test;

import Entities.Hero;
import Game.Shopkeeper;
import Test.TestHelper.HeroCreator;

import static Game.EnvironmentCreator.ShopkeeperCreator.getShopkeeperById;

public class ShopkeeperTest {

    public static void main(String[] args) {

        Shopkeeper shopkeeper1 = getShopkeeperById(1);
        Shopkeeper shopkeeper2 = getShopkeeperById(2);
        Shopkeeper shopkeeper3 = getShopkeeperById(3);

        Hero hero = HeroCreator.createReceptionist();

        System.out.println("Shopkeeper 1");
        shopkeeper1.run(hero);
        System.out.println();

        System.out.println("Shopkeeper 2");
        shopkeeper2.run(hero);
        System.out.println();

        System.out.println("Shopkeeper 3");
        shopkeeper3.run(hero);
        System.out.println();

    }

}
