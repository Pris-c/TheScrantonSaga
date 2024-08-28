package Game;


import Entities.Hero;
import Entities.Intern;
import Entities.Receptionist;
import Entities.SalesRepresentative;
import Util.Creator.EnvironmentCreator.NodeCreator;
import Util.Creator.EnvironmentCreator.ShopkeeperCreator;

import java.util.InputMismatchException;
import java.util.Scanner;

import static Util.Strings.GeneralStrings.*;
import static Util.Util.*;

public class ScrantonSaga {


    public void initGame() {
        Hero hero = null;
        int option = -1;

        System.out.println(title);
        readContinue("Pressione enter para iniciar o jogo..");

        cleanScreen();
        System.out.println(initMessage);
        readContinue();
        cleanScreen();

        do {
            if (option != 1) {
                hero = createHero();
            }

            boolean heroWin = labyrinth(hero);
            if (heroWin) {
                System.out.println(championMessage);
            } else {
                System.out.println(loserMessage);
            }
            option = readAndValidateInput("O que deseja fazer agora:" +
                    "\n1 - Jogar novamente com o mesmo personagem" +
                    "\n2 - Escolher um novo personagem" +
                    "\n3 - Sair", 1, 3);

        } while (option != 3);
    }


    private boolean labyrinth(Hero hero) {
        ShopkeeperCreator.getShopkeeperById(1).run(hero);
        Node node;

        int newNode = 1;
        while (newNode > 0) {
            cleanScreen();
            node = NodeCreator.getNodeById(newNode);
            newNode = node.run(hero);
        }

        return newNode == 0;
    }

    public Hero createHero() {
        cleanScreen();
        int creationPoints;
        int gold;
        int heroNumber = 4;

        while (heroNumber == 4) {
            String message = (
                    "Escolha o seu personagem:" +
                            "\n1 - Representante de vendas" +
                            "\n2 - Recepcionista" +
                            "\n3 - Estagiário" +
                            "\n\033[3mOu digite 4 para conhecer as características de cada personagem..\033[0m");
            heroNumber = readAndValidateInput(message, 1, 4);
            if (heroNumber == 4) {
                this.printHeroesInfo();
            }
        }
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

        int strength = 10;
        int hp = 30;

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
                    System.out.print("\nQuantidade de pontos de vida a adicionar: ");
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
        switch (heroNumber) {
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

        System.out.println("\nPersonagem " + player.getName() + " criado com sucesso!");
        readContinue("Pressione enter para conferir as características do seu personagem..");
        cleanScreen();

        player.showDetails();
        int option = readAndValidateInput("Digite 1 para consultar informações sobre os elementos da tabela acima." +
                "\n\033[3mOu digite 0 para continuar..\033[0m", 0, 1);
        if (option == 1) {
            printItemsInfo();
        }
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
        String textFormat = "\t\t| %-35s |\n";
        System.out.println("Você possui " + creationPoints + " moedas disponíveis para preparar o seu personagem.");
        System.out.println("\t\t+-------------------------------------+");
        System.out.printf(textFormat, "  Jogador: " + name.toUpperCase());
        System.out.println("\t\t+-------------------------------------+");
        System.out.printf(textFormat, "   FORÇA : " + strength);
        System.out.printf(textFormat, "   HP    : " + hp);
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

    public void printHeroesInfo() {
        cleanScreen();
        System.out.println(aboutHeroes);
        readContinue("\033[3mPressione enter para voltar...\033[0m");
        cleanScreen();
    }

    public void printItemsInfo() {
        cleanScreen();
        System.out.println(aboutGameElement);
        readContinue("\033[3mPressione enter para voltar...\033[0m");
        cleanScreen();
    }

}
