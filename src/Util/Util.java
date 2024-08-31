package Util;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Provides common methods for user input validation and console management.
 */
public class Util {

    /**
     * A format string for displaying text with a specific large style.
     */
    public static String largeTextFormat = "| %-75s |\n";

    /**
     * A format string for displaying text with a specific style.
     */
    public static String largeDetailFormat = "| %-25s : %-47s |\n";

    /**
     * Ask the user to enter an integer value and validate it according to specified limits.
     * It repeats until the user input is valid.
     *
     * @param message Message to be printed to ask the user input
     * @param min The minimum acceptable value
     * @param max The maximum acceptable value
     * @return The valid integer informed by the user
     */
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
                cleanScreen();
                System.out.println("\n-- Opção Inválida! Por favor, tente novamente. --");
            }
            input.nextLine();

        } while (!validInput);

        return option;
    }

    /**
     * Pauses execution until the user presses Enter.
     */
    public static void readContinue() {
        Scanner input = new Scanner(System.in);
        System.out.println("\033[3mPressione enter para continuar...\033[0m");
        input.nextLine();
        cleanScreen();
    }

    /**
     * Pauses execution with a custom message until the user presses Enter.
     *
     * @param message The message to be printed to the user.
     */
    public static void readContinue(String message) {
        Scanner input = new Scanner(System.in);
        System.out.println("\033[3m" + message + "\033[0m");
        input.nextLine();
    }

    /**
     * Simulates a screen cleaning by printing several line breaks
     */
    public static void cleanScreen() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" +
                "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
}
