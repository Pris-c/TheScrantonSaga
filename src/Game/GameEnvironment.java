package Game;

import Entities.Hero;

public abstract class GameEnvironment {

    protected int id;
    protected String initialMessage;
    //protected GameEnvironment nextEnvironment;
    //protected final boolean hasNext;
    protected boolean last;

    public GameEnvironment(int id, String initialMessage) {
        this.initialMessage = initialMessage;
        this.id = id;
        this.last = false;
    }

    public GameEnvironment(int id, String initialMessage, boolean last) {
        this.id = id;
        this.initialMessage = initialMessage;
        this.last = last;
    }

    public abstract boolean run(Hero hero);
}
