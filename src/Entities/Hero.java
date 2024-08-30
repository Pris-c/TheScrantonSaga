package Entities;

import Items.CombatConsumable;
import Items.Consumable;
import Items.Potion;
import Items.Weapon;
import Util.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static Util.Util.*;

/**
 * Represents a generic playable character, extending the Entity class.
 * This class serves as a base for specific hero types, with the attributes maxHp, level, mainWeapon,
 * and inventory of items.
 * It utilizes a Random object for its methods.
 */
public abstract class Hero extends Entity {

    protected int maxHp;
    protected int level;
    protected Weapon mainWeapon;
    protected ArrayList<Consumable> inventory;
    protected Random rd;

    /**
     * Constructs a Hero instance with the specified attributes.
     * A Random object is also instantiated for use in various methods.
     *
     * @param name       The name of the Hero.
     * @param hp         The amount of health points the Hero has. It always starts equals to the maxHp.
     * @param strength   The strength value of the Hero, used during attacks.
     * @param gold       The amount of money the Hero has, used to obtain items during the game.
     * @param mainWeapon The weapon that the hero starts the game.
     * @param inventory  An ArrayList of items that the hero have available to use during the game.
     *                   During construction, it is initialized a object of Random to be used in class methods
     */
    public Hero(String name, int hp, int strength, int gold, Weapon mainWeapon, ArrayList<Consumable> inventory) {
        super(name, hp, strength, gold);
        this.rd = new Random();
        this.level = 1;
        this.maxHp = hp;
        this.mainWeapon = mainWeapon;
        this.inventory = inventory;
    }

    public int getLevel() {
        return level;
    }

    /**
     * Replace the Hero's mainWeapon
     *
     * @param mainWeapon the new Weapon to be used by the Hero
     */
    public void setMainWeapon(Weapon mainWeapon) {
        this.mainWeapon = mainWeapon;
    }


    /**
     * Decrease the amount of gold correspondent to the specified itemPrice if Hero can support it.
     * Ensures the price is non-negative.
     *
     * @param itemPrice the amount of gold to be decreased. Must be non-negative.
     * @return true, if the itemPrice is non-negative and the hero had gold enough to support the item
     * false, if the itemPrice is negative or the hero has less gold than the item itemPrice
     */
    public boolean payForAItem(int itemPrice) {
        if (itemPrice >= 0) {
            if (this.gold < itemPrice) {
                return false;

            } else {
                this.gold -= itemPrice;
                return true;
            }
        }
        return false;
    }

    /**
     * Adds the specified Consumable item to the hero's inventory.
     *
     * @param consumable Consumable item to be added to Hero's inventory
     */
    public void addConsumableToInventory(Consumable consumable) {
        this.inventory.add(consumable);
    }

    /**
     * Print to the console detailed information about the hero, including maximum health,
     * level, main weapon details, and inventory contents.
     * The showDetails method is extended from the Entity class.
     */
    @Override
    public void showDetails() {
        String tableFormat = "| %-25s : %-47s |\n";
        String detailsWeaponFormat = "|%28s %-25s: %-20s |\n";
        super.showDetails();
        System.out.printf(tableFormat, "Vida máx", this.maxHp);
        System.out.printf(tableFormat, "Nível", this.level);
        System.out.printf(tableFormat, "Instrumento de Poder", this.mainWeapon.getName());
        System.out.printf(detailsWeaponFormat, " ", "Manobra Comum", this.mainWeapon.getStandardAttack());
        System.out.printf(detailsWeaponFormat, " ", "Enfrentamento Criativo", this.mainWeapon.getSpecialAttack());
        System.out.println("+-----------------------------------------------------------------------------+");
        System.out.printf(largeTextFormat, " -- Suplementos -- ");
        System.out.println("+-----------------------------------------------------------------------------+");
        if (inventory.isEmpty()) {
            System.out.printf(largeTextFormat, "Nenhum consumível disponível");
        } else {
            for (Consumable c : inventory) {
                if (c instanceof CombatConsumable) {
                    System.out.printf(largeTextFormat, "Ajuda: " + c.getName());
                } else {
                    System.out.printf(largeTextFormat, c.shortDescription());
                }
            }
        }
        System.out.println("+-----------------------------------------------------------------------------+");
    }

    /**
     * Checks if there is at least one Potion item in the hero's inventory.
     *
     * @return true, if exists at least one Potion in Hero inventory,
     * false, ir doesn't exist any Potion in Hero inventory,
     */
    public boolean checkPotionAvailability() {
        return this.inventory.stream().anyMatch(i -> i instanceof Potion);
    }

    /**
     * Filters and returns a list of all Potion items currently in the hero's inventory.
     *
     * @return an ArrayList with the existing Potions in Hero inventory
     */
    private ArrayList<Potion> filterPotionsFromInventory() {
        return new ArrayList<>(inventory.stream().
                filter(i -> i instanceof Potion)
                .map(i -> (Potion) i)
                .toList()
        );
    }

    /**
     * Allows the player to use available potions from the Hero's inventory.
     * The player is presented with a list of potions and can choose one to consume.
     * If the Hero's HP exceeds the max HP after using a potion, the player is warned
     * and given the option to proceed or cancel.
     * The process continues until the player chooses to stop or the potions had ended.
     */
    public void offerPotionsIfAvailable() {
        ArrayList<Potion> potions;
        String textFormat = " %-31s \n";
        boolean sair;

        do {
            potions = this.filterPotionsFromInventory();
            sair = false;
            if (potions.isEmpty()) {
                System.out.println("+---------------------------------+");
                System.out.printf(textFormat, "NENHUMA POÇÃO DISPONÍVEL");
                System.out.println("+---------------------------------+\n");
                sair = true;
                readContinue();
            } else {
                System.out.println("\n+---------------------------------+");
                System.out.printf(textFormat, "POÇÕES DISPONÍVEIS");
                System.out.println("+---------------------------------+");
                for (int i = 0; i < potions.size(); i++) {
                    System.out.printf(textFormat, "# " + (i + 1));
                    potions.get(i).offerPotion();
                }
                System.out.println();

                int option = readAndValidateInput("Escolha uma poção para utilizar:\n\033[3mPara seguir em frente, digite 0. \033[0m", 0, potions.size());
                cleanScreen();
                if (option == 0) {
                    sair = true;
                } else {
                    Potion potionToUse = potions.get(option - 1);
                    int newHp = potionToUse.getHealing() + this.hp;
                    if (newHp > maxHp) {
                        cleanScreen();
                        System.out.println("Seu teto de pontos de vida é " + this.maxHp + ".");
                        System.out.println("Ao consumir o item " + potionToUse.getName() + " agora, você deixará de usar " + (newHp - maxHp) + " hp fornecidos por ele.");
                        int confirmationOption = readAndValidateInput("Deseja continuar?\n1 - Sim\n0 - Cancelar", 0, 1);
                        cleanScreen();
                        if (confirmationOption == 1) {
                            usePotion(potionToUse);
                        }
                    } else {
                        usePotion(potionToUse);
                    }
                }
            }
            cleanScreen();
        } while (!sair);
    }

    /**
     * Uses the specified Potion, increasing the hero's health and strength according to the potion's properties.
     * Removes the potion from the inventory after use.
     *
     * @param potionToUse Potion to have this healing and strength values applied to the Hero
     */
    private void usePotion(Potion potionToUse) {
        int newHp = this.hp + potionToUse.getHealing();
        this.hp = Math.min(this.maxHp, newHp);
        this.strength += potionToUse.getStrengthIncrement();
        this.inventory.remove(potionToUse);

        System.out.println("\nAgora você está mais preparado para as próximas missões, " + this.name + " !");
        System.out.println("\tPontos de vida: " + this.hp);
        System.out.println("\tForça: " + this.strength);
        System.out.println();
        readContinue();
    }

    /**
     * Checks if there is at least one CombatConsumable item in the hero's inventory.
     *
     * @return true, if exists at least one CombatConsumable in Hero inventory,
     * false, ir doesn't exist any CombatConsumable in Hero inventory,
     */
    private boolean checkCombatConsumableAvailability() {
        return this.inventory.stream().anyMatch(i -> i instanceof CombatConsumable);
    }

    /**
     * Filters and returns a list of all CombatConsumable items currently in the hero's inventory.
     *
     * @return an ArrayList with the existing CombatConsumables in Hero inventory
     */
    private ArrayList<CombatConsumable> filterCombatConsumableFromInventory() {
        return new ArrayList<>(inventory.stream().
                filter(i -> i instanceof CombatConsumable)
                .map(i -> (CombatConsumable) i)
                .toList()
        );
    }

    /**
     * Allows the player to use a CombatConsumable from the inventory for an instant attack.
     * If no such items are available, notifies the player
     *
     * @return the attack strength of the chosen item or -1 if no item is used.
     */
    private int instantAttack() {
        String headerFormat = "| %-31s |\n";

        if (!checkCombatConsumableAvailability()) {
            System.out.println("Infelizmente não tem ninguém disponível para te ajudar. Você terá que lidar com isso sozinho!\n\n");
            readContinue();
            return -1;
        }

        ArrayList<CombatConsumable> combatConsumables = this.filterCombatConsumableFromInventory();
        System.out.println("+---------------------------------+");
        System.out.printf(headerFormat, "AJUDAS DISPONÍVEIS");
        for (int i = 0; i < combatConsumables.size(); i++) {
            System.out.println("+---------------------------------+");
            System.out.println("   # " + (i + 1));
            combatConsumables.get(i).showAttackInfo();
            System.out.println("+---------------------------------+\n");
            System.out.println();
        }

        int option = readAndValidateInput("Escolha a ajuda a utilizar:\n\033[3mPara voltar, digite 0.\033[0m", 0, combatConsumables.size());
        if (option != 0) {
            CombatConsumable consumable = combatConsumables.get(option - 1);
            int decrement = consumable.getInstantAttack();
            inventory.remove(consumable);
            return decrement;
        }
        return -1;
    }

    /**
     * Increases the hero's level by 1, maximum and current health by 10, strength by 1, and adds the enemy's gold
     * to the hero's total.
     *
     * @param enemy the enemy combated to Hero upgrade a level
     */
    public void upgradeLevel(Npc enemy) {
        this.level += 1;
        this.maxHp += 10;
        this.hp += 10;
        super.strength += 1;
        super.gold += enemy.gold;
    }

    /**
     * Increases the hero's strength by the specified amount.
     *
     * @param strengthIncrement the strength amount to be added
     */
    public void incrementStrength(int strengthIncrement) {
        super.strength += strengthIncrement;
    }

    /**
     * Reduces the hero's strength by the specified amount, ensuring the strength does not drop below 1.
     *
     * @param strengthDecrement the strength amount to be decreased
     */
    public void decreaseStrength(int strengthDecrement) {
        int newStrength = super.strength - strengthDecrement;
        super.strength = Math.max(newStrength, 1);
    }

    /**
     * Increases the hero's health by the specified amount, ensuring it does not exceed the maximum health (maxHp).
     *
     * @param hp the amount of hp to be added
     */
    public void incrementHp(int hp) {
        int newHp = this.hp + hp;
        this.hp = Math.min(maxHp, newHp);
    }

    /**
     * Returns a message to be displayed after a successful hero attack.
     *
     * @return a random message from de option List.
     */
    private String getHeroAttackMessage() {
        ArrayList<String> attackMessages = new ArrayList<>(List.of(
                "Seu plano funcionou muito bem! O desafio está enfraquecido.",
                "Você avançou com firmeza e fez um bom progresso!",
                "Uma jogada certeira! O desafio está começando a ser vencido.",
                "Você encontrou uma boa estratégia e reduziu a pressão!",
                "Com essa ação, o desafio perdeu força. Continue assim!"
        ));
        return attackMessages.get(rd.nextInt(0, attackMessages.size()));
    }

    /**
     * Returns a message to be displayed after a successful enemy attack.
     *
     * @return a random message from de option List.
     */
    public String getEnemyAttackMessage() {
        ArrayList<String> enemyAttackMessages = new ArrayList<>(List.of(
                "Parece que você se atrapalhou... Isso custou alguns pontos de energia.",
                "O desafio te pegou desprevenido. Sua confiança está um pouco abalada.",
                "A missão está mais difícil do que parecia... Você perdeu terreno.",
                "A missão está difícil. Você sente o peso do escritório se intensificar.",
                "Um erro estratégico... Isso te deixou um pouco mais cansado."
        ));
        return enemyAttackMessages.get(rd.nextInt(0, enemyAttackMessages.size()));
    }

    /**
     * Provides options for the player to attack the enemy.
     * Depending on the player's choice, the enemy's health is reduced based on the attack's strength.
     * The specialAttack option can only be used once per confrontation.
     *
     * @param enemy                  the enemy to have its hp decreased
     * @param specialAttackAvailable boolean determining is specialAttack is still available to use
     * @return the number corresponded to the attack used
     */
    protected int heroAttack(Npc enemy, boolean specialAttackAvailable) {
        int decrement = 0;
        boolean done;
        int option;

        do {
            done = true;
            printScoreboard(enemy);
            if (specialAttackAvailable) {
                String message = "\nEscolha como lidar com essa situação:\n1 - Pedir Ajuda de um Colega\n2 - Lidar Pessoalmente \n3 - Apostar em uma Estratégia Criativa";
                option = Util.readAndValidateInput(message, 1, 3);
            } else {
                String message = "Escolha como lidar com essa situação:\n1 - Pedir Ajuda de um Colega\n2 - Lidar Pessoalmente";
                option = Util.readAndValidateInput(message, 1, 2);
            }

            cleanScreen();
            switch (option) {
                case 1:
                    int instantAttack = this.instantAttack();
                    if (instantAttack != -1) {
                        decrement = instantAttack;
                    } else {
                        done = false;
                    }
                    break;
                case 2:
                    decrement = this.strength + this.mainWeapon.getStandardAttack();
                    break;
                case 3:
                    decrement = this.strength + this.mainWeapon.getSpecialAttack();
                    break;
            }

            cleanScreen();
        } while (!done);
        enemy.decreaseHp(decrement);
        System.out.println(this.getHeroAttackMessage());
        readContinue();
        cleanScreen();
        return option;
    }

    /**
     * Reduces the hero's health based on the enemy's strength and an adjustment factor.
     *
     * @param enemy               the enemy that is attacking the Hero
     * @param enemyStrengthAdjust a tax to minor ou manor the enemy strength
     * @return true if the Hero hp is greater than 0 after decrease,
     * false if the Hero hp after decrease is zero.
     */
    protected boolean enemyAttack(Npc enemy, double enemyStrengthAdjust) {
        int enemyStrength = (int) Math.round(enemy.strength * enemyStrengthAdjust);
        if (this.decreaseHp(enemyStrength) <= 0) {
            return false;
        }
        System.out.println(this.getEnemyAttackMessage());
        readContinue();
        cleanScreen();
        return true;
    }

    /**
     * Abstract method to be implemented by subclasses to handle the hero's attack strategy during combat.
     *
     * @param enemy the enemy  that the hero will fight against.
     * @return true if the hero completes the attack with HP greater than 0; false otherwise.
     */
    public abstract boolean attack(Npc enemy);

    /**
     * Print to the console the current information about the Hero and Enemy hp.
     *
     * @param enemy enemy to have the hp showed
     */
    private void printScoreboard(Npc enemy) {
        String headerFormat = "\t| %-16s | %-16s |\n";
        String scoreFormat = "\t| %16d | %16d |\n";

        String scoreboard =
                "\t+------------------+------------------+\n" +
                        "\t|           PLACAR                    |\n" +
                        "\t+------------------+------------------+\n" +
                        String.format(headerFormat, "Herói", "Missão") +
                        "\t+------------------+------------------+\n" +
                        String.format(scoreFormat, this.hp, enemy.hp) +
                        "\t+------------------+------------------+\n\n";
        System.out.println(scoreboard);
    }
}
