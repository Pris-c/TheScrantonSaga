package Game;

import Entities.Hero;

import java.util.ArrayList;

import static Util.Util.cleanScreen;
import static Util.Util.readAndValidateInput;

/**
 * Represents a point of decision in the game where the player chooses a path to go.
 */
public class Node {

    private int id;
    private String initialMessage;
    private String optionsMessage;
    private ArrayList<GameEnvironment> destines;

    /**
     * Constructs a Node with specified attributes.
     *
     * @param id             The unique identifier of the node
     * @param initialMessage The message to be displayed to presents the scenario of choices to the player.
     * @param optionsMessage The message to present the options to the player
     * @param destines       A list of possible GameEnvironments to move on.
     */
    public Node(int id, String initialMessage, String optionsMessage, ArrayList<GameEnvironment> destines) {
        this.id = id;
        this.initialMessage = initialMessage;
        this.optionsMessage = optionsMessage;
        this.destines = destines;
    }


    /**
     * Prints the orientation messages to the console, read the user option and processes the next environment.
     *
     * @param hero The hero player
     * @return An integer representing a game status:
     *          -1 if the Hero loses the game during the environments of the current Node
     *          0 if the Node is the last one in the game.
     *          or the nextNode id if Hero passes successfully by the environments.
     */
    public int run(Hero hero){
        System.out.println(this.initialMessage);
        int option = readAndValidateInput(this.optionsMessage, 1, this.destines.size());
        cleanScreen();
        return this.destines.get(option-1).run(hero);
    }
}
