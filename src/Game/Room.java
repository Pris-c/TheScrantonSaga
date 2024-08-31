package Game;

import Entities.Hero;

import java.util.Random;

import static Util.Strings.EnvironmentStrings.RoomStrings.defeatRoom;
import static Util.Util.*;

/**
 * Represents a specific playable environment, extending the GameEnvironment class.
 * In this environment, the player can gain or lose strength and/or HP points based on a random value.
 */
public class Room extends GameEnvironment {

    private String questionToPlayer;
    private int percentLuck;
    private int strengthIncrement;
    private int strengthDecrement;
    private int hpIncrement;
    private int hpDecrement;

    /**
     * Constructs a Room instance with the specified attributes.
     *
     * @param id                The unique identifier of the Room
     * @param initialMessage    The message to be displayed in the beginning of the Room situation
     * @param questionToPlayer  The question to be presented to the player, asking for the decision to run the Room or continuous the game.
     * @param percentLuck       The percentage chance that the player gains advantages running the Room
     * @param strengthIncrement The value of the strength increment when the player succeeds
     * @param strengthDecrement The value of the strength decrease when the player has bad luck
     * @param hpIncrement       The value of the hp increment when the player succeeds
     * @param hpDecrement       The value of the hp decrease when the player has bad luck
     * @param nextEnvironment   The next environment to be called
     */
    public Room(int id, String initialMessage, String questionToPlayer, int percentLuck, int strengthIncrement, int strengthDecrement, int hpIncrement, int hpDecrement, GameEnvironment nextEnvironment) {
        super(id, initialMessage, nextEnvironment);
        this.questionToPlayer = questionToPlayer;
        this.percentLuck = percentLuck;
        this.strengthIncrement = strengthIncrement;
        this.strengthDecrement = strengthDecrement;
        this.hpIncrement = hpIncrement;
        this.hpDecrement = hpDecrement;
    }

    /**
     * Constructs a Room instance with the specified attributes.
     *
     * @param id                The unique identifier of the Room
     * @param initialMessage    The message to be displayed in the beginning of the Room situation
     * @param questionToPlayer  The question to be presented to the player, asking for the decision to run the Room or continuous the game.
     * @param percentLuck       The percentage chance that the player gains advantages running the Room
     * @param strengthIncrement The value of the strength increment when the player succeeds
     * @param strengthDecrement The value of the strength decrease when the player has bad luck
     * @param hpIncrement       The value of the hp increment when the player succeeds
     * @param hpDecrement       The value of the hp decrease when the player has bad luck
     * @param nextNode          The id of the Node to be called in sequence. It must be 0 if it is the final game Environment.
     */
    public Room(int id, String initialMessage, String questionToPlayer, int percentLuck, int strengthIncrement, int strengthDecrement, int hpIncrement, int hpDecrement, int nextNode) {
        super(id, initialMessage, nextNode);
        this.questionToPlayer = questionToPlayer;
        this.percentLuck = percentLuck;
        this.strengthIncrement = strengthIncrement;
        this.strengthDecrement = strengthDecrement;
        this.hpIncrement = hpIncrement;
        this.hpDecrement = hpDecrement;
    }

    /**
     * Runs the room scenario.
     * The player can choose to test their luck or just continue the game.
     *
     * @param hero The hero interacting with the room.
     * @return An integer representing a game status:
     *          -1 if the Hero loses the game in current challenge
     *          0 if the Room is the last obstacle in the game
     *          or the nextNode id if Hero passes successfully by the room
     */
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
            if (this.nextEnvironment != null) {
                return this.nextEnvironment.run(hero);
            }
        }
        return this.nextNode;
    }
}
