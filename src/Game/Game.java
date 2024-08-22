package Game;

import Entities.*;
import Items.CombatConsumable;
import Items.ItemHero;
import Items.Potion;
import Items.Weapon;
import Util.ItemsCreator.CombatConsumableCreator;
import Util.ItemsCreator.PotionCreator;
import Util.ItemsCreator.WeaponCreator;
import Util.Util;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static Util.Text.Text.*;
import static Util.Util.cleanScreen;
import static Util.Util.readContinue;

public class Game {


    public Hero createHero() {
        int creationPoints;
        int gold;

        String message = ("Escolha o seu personagem:\n1 - Representante de vendas\n2 - Recepcionista\n3 - Estagiário");
        int hero = Util.readAndValidateInput(message, 1, 3);
        cleanScreen();

        String name = this.readValidUserName();
        cleanScreen();

        int difficult = Util.readAndValidateInput("Escolha o modo de jogo:\n1 - Fácil\n2 - Difícil", 1, 2);
        if (difficult == 1) {
            creationPoints = 300;
            gold = 20;
        } else {
            creationPoints = 220;
            gold = 15;
        }

        int strength = 1;
        int hp = 20;

        cleanScreen();
        while (creationPoints > 0) {
            printCreationPointsTable();
            printHeroCreationInfo(creationPoints, strength, hp);

            int option = Util.readAndValidateInput("O que deseja adicionar?\n1 - Pontos de força\n2 - Pontos de vida", 1, 2);

            int value;
            System.out.println();
            switch (option) {
                case 1:
                    System.out.print("Quantidade de pontos de força a adicionar: ");
                    value = this.readUserInput();
                    if (value > 0) {
                        if (creationPoints >= (value * 5)) {
                            strength += value;
                            creationPoints -= value * 5;
                        } else {
                            System.out.println("\nVocê não tem moedas suficientes para adicionar " + value + " pontos de força.\n");
                        }
                    }
                    break;

                case 2:
                    System.out.print("Quantidade de hp a adicionar: ");
                    value = this.readUserInput();
                    if (value > 0) {
                        if (creationPoints >= value) {
                            hp += value;
                            creationPoints -= value;

                        } else {
                            System.out.println("\nVocê não tem moedas suficientes para adicionar " + value + " hp.\n");
                        }
                    }
                    break;
            }
        }
        cleanScreen();

        switch (hero) {
            case 1:
                return new SalesRepresentative(name, hp, strength, gold);
            case 2:
                return new Receptionist(name, hp, strength, gold);
            case 3:
                return new Intern(name, hp, strength, gold);
            default:
                return null;
        }
    }


    public void theScrantonSaga() {
        Shopkeeper shopkeeper = initShopkeeper();
        Hero hero;

        // TODO: show logo
        // TODO: music

        // Explain the adventure to the player
        printInitMessage();
        readContinue();
        cleanScreen();

        hero = createHero();
        // TODO: add pause

        System.out.println("Prontinho! Confira as características do seu personagem:");
        hero.showDetails();
        readContinue();
        cleanScreen();


        // Find the shopkeeper
        printFirstShopkeeperMessage();
        readContinue("Pressione enter para ver os itens disponíveis..");
        System.out.println();
        cleanScreen();
        shopkeeper.showsStore(hero);

        // Start the labyrinth
        // Minimun 6 rooms
        // Minimum 3 chosen situations
        // After each room, the hero can use one potion or advance:
        // Print all potion inventory and ask if he wants to use
        // If some part of cure would not be used, the player must be advised and confirm the usage


        // When the player died, it must be shown an option menu:
        // Play again
        // Restart game with another Hero
        // Finish program


    }

    private Shopkeeper initShopkeeper() {
        ArrayList<Weapon> weapons = WeaponCreator.initWeapons();
        ArrayList<CombatConsumable> combatConsumables = CombatConsumableCreator.initCombatConsumables();
        ArrayList<Potion> potions = PotionCreator.initPotions();

        ArrayList<ItemHero> shop = new ArrayList<>();
        shop.addAll(weapons);
        shop.addAll(combatConsumables);
        shop.addAll(potions);

        return new Shopkeeper(shop);
    }

    private int readUserInput() {
        Scanner input = new Scanner(System.in);
        int value;

        try {
            value = input.nextInt();
            input.nextLine();

            if (value <= 0) {
                System.out.println("Valor inválido. Tente novamente.");
                return -1;
            }
            return value;


        } catch (InputMismatchException e) {
            System.out.println("Valor inválido. Tente novamente");
        }

        return -1;
    }

    private String readValidUserName() {
        Scanner input = new Scanner(System.in);
        String name;
        boolean validName;

        do {
            validName = true;
            System.out.println("Que nome deseja usar?");
            System.out.print(">> ");
            name = input.nextLine();

            if (name.isEmpty() || name.isBlank()) {
                validName = false;
                System.out.println("O nome deve ter ao menos um caracter.");
            } else if (name.length() > 20) {
                validName = false;
                System.out.println("O nome deve ter no máximo 20 caracteres.");
            }

        } while (!validName);
        return name;
    }
}
