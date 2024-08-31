package Game;

import Entities.Hero;

import java.util.Random;

import static Util.Strings.EnvironmentStrings.RoomStrings.defeatRoom;
import static Util.Util.*;

public class Room extends GameEnvironment {

    private String questionToPlayer;
    private int percentLuck;
    private int strengthIncrement;
    private int strengthDecrement;
    private int hpIncrement;
    private int hpDecrement;

    public Room(int id, String initialMessage, String questionToPlayer, int percentLuck, int strengthIncrement, int strengthDecrement, int hpIncrement, int hpDecrement, GameEnvironment nextEnviroment) {
        super(id, initialMessage, nextEnviroment);
        this.questionToPlayer = questionToPlayer;
        this.percentLuck = percentLuck;
        this.strengthIncrement = strengthIncrement;
        this.strengthDecrement = strengthDecrement;
        this.hpIncrement = hpIncrement;
        this.hpDecrement = hpDecrement;
    }

    public Room(int id, String initialMessage, String questionToPlayer, int percentLuck, int strengthIncrement, int strengthDecrement, int hpIncrement, int hpDecrement, int nextNode) {
        super(id, initialMessage, nextNode);
        this.questionToPlayer = questionToPlayer;
        this.percentLuck = percentLuck;
        this.strengthIncrement = strengthIncrement;
        this.strengthDecrement = strengthDecrement;
        this.hpIncrement = hpIncrement;
        this.hpDecrement = hpDecrement;
    }

    @Override
    public int run(Hero hero) {
        Random rd = new Random();
        System.out.println(this.initialMessage);

        int option = -1;
        int option2;
        while (option != 0) {
            option = readAndValidateInput(this.questionToPlayer, 0, 1);
            cleanScreen();
            if (option == 1) {
                if (rd.nextInt(0, 101) < this.percentLuck) {
                    System.out.println("Parabéns! Você é uma pessoa de sorte!");
                    System.out.println("Você ganhou " + this.hpIncrement + " pontos de vida e " + this.strengthIncrement + " pontos de força.\n");
                    hero.incrementHp(this.hpIncrement);
                    hero.incrementStrength(this.strengthIncrement);
                    option2 = readAndValidateInput("Digite 1 para consultar suas informações.\n\033[3mDigite 0 para continuar..\033[0m", 0, 1);
                    if (option2 == 1) {
                        hero.showDetails();
                        readContinue();
                        cleanScreen();
                    }

                } else {
                    System.out.println("Que pena! A sorte não está ao seu lado!");
                    System.out.println("Você perdeu " + this.hpDecrement + " pontos de vida e " + this.strengthDecrement + " pontos de força.\n");
                    hero.decreaseHp(this.hpDecrement);
                    hero.decreaseStrength(this.strengthDecrement);

                    if (hero.getHp() <= 0) {
                        readContinue();
                        cleanScreen();
                        System.out.println(defeatRoom);
                        return -1;
                    }

                    option = readAndValidateInput("Digite 1 para consultar suas informações\n\033[3mDigite 0 para continuar..\033[0m", 0, 1);
                    if (option == 1) {
                        hero.showDetails();
                        readContinue();
                        cleanScreen();
                    }
                }
            }

            cleanScreen();
            if (this.nextEnviroment != null) {
                return this.nextEnviroment.run(hero);
            }
        }
        return this.nextNode;
    }
}
