package Game;

import Entities.*;
import Game.Helper.ChallengeCreator;
import Game.Helper.NodeCreator;
import Game.Helper.RoomCreator;
import Items.CombatConsumable;
import Items.ItemHero;
import Items.Potion;
import Items.Weapon;
import Util.ItemsCreator.CombatConsumableCreator;
import Util.ItemsCreator.PotionCreator;
import Util.ItemsCreator.WeaponCreator;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static Util.PlotStrings.firstShopkeeperMessage;
import static Util.PlotStrings.initMessage;
import static Util.Printer.Printer.printCreationPointsTable;
import static Util.Printer.Printer.printHeroCreationInfo;
import static Util.Util.*;

public class Game {

    private final NodeCreator nodeCreator;
    private final ChallengeCreator challengeCreator;
    private final RoomCreator roomCreator;

    public Game() {
        this.nodeCreator = new NodeCreator();
        this.challengeCreator = new ChallengeCreator();
        this.roomCreator = new RoomCreator();
    }

    public Hero createHero() {
        cleanScreen();

        int creationPoints;
        int gold;

        String message = ("Escolha o seu personagem:\n1 - Representante de vendas\n2 - Recepcionista\n3 - Estagiário");
        int hero = readAndValidateInput(message, 1, 3);
        cleanScreen();

        String name = this.readValidUserName();
        cleanScreen();

        int difficult = readAndValidateInput("Escolha o modo de jogo:\n1 - Fácil\n2 - Difícil", 1, 2);


        if (difficult == 1) {
            creationPoints = 300;
            gold = 20;
        } else {
            creationPoints = 220;
            gold = 15;
        }

        int strength = 1;
        int hp = 20;

        // TODO: Refactor to another method ?
        cleanScreen();
        while (creationPoints > 0) {
            printCreationPointsTable();
            printHeroCreationInfo(name, creationPoints, strength, hp);

            int option = readAndValidateInput("O que deseja adicionar?\n1 - Pontos de força\n2 - Pontos de vida", 1, 2);

            int value;
            switch (option) {
                case 1:
                    System.out.print("\nQuantidade de pontos de força a adicionar: ");
                    value = this.readUserInput();

                    cleanScreen();
                    if (value > 0) {
                        if (creationPoints >= (value * 5)) {
                            strength += value;
                            creationPoints -= value * 5;

                            if (creationPoints > 0) {
                                System.out.println("\t\tPontos de força adicionados com sucesso!\n");
                            }
                        } else {
                            System.out.println("\nVocê não tem moedas suficientes para adicionar " + value + " pontos de força.\n");
                        }
                    }
                    break;

                case 2:
                    System.out.print("\nQuantidade de hp a adicionar: ");
                    value = this.readUserInput();

                    cleanScreen();
                    if (value > 0) {
                        if (creationPoints >= value) {
                            hp += value;
                            creationPoints -= value;

                            if (creationPoints > 0) {
                                System.out.println("\t\tPontos de vida adicionados com sucesso!\n");
                            }

                        } else {
                            System.out.println("\nVocê não tem moedas suficientes para adicionar " + value + " hp.\n");
                        }
                    }
                    break;
            }
        }
        cleanScreen();

        Hero player = null;

        switch (hero) {
            case 1:
                player = new SalesRepresentative(name, hp, strength, gold);
                break;
            case 2:
                player = new Receptionist(name, hp, strength, gold);
                break;
            case 3:
                player = new Intern(name, hp, strength, gold);
                break;
        }

        System.out.println("\nPersonagem criado com sucesso!\n");
        System.out.println("Confira as características do seu personagem:");
        player.showDetails();
        readContinue();
        cleanScreen();
        return player;
    }

    public void theScrantonSaga() {
        // TODO: show logo
        // TODO: music
        Shopkeeper shopkeeper = initShopkeeper();
        Hero hero;

        // Explain the adventure to the player
        cleanScreen();
        System.out.println(initMessage);
        readContinue();

        hero = createHero();
        labyrinth(hero, shopkeeper);


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

    // TODO: Make private
    public boolean labyrinth(Hero hero, Shopkeeper shopkeeper) {

        // Find the shopkeeper
        cleanScreen();
        System.out.println(firstShopkeeperMessage);

        readContinue("\n\n\033[3mPressione enter para ver os itens disponíveis..\033[0m");
        cleanScreen();
        shopkeeper.showsStore(hero);

        // GameNode 1
        GameNode node1 = this.nodeCreator.createNode1();
        cleanScreen();
        if (node1.run() == 1) {
            // Go to challenge 1
            cleanScreen();
            Challenge challenge1 = this.challengeCreator.createChallenge1();
            if (!challenge1.run(hero)) {
                return false;
            }
            cleanScreen();
            this.offerPotion(hero);
             System.out.println("FIM DESAFIO 1");

            // TODO: Offer potion
            // TODO: Node 2
        } else {
            // Go to challenge 2
            cleanScreen();
            Challenge challenge2 = this.challengeCreator.createChallenge2();
            if (!challenge2.run(hero)) {
                return false;
            }
            cleanScreen();
            this.offerPotion(hero);
            System.out.println("FIM DESAFIO 2");


            // TODO: Challenge 3
        }

        return false;
    }

    private void offerPotion(Hero hero){
        System.out.println("Antes de seguir em frente, que tal recarregar suas energias com um lanchinho?");
        if (readAndValidateInput("Digite 1 para escolher um lanche.\n\033[3mPara continuar, digite 0. \033[0m", 0, 1) == 1) {
            cleanScreen();
            hero.usePotion();
        }
    }


    // TODO: Make private
    public Shopkeeper initShopkeeper() {
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
