package Test;

import Entities.Shopkeeper;
import Items.CombatConsumable;
import Items.ItemHero;
import Items.Potion;
import Items.Weapon;
import Test.TestHelper.HeroCreator;
import Util.Creator.ItemsCreator.CombatConsumableCreator;
import Util.Creator.ItemsCreator.PotionCreator;
import Util.Creator.ItemsCreator.WeaponCreator;

import java.util.ArrayList;

public class ShopkeeperTest {

    public static void main(String[] args) {


        // --------  Test to Shopkeeper showStore()
        Shopkeeper shopkeeper = initShopkeeper();
        shopkeeper.showsStore(HeroCreator.createReceptionist());

    }


    // Copy of private method initShopkeeper from class Game
    public static Shopkeeper initShopkeeper() {
        ArrayList<Weapon> weapons = WeaponCreator.initWeapons();
        ArrayList<CombatConsumable> combatConsumables = CombatConsumableCreator.getCombatConsumables();
        ArrayList<Potion> potions = PotionCreator.initPotions();

        ArrayList<ItemHero> shop = new ArrayList<>();
        shop.addAll(weapons);
        shop.addAll(combatConsumables);
        shop.addAll(potions);
        return new Shopkeeper(shop);
    }


}
