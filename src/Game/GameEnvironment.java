package Game;

import Entities.Hero;

public abstract class GameEnvironment {

    protected int id;
    protected String initialMessage;
    protected GameEnvironment nextEnviroment;
    protected int nextNode;

    public GameEnvironment(int id, String initialMessage, GameEnvironment nextEnviroment) {
        this.id = id;
        this.initialMessage = initialMessage;
        this.nextEnviroment = nextEnviroment;
        this.nextNode = 0;
    }

    public GameEnvironment(int id, String initialMessage, int nextNode) {
        this.id = id;
        this.initialMessage = initialMessage;
        this.nextNode = nextNode;
        this.nextEnviroment = null;
    }

    public abstract int run(Hero hero);
}
