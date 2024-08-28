package Util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Util {

    public static String largeTextFormat = "| %-75s |\n";
    public static String largeDetailFormat = "| %-25s : %-47s |\n";

    public static int readAndValidateInput(String message, int min, int max) {
        Scanner input = new Scanner(System.in);
        int option;
        boolean validInput;

        do {
            validInput = true;
            System.out.println(message);
            System.out.print(">> ");

            try {
                option = input.nextInt();
            } catch (InputMismatchException e) {
                option = -1;
            }

            if (option < min || option > max) {
                validInput = false;
                System.out.println("\n-- Opção Inválida! Por favor, tente novamente. --");
            }
            input.nextLine();

        } while (!validInput);

        return option;
    }

    public static void readContinue() {
        Scanner input = new Scanner(System.in);
        System.out.println("\033[3mPressione enter para continuar...\033[0m");
        input.nextLine();
        cleanScreen();
    }

    public static void readContinue(String message) {
        Scanner input = new Scanner(System.in);
        System.out.println("\033[3m" + message + "\033[0m");
        input.nextLine();
    }

    public static void cleanScreen() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" +
                           "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
}
