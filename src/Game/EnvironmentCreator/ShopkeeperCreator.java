package Game.EnvironmentCreator;

import Game.Shopkeeper;

import static Game.EnvironmentCreator.Strings.ShopkeeperStrings.*;

public class ShopkeeperCreator {

    public static Shopkeeper getShopkeeperById(int id) {
        switch (id) {
            case 1:
                return new Shopkeeper(1, intShopk1);
            case 2:
                return new Shopkeeper(2, intShopk2);
            case 3:
                return new Shopkeeper(3, intShopk3);
            default:
                return null;
        }
    }

}
