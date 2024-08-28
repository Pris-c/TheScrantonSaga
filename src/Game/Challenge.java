package Game;

import Entities.Hero;
import Entities.Npc;

import static Util.Util.*;

public class Challenge extends GameEnvironment{

    private final Npc enemy;
    private final String victoryMessage;
    private final String defeatMessage;


    public Challenge(int id, String initialMessage,  String victoryMessage, String defeatMessage, Npc enemy) {
        super(id, initialMessage);
        this.enemy = enemy;
        this.victoryMessage = victoryMessage;
        this.defeatMessage = defeatMessage;
    }

    public Challenge(int id, String initialMessage,  String victoryMessage, String defeatMessage, Npc enemy, boolean last) {
        super(id, initialMessage, last);
        this.enemy = enemy;
        this.victoryMessage = victoryMessage;
        this.defeatMessage = defeatMessage;
    }

    @Override
    public boolean run(Hero hero) {
        System.out.println(this.initialMessage);
        readContinue();
        cleanScreen();

        boolean heroWin = hero.attack(this.enemy);
        if (!heroWin){
            System.out.println(this.defeatMessage);
            readContinue();
            return false;
        }

        hero.upgradeLevel(this.enemy);
        System.out.println(this.victoryMessage);
        System.out.println("Você subiu para o nível " + hero.getLevel() + " !!");
        System.out.println("Com isso, você ganhou 10 HP,  1 ponto de força e " + enemy.getGold() + " moedas!");
        int option =  readAndValidateInput("Para consultar suas informações digite 1\n\033[3mDigite 0 continuar...\033[0m", 0, 1);
        cleanScreen();
        if (option == 1){
                hero.showDetails();
                readContinue();
        }
        if (!this.last){
            cleanScreen();
            System.out.println("Após essa grande vitória, que tal reforçar as energias?");
            readContinue("Pressione enter para ver as suas opções..");
            cleanScreen();
            hero.usePotion();
        }
        return true;
    }
}
