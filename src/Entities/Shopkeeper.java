package Entities;

import Items.Consumable;
import Items.ItemHero;
import Items.Weapon;
import Util.Util;

import java.util.ArrayList;
import java.util.Random;

import static Util.Util.cleanScreen;
import static Util.Util.readContinue;

public class Shopkeeper {

    private ArrayList<ItemHero> store;

    public Shopkeeper(ArrayList<ItemHero> store) {
        this.store = store;
    }

    public void showsStore(Hero hero) {
        cleanScreen();
        Random random = new Random();
        ArrayList<ItemHero> itensToSell = new ArrayList<>();
        ArrayList<ItemHero> heroItems = this.filterDistinctItemsToHero(hero);

        if (heroItems.size() <= 10) {
            itensToSell = heroItems;
        } else {
            while (itensToSell.size() < 10) {
                ItemHero item = heroItems.get(random.nextInt(heroItems.size()));
                itensToSell.add(item);
                heroItems.remove(item);
            }
        }

        int option;
        int nItem = -1;

        while (nItem != 0) {

            cleanScreen();
            printItemsToSell(itensToSell);
            System.out.println("Você tem " + hero.getGold() + " moedas.");
            nItem = Util.readAndValidateInput("Informe o número do item para ver os detalhes:\n\033[3mPara sair, digite 0. \033[0m", 0, itensToSell.size());

            if (nItem > 0) {

                cleanScreen();
                nItem--;
                ItemHero item = itensToSell.get(nItem);
                nItem++;
                item.showDetails();

                option = Util.readAndValidateInput("Digite 1 para comprar o item.\n\033[3mPara voltar, digite 0. \033[0m", 0, 1);

                cleanScreen();
                if (option == 1) {
                    if (this.sell(hero, item)) {
                        itensToSell.remove(item);
                        hero.showDetails();
                    }
                    readContinue("\n\n\033[3mPressione enter para retornar à loja..\033[0m");
                }
            }
        }
    }

    private boolean sell(Hero hero, ItemHero item) {
        if (hero.getGold() < item.getPrice()) {
            System.out.println("Desculpe, você não tem moedas suficientes para realizar essa compra.\n");
            return false;
        } else {
            if (!hero.pay(item.getPrice())) {
                System.out.println("Desculpe, algo deu errado com a sua compra.\n");
                return false;
            } else {
                if (item instanceof Weapon) {
                    hero.setMainWeapon((Weapon) item);
                    System.out.println("Arma Principal atualizada com sucesso!\n");
                } else {
                    hero.addConsumableToInventory((Consumable) item);
                    System.out.println("Novo item adicionado ao inventário!\n");
                }
                return true;
            }
        }
    }

    private ArrayList<ItemHero> filterDistinctItemsToHero(Hero hero) {
        ArrayList<ItemHero> heroItems = new ArrayList<>();
        String heroClass = hero.getClass().getSimpleName();
        for (ItemHero item : this.store) {
            if (item.getAllowedTo().contains(heroClass)) {
                heroItems.add(item);
            }
        }
        return new ArrayList<>(heroItems.stream().distinct().toList());
    }

    public void printItemsToSell(ArrayList<ItemHero> itensToSell) {
        String format = "| %-3s | %-20s | %-30s | %-7s |\n";

        System.out.println("+-----------------------------------------------------------------------+");
        System.out.println("|                  Armário de Suprimentos                               |");
        System.out.println("+-----+------------------+-------------------+--------------------------+");
        System.out.println("| Nº  | Tipo                 | Nome                           | Preço   |");
        System.out.println("+-----+------------------+-------------------+--------------------------+");

        int count = 1;
        String type = " ";
        for (ItemHero i : itensToSell) {
            switch (i.getClass().getSimpleName()) {
                case "Potion":
                    type = "Lanche";
                    break;
                case "Weapon":
                    type = "Um bom argumento";
                    break;
                case "CombatConsumable":
                    type = "Ajuda Extra";
                    break;
            }
            System.out.printf(format, String.format("%02d", count), type, i.getName(), "$ " + i.getPrice());
            count++;
        }
        System.out.println("+-----------------------------------------------------------------------+\n\n");
    }

}
