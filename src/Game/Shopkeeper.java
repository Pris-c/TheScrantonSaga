package Game;

import Entities.Hero;
import Items.*;
import Util.Creator.ItemsCreator.CombatConsumableCreator;
import Util.Creator.ItemsCreator.PotionCreator;
import Util.Creator.ItemsCreator.WeaponCreator;
import Util.Util;

import java.util.ArrayList;
import java.util.Random;

import static Util.Util.*;

public class Shopkeeper extends GameEnvironment{

    private static ArrayList<ItemHero> store;
    private static boolean initInstance;

    public Shopkeeper(int id, String initialMessage) {
        super(id, initialMessage);
        if (!initInstance){
            initInstance = true;
            store = fillInventory();
        }
    }

    @Override
    public boolean run(Hero hero) {
        System.out.println(this.initialMessage);
        readContinue();

        Random random = new Random();
        ArrayList<ItemHero> heroItems = this.filterDistinctItemsToHero(hero);
        ArrayList<ItemHero> itensToSell = new ArrayList<>();
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
                        option = readAndValidateInput("Digite 1 para consultar as informações da personagem\n\033[3mDigite 0 para retornar à loja..\033[0m", 0, 1);
                        if (option == 1){
                            cleanScreen();
                            hero.showDetails();
                            readContinue("Pressione enter para voltar à loja..");
                        }
                    }
                }
            }
        }
        return true;
    }

    private boolean sell(Hero hero, ItemHero item) {
        if (hero.getGold() < item.getPrice()) {
            System.out.println("Desculpe, você não tem moedas suficientes para realizar essa compra.\n");
            readContinue();
            cleanScreen();
            return false;
        } else {
            if (!hero.pay(item.getPrice())) {
                System.out.println("Desculpe, algo deu errado com a sua compra.\n");
                readContinue();
                cleanScreen();
                return false;
            } else {
                if (item instanceof Weapon) {
                    hero.setMainWeapon((Weapon) item);
                    System.out.println("Instrumento de Poder atualizado com sucesso!\n");
                } else {
                    Consumable itemC = (Consumable) item;
                    hero.addConsumableToInventory(itemC);
                    System.out.println("Item \"" + itemC.shortDescription() +  "\" adicionado ao inventário!\n");
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

    private void printItemsToSell(ArrayList<ItemHero> itensToSell) {
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


    private ArrayList<ItemHero> fillInventory(){
        ArrayList<Weapon> weapons = WeaponCreator.initWeapons();
        ArrayList<CombatConsumable> combatConsumables = CombatConsumableCreator.getCombatConsumables();
        ArrayList<Potion> potions = PotionCreator.initPotions();
        ArrayList<ItemHero> store = new ArrayList<>();
        store.addAll(weapons);
        store.addAll(combatConsumables);
        store.addAll(potions);
        return store;
    }

}
