package Game;

import Entities.Hero;

/**
 * Represents an abstract game environment that provides playable scenarios.
 * Subclasses must define specific types of Environments.
 */
public abstract class GameEnvironment {

    protected int id;
    protected String initialMessage;
    protected GameEnvironment nextEnvironment;
    protected int nextNode;

    /**
     * Constructs a GameEnvironment that follows to a next environment
     *
     * @param id             The unique identifier of the environment
     * @param initialMessage The message to be displayed in the beginning of the environment situation
     * @param nextEnvironment The next environment to be called
     */
    public GameEnvironment(int id, String initialMessage, GameEnvironment nextEnvironment) {
        this.id = id;
        this.initialMessage = initialMessage;
        this.nextEnvironment = nextEnvironment;
        this.nextNode = 0;
    }

    /**
     * Constructs the final GameEnvironment in a sequence.
     *
     * @param id             The unique identifier of the environment
     * @param initialMessage The message to be displayed in the beginning of the environment situation
     * @param nextNode       The id of the Node to be called in sequence. It must be 0 if it is the final game Environment.
     */
    public GameEnvironment(int id, String initialMessage, int nextNode) {
        this.id = id;
        this.initialMessage = initialMessage;
        this.nextNode = nextNode;
        this.nextEnvironment = null;
    }

    /**
     * Executes the GameEnvironment behavior.
     * It must be implemented by subclasses to define the specific scenario.
     *
     * @param hero The hero character interacting with the environment.
     * @return An integer representing a game status:
     *          -1 if the Hero loses the game in current environment
     *          0 if the Environment is the last obstacle in the game
     *          or the nextNode id if Hero passes successfully by the environment
     */
    public abstract int run(Hero hero);
}
