package Util.Creator.EnvironmentCreator;

import Game.Shopkeeper;

import static Util.Strings.EnvironmentStrings.ShopkeeperStrings.*;

/**
 * A utility class for centralize the creation of Shopkeeper instances.
 */
public class ShopkeeperCreator {

    private static ShopkeeperCreator instance;

    private ShopkeeperCreator() {
    }

    public static ShopkeeperCreator getInstance() {
        if (instance == null) {
            instance = new ShopkeeperCreator();
        }
        return instance;
    }

    public Shopkeeper getShopkeeperById(int id) {
        switch (id) {
            case 1:
                return new Shopkeeper(1, intShopk1, 1);
            case 2:
                return new Shopkeeper(2, intShopk2, 3);
            case 3:
                return new Shopkeeper(3, intShopk3, ChallengeCreator.getInstance().getById(7));
            default:
                return null;
        }
    }

}
