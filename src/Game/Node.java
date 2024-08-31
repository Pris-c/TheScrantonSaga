package Game;

import Entities.Hero;

import java.util.ArrayList;

import static Util.Util.cleanScreen;
import static Util.Util.readAndValidateInput;

public class Node {

    private int id;
    private String initialMessage;
    private String optionsMessage;
    private ArrayList<GameEnvironment> destines;

    public Node(int id, String initialMessage, String optionsMessage, ArrayList<GameEnvironment> destines) {
        this.id = id;
        this.initialMessage = initialMessage;
        this.optionsMessage = optionsMessage;
        this.destines = destines;
    }

    public int run(Hero hero){
        System.out.println(this.initialMessage);
        int option = readAndValidateInput(this.optionsMessage, 1, this.destines.size());
        cleanScreen();
        return this.destines.get(option-1).run(hero);
    }
}
