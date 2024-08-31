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

/**
 * Represents the game flow including hero creation, labyrinth navigation,
 * and decision-making throughout the game.
 */
public class ScrantonSaga {

    /**
     * Initializes the game, allowing the player to create a hero, navigate through the labyrinth,
     * and make decisions. Manages the Node loop and handles player choices for restarting or exiting the game.
     */
    public void scrantonSaga() {
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
            option = readAndValidateInput("""
                            O que deseja fazer agora:
                            1 - Jogar novamente com o mesmo personagem
                            2 - Escolher um novo personagem
                            3 - Sair""",
                    1, 3);

        } while (option != 3);
    }


    /**
     * Manages the game flow through the game environments
     *
     * @param hero The hero chosen by the player
     * @return True if the labyrinth is completed successfully, false otherwise.
     */
    private boolean labyrinth(Hero hero) {
        int nextNode = ShopkeeperCreator.getInstance().getShopkeeperById(1).run(hero);
        Node node;
        while (nextNode > 0) {
            cleanScreen();
            node = NodeCreator.getInstance().getNodeById(nextNode);
            nextNode = node.run(hero);
        }
        return nextNode == 0;
    }

    /**
     * Allows the player to create a hero by allocating creation points, witch are defined according to the chosen
     * difficult level.
     *
     * @return The created hero.
     */
    public Hero createHero() {
        cleanScreen();
        int creationPoints;
        int gold;
        int heroNumber = 4;

        while (heroNumber == 4) {
            String message = (
                    """
                                    Escolha o seu personagem:
                                    1 - Representante de vendas
                                    2 - Recepcionista
                                    3 - Estagiário
                                    \033[3mOu digite 4 para conhecer as características de cada personagem..\033[0m
                            """);
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
            printHeroCreationInfo(name, creationPoints, strength, hp);

            String message = creationPointsTable + "O que deseja adicionar?\n1 - Pontos de força\n2 - Pontos de vida";
            int option = readAndValidateInput(message, 1, 2);

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
                            System.out.println("\nVocê não tem pontos de criação suficientes para adicionar " + value + " pontos de força.\n");
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
                            System.out.println("\nVocê não tem pontos de criação suficientes para adicionar " + value + " hp.\n");
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

    /**
     * Reads a valid username from the player.
     * The name can't be blank or empty.
     *
     * @return The validated username.
     */
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
                cleanScreen();
                System.out.println("O nome deve ter ao menos um caracter.");
            } else if (name.length() > 20) {
                validName = false;
                cleanScreen();
                System.out.println("O nome deve ter no máximo 20 caracteres.");
            }

        } while (!validName);
        return name;
    }

    /**
     * Prints the current hero creation details including remaining creation points, strength, and health points.
     *
     * @param name           The name chose by the player
     * @param creationPoints Amount of available creation points
     * @param strength       Value of the current hero strength
     * @param hp             Value of the current hero hp
     */
    private void printHeroCreationInfo(String name, int creationPoints, int strength, int hp) {
        String textFormat = "\t\t| %-35s |\n";
        System.out.println("Você possui " + creationPoints + " pontos de criação disponíveis para preparar o seu personagem.");
        System.out.println("\t\t+-------------------------------------+");
        System.out.printf(textFormat, "  Jogador: " + name.toUpperCase());
        System.out.println("\t\t+-------------------------------------+");
        System.out.printf(textFormat, "   FORÇA : " + strength);
        System.out.printf(textFormat, "   HP    : " + hp);
        System.out.println("\t\t+-------------------------------------+\n");
    }

    /**
     * Reads and validates user input for the number of creation points to allocate.
     *
     * @return The valid number of points to allocate or -1 if the input is invalid.
     */
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

    /**
     * Prints to the console information about the available heroes in the game.
     */
    public void printHeroesInfo() {
        cleanScreen();
        System.out.println(aboutHeroes);
        readContinue("\033[3mPressione enter para voltar...\033[0m");
        cleanScreen();
    }

    /**
     * Prints to the console information about the hero elements, such as items and personal abilities.
     */
    public void printItemsInfo() {
        cleanScreen();
        System.out.println(aboutGameElement);
        readContinue("\033[3mPressione enter para voltar...\033[0m");
        cleanScreen();
    }

}
