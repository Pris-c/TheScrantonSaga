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

/**
 * Represents a specific playable environment, extending the GameEnvironment class.
 * The Shopkeeper is the environment where the player can buy weapons, combat consumables or potions to improve their
 * abilities.
 */
public class Shopkeeper extends GameEnvironment{

    private static ArrayList<ItemHero> store;
    private static boolean initInstance;

    /**
     * Constructs a Shopkeeper environment
     *
     * @param id             The unique identifier of the environment
     * @param initialMessage The message to be displayed in the beginning of the environment situation
     * @param nextEnvironment The next environment to be called
     */
    public Shopkeeper(int id, String initialMessage, GameEnvironment nextEnvironment) {
        super(id, initialMessage, nextEnvironment);
    }

    /**
     * Constructs a Shopkeeper environment
     *
     * @param id             The unique identifier of the environment
     * @param initialMessage The message to be displayed in the beginning of the environment situation
     * @param nextNode       The id of the Node to be called in sequence. It must be 0 if it is the final game Environment.
     */
    public Shopkeeper(int id, String initialMessage, int nextNode) {
        super(id, initialMessage, nextNode);
        if (!initInstance){
            initInstance = true;
            store = fillStore();
        }
    }

    /**
     * Runs the Shopkeeper environment, allowing the hero to view and buy items.
     * The player can also choose to consume potions if they have any.
     *
     * @param hero The hero interacting with the Shopkeeper.
     * @return An integer representing the game status:
     *         0 if the Shopkeeper is the last environment.
     *         or the id of the next node.
     */
    @Override
    public int run(Hero hero) {
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
        cleanScreen();

        if (hero.checkPotionAvailability()){
            int consumeOption;
            consumeOption = readAndValidateInput("Deseja consumir algo agora?\n1 - Sim, me mostre minhas opções\n0 - Não, quero seguir em frente", 0, 1);
            cleanScreen();
            if (consumeOption == 1){
                hero.offerPotionsIfAvailable();
            }
        }

        if (this.nextEnvironment != null){
            return this.nextEnvironment.run(hero);

        }
        return nextNode;
    }

    /**
     * Makes an item sale to the hero
     * Remove gold of hero and add the item their inventory
     *
     * @param hero The hero character purchasing the item.
     * @param item The item bought.
     * @return True if the sale was successful, false otherwise.
     */
    private boolean sell(Hero hero, ItemHero item) {
        if (hero.getGold() < item.getPrice()) {
            System.out.println("Desculpe, você não tem moedas suficientes para realizar essa compra.\n");
            readContinue();
            cleanScreen();
            return false;
        } else {
            if (!hero.payForAItem(item.getPrice())) {
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

    /**
     * Filters and returns distinct items that the hero is allowed to have based on their class.
     *
     * @param hero The hero whose allowed items must be filtered.
     * @return A list of distinct items available for the hero.
     */
    private ArrayList<ItemHero> filterDistinctItemsToHero(Hero hero) {
        ArrayList<ItemHero> heroItems = new ArrayList<>();
        String heroClass = hero.getClass().getSimpleName();
        for (ItemHero item : store) {
            if (item.getAllowedTo().contains(heroClass)) {
                heroItems.add(item);
            }
        }
        return new ArrayList<>(heroItems.stream().distinct().toList());
    }

    /**
     * Prints to the console the items available in the shop.
     *
     * @param itensToSell The list of available items for sale.
     */
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


    /**
     * Initializes the store with all game items.
     *
     * @return The list of items available in the store.
     */
    private ArrayList<ItemHero> fillStore(){
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
