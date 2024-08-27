package Game;

import Entities.*;
import Game.EnvironmentCreator.NodeCreator;
import Game.EnvironmentCreator.ShopkeeperCreator;

import java.util.InputMismatchException;
import java.util.Scanner;

import static Util.Strings.PlotStrings.creationPointsTable;
import static Util.Strings.PlotStrings.initMessage;
import static Util.Util.*;
import static Util.Util.cleanScreen;

public class ScrantonSaga {

    NodeCreator nodeCreator;

    public ScrantonSaga() {
        this.nodeCreator = new NodeCreator();
    }

    public void theScrantonSaga(){
        Hero hero;

        // Explain the adventure to the player
        cleanScreen();
        System.out.println(initMessage);
        readContinue();

        hero = createHero();
        //labyrinth(hero);

    }


    // TODO: Change to private
    public void labyrinth(Hero hero){
        ShopkeeperCreator.getShopkeeperById(1).run(hero);
        Node node;

        int newNode = 1;
        while (newNode > 0){
            cleanScreen();
            node = nodeCreator.getNodeById(newNode);
            newNode = node.run(hero);
        }

        if (newNode == -1){
            System.out.println("VOCE PERDEU");
        } else {
            System.out.println("PARABENS");
        }
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
            System.out.println(creationPointsTable);
            printHeroCreationInfo(name, creationPoints, strength, hp);

            int option = readAndValidateInput("O que deseja adicionar?\n1 - Pontos de força\n2 - Pontos de vida", 1, 2);

            int value;
            switch (option) {
                case 1:
                    System.out.print("\nQuantidade de pontos de força a adicionar: ");
                    value = this.readValidInputToCreationPoints();

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
                    value = this.readValidInputToCreationPoints();

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

    private void printHeroCreationInfo(String name, int creationPoints, int strength, int hp) {
        System.out.println("Você possui " + creationPoints + " moedas disponíveis para preparar o seu personagem.");
        System.out.println("\t\t+-------------------------------------+");
        System.out.printf(singleTextFormat, "  Jogador: " + name.toUpperCase());
        System.out.println("\t\t+-------------------------------------+");
        System.out.printf(singleTextFormat, "   FORÇA : " + strength);
        System.out.printf(singleTextFormat, "   HP    : " + hp);
        System.out.println("\t\t+-------------------------------------+\n");
    }

    private int readValidInputToCreationPoints() {
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


}
