package Game;

import Entities.Hero;

import java.util.ArrayList;

import static Util.Util.cleanScreen;
import static Util.Util.readAndValidateInput;

public class Node {

    private int id;
    private String initialMessage;
    private String optionsMessage;
    ArrayList<GameEnvironment> environments1;
    ArrayList<GameEnvironment> environments2;
    int envir1NextNode;
    int envir2NextNode;

    public Node(int id, String initialMessage, String optionsMessage, ArrayList<GameEnvironment> environments1, ArrayList<GameEnvironment> environments2, int envir1NextNode, int envir2NextNode) {
        this.id = id;
        this.initialMessage = initialMessage;
        this.optionsMessage = optionsMessage;
        this.environments1 = environments1;
        this.environments2 = environments2;
        this.envir1NextNode = envir1NextNode;
        this.envir2NextNode = envir2NextNode;
    }

    public int run(Hero hero){
        ArrayList<GameEnvironment> environments;
        int nextNodeId;

        System.out.println(this.initialMessage);
        int option = readAndValidateInput(this.optionsMessage, 1, 2);
        cleanScreen();

        if (option == 1){
            environments = this.environments1;
            nextNodeId = this.envir1NextNode;
        } else {
            environments = this.environments2;
            nextNodeId = this.envir2NextNode;
        }

        cleanScreen();
        for (GameEnvironment e: environments){
            if (!e.run(hero)){
                return -1;
            }
            cleanScreen();
        }
        return nextNodeId;
    }

/*    public Node(int id, String initialMessage, String optionsMessage, GameEnvironment environment1, GameEnvironment environment2, int envir1NextNode, int envir2NextNode) {
        this.id = id;
        this.initialMessage = initialMessage;
        this.optionsMessage = optionsMessage;
        this.environment1 = environment1;
        this.environment2 = environment2;
        this.envir1NextNode = envir1NextNode;
        this.envir2NextNode = envir2NextNode;
    }


    public int run(Hero hero){
        GameEnvironment environment;
        int nextNodeId;
        System.out.println(this.initialMessage);
        int option = readAndValidateInput(this.optionsMessage, 1, 2);
        cleanScreen();

        if (option == 1){
            environment = this.environment1;
            nextNodeId = this.envir1NextNode;
        } else {
            environment = this.environment2;
            nextNodeId = this.envir2NextNode;
        }

        cleanScreen();
        if (environment.run(hero)){
            return nextNodeId;
        }
        return -1;
    }
 */
}
