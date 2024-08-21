package Game;

import Entities.Hero;
import Util.ItemsCreator.NpcCreator;

public class Room {




    public static boolean lunchChallenge(Hero hero){
        System.out.println("Michael decidiu que quer algo especial para o almoço, e é sua responsabilidade garantir que ele receba exatamente o que pediu." +
                "\nO problema? Michael é indeciso, e suas demandas são cada vez mais absurdas." +
                "\nVocê precisa agir rápido antes que ele mude de ideia novamente." +
                "\nSerá que você consegue realizar essa tarefa sem perder a cabeça?");

        boolean heroWin = hero.attack(NpcCreator.createMichaelLunch());

        if (heroWin){
            System.out.println("Yeah! Você se livrou dessa! \nO Andy ouviu a conversa e logo se voluntariou para ir comprar o almoço do Michael! \nEle não poderia perder essa oportunidade de ganhar créditos com o chefe!");
        } else {
            System.out.println("Oh não! Você trouxe tiramisú de sobremesa e o Michael se engasgou com o chocolate em pó! \nEle não quer que a vida dele volte a correr riscos tão grandes, e por isso você foi demitido!");
        }

        return heroWin;
    }



}
