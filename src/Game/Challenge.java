package Game;

import Entities.Hero;
import Entities.Npc;

import static Util.Util.*;

public class Challenge {

    private Npc enemy;
    private String introduction;
    private String victoryMessage;
    private String defeatMessage;

    public Challenge(Npc enemy, String introduction, String victoryMessage, String defeatMessage) {
        this.enemy = enemy;
        this.introduction = introduction;
        this.victoryMessage = victoryMessage;
        this.defeatMessage = defeatMessage;
    }

    public boolean run(Hero hero) {
        System.out.println(this.introduction);

        readContinue();
        cleanScreen();

        boolean heroWin = hero.attack(this.enemy);
        if (!heroWin) {
            System.out.println(this.defeatMessage);
        } else {
            hero.upgradeLevel(this.enemy);
            System.out.println(this.victoryMessage);
            System.out.println("Por ter vencido esse desafio, você subiu para o nível " + hero.getLevel() + ",\n" +
                    "ganhou 10 pontos de vida e 1 ponto de força!\n");

            int option = readAndValidateInput("Digite 1 para consultar informações do personagem\n\033[3mDigite 0 para continuar..\033[0m", 0, 1);
            if (option == 1){
                hero.showDetails();
                readContinue();
            }
        }
        return heroWin;
    }
}
