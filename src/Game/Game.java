package Game;

import Entities.Hero;
import Entities.Intern;
import Entities.Receptionist;
import Entities.SalesRepresentative;
import Util.Util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {


    public Hero createHero() {
        int creationPoints;
        int gold;

        String message = ("Escolha o seu personagem:\n1 - Representante de vendas\n2 - Recepcionista\n3 - Estagiário");
        int hero = Util.readAndValidateInput(message, 1, 3);
        String name = this.readValidUserName();

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

        while (creationPoints > 0) {
            System.out.println("Você possui " + creationPoints + " moedas disponíveis para preparar o seu personagem.");
            System.out.println("1 ponto de força = 5 moedas");
            System.out.println("1 ponto de vida = 1 moeda");

            System.out.println("** Estado atual:");
            System.out.println("\tFORÇA = " + strength);
            System.out.println("\tHP = " + hp);

            message = "O que deseja adicionar?\n1 - Pontos de força\n2 - Pontos de vida";
            int option = Util.readAndValidateInput(message, 1, 2);
            int value;

            switch (option) {
                case 1:
                    System.out.print("Quantidade de pontos de força a adicionar: ");
                    value = this.readUserInput();
                    if (value > 0) {
                        if (creationPoints >= (value * 5)) {
                            strength += value;
                            creationPoints -= value * 5;
                        } else {
                            System.out.println("Você não tem moedas suficientes para adicionar " + value + " pontos de força.");
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
                            System.out.println("Você não tem moedas suficientes para adicionar " + value + " hp.");
                        }
                    }
                    break;
            }
        }

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
            System.out.println(">> ");
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
