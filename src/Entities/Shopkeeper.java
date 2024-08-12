package Entities;

import Items.Consumable;
import Items.ItemHero;
import Items.Weapon;
import Util.Util;

import java.util.ArrayList;
import java.util.Random;

public class Shopkeeper {

    private ArrayList<ItemHero> store;

    public Shopkeeper() {
        this.store = new ArrayList<>();
    }


    public void addItemToStore(ItemHero item) {
        if (!this.store.contains(item)) {
            this.store.add(item);
        }

    }

    public void showsStore(Hero hero) {
        // Shows 10 random itens from store
        Random random = new Random();
        ArrayList<ItemHero> itensToSell = new ArrayList<>();
        ArrayList<ItemHero> heroItems = this.filterStoreToHero(hero);

        if (heroItems.size() <= 10) {
            itensToSell = heroItems;
        } else {
            while (itensToSell.size() < 10) {
                itensToSell.add(heroItems.get(random.nextInt(this.store.size() - 1)));
            }
        }

        int count = 1;
        for (ItemHero item : itensToSell) {
            System.out.println(" ## " + count);
            item.showDetails();
            count++;
        }

        // Read option from user
        String message = "Você tem " + hero.getGold() + " moedas.\nQual item deseja comprar?";
        int option = Util.readAndValidateInput(message, 0, itensToSell.size());
        if (option != 0) {
            option--;
            this.sell(hero, itensToSell.get(option));
        }
    }


    private void sell(Hero hero, ItemHero item) {
        // Make the sale
        if (hero.getGold() < item.getPrice()) {
            System.out.println("Desculpe, você não tem moedas suficientes para realizar essa compra.");
        } else {
            if (!hero.pay(item.getPrice())) {
                System.out.println("Desculpe, algo deu errado com a sua compra.");
            } else {
                if (item instanceof Weapon) {
                    hero.setMainWeapon((Weapon) item);
                } else {
                    hero.addConsumableToInventory((Consumable) item);
                }
            }
        }
    }


    private ArrayList<ItemHero> filterStoreToHero(Hero hero) {
        ArrayList<ItemHero> heroItems = new ArrayList<>();
        String heroClass = hero.getClass().getSimpleName();
        for (ItemHero item : this.store) {
            if (item.getAllowedTo().contains(heroClass)) {
                heroItems.add(item);
            }
        }
        return heroItems;
    }


}
