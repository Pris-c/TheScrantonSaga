package Game;

import Entities.Hero;
import Entities.Npc;

import static Util.Util.*;

/**
 * Represents a specific playable environment, extending the GameEnvironment class.
 * The game can continues to the next phase or end in defeat.
 */
public class Challenge extends GameEnvironment {

    private final Npc enemy;
    private final String victoryMessage;
    private final String defeatMessage;

    /**
     * Constructs a Challenge instance with the specified attributes.
     *
     * @param id             The unique identifier of the environment
     * @param initialMessage The message to be printed to the console in the beginning of the challenge situation
     * @param victoryMessage The message to be printed when the Hero win the challenge
     * @param defeatMessage  The message to be prinited when the Hero loses the challenge
     * @param enemy          The Enemy the Hero must attack
     * @param nextNode       The id of the Node to be called in sequence. It must be 0 if it is the final game Environment.
     */
    public Challenge(int id, String initialMessage, String victoryMessage, String defeatMessage, Npc enemy, int nextNode) {
        super(id, initialMessage, nextNode);
        this.enemy = enemy;
        this.victoryMessage = victoryMessage;
        this.defeatMessage = defeatMessage;
    }

    /**
     * Constructs a Challenge instance with the specified attributes.
     *
     * @param id             The unique identifier of the environment
     * @param initialMessage The message to be displayed in the beginning of the challenge situation
     * @param victoryMessage The message to be printed when the Hero win the challenge
     * @param defeatMessage  The message to be prinited when the Hero loses the challenge
     * @param enemy          The Enemy the Hero must attack
     * @param nextEnvironment The next environment to be called
     */
    public Challenge(int id, String initialMessage, String victoryMessage, String defeatMessage, Npc enemy, GameEnvironment nextEnvironment) {
        super(id, initialMessage, nextEnvironment);
        this.enemy = enemy;
        this.victoryMessage = victoryMessage;
        this.defeatMessage = defeatMessage;
    }

    /**
     * Runs the challenge scenario, where the Hero fight against a difficult situation.
     * If the Hero loses, the game must finish.
     *
     * @param hero The hero character interacting with the challenge.
     * @return An integer representing a game status:
     *          -1 if the Hero loses the game in current challenge
     *          0 if the Environment is the last obstacle in the game
     *          or the nextNode id if Hero passes successfully by the challenge
     */
    @Override
    public int run(Hero hero) {
        System.out.println(this.initialMessage);
        readContinue();
        cleanScreen();

        boolean heroWin = hero.attack(this.enemy);
        if (!heroWin) {
            System.out.println(this.defeatMessage);
            readContinue();
            return -1;
        }

        hero.upgradeLevel(this.enemy);
        System.out.println(this.victoryMessage);
        System.out.println("Você subiu para o nível " + hero.getLevel() + " !!");
        System.out.println("Com isso, você ganhou 10 pontos de vida,  1 ponto de força e " + enemy.getGold() + " moedas!");
        int option = readAndValidateInput("Para consultar suas informações digite 1\n\033[3mDigite 0 continuar...\033[0m", 0, 1);
        cleanScreen();
        if (option == 1) {
            hero.showDetails();
            readContinue();
        }

        if (this.nextEnvironment != null) {
            cleanScreen();
            if (hero.checkPotionAvailability()) {
                System.out.println("Após essa grande vitória, que tal reforçar as energias?");
                readContinue("Pressione enter para ver as suas opções..");
                cleanScreen();
                hero.offerPotionsIfAvailable();
            }
            cleanScreen();
            return this.nextEnvironment.run(hero);
        }

        return nextNode;
    }
}
