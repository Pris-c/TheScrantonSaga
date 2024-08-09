package Util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Util {

    public static int readAndValidateInput(String message, int min, int max){
        Scanner input = new Scanner(System.in);
        int option;
        boolean validInput;

        do {
            validInput = true;
            System.out.println(message);
            if (min == 0) {
                System.out.println("\033[3mPara voltar, digite 0. \033[0m");
            }
            System.out.print(">> ");

            try{
                option = input.nextInt();
            } catch (InputMismatchException e){
                option = -1;
            }

            if (option < min || option > max){
                validInput = false;
                System.out.println("\n-- Opção Inválida! Por favor, tente novamente. --");
            }
            input.nextLine();

        } while(!validInput);

        return option;
    }
}