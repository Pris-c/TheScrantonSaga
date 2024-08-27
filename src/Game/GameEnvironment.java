package Game;

import Entities.Hero;

public abstract class GameEnvironment {

    protected int id;
    protected String initialMessage;
    protected GameEnvironment nextEnvironment;
    protected final boolean hasNext;

    public GameEnvironment(int id, String initialMessage) {
        this.hasNext = false;
        this.initialMessage = initialMessage;
        this.id = id;
    }

    public GameEnvironment(int id, String initialMessage, GameEnvironment nextEnvironment) {
        this.id = id;
        this.initialMessage = initialMessage;
        this.nextEnvironment = nextEnvironment;
        this.hasNext = true;
    }

    public abstract boolean run(Hero hero);
}
