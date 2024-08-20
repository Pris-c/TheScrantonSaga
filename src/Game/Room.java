package Game;

import Entities.Hero;
import Util.ItemsCreator.NpcCreator;

public class Room {




    public static boolean lunchChallenge(Hero hero){
        System.out.println("Michael decidiu que quer algo especial para o almoço, e é sua responsabilidade garantir que ele receba exatamente o que pediu." +
                "\nO problema? Michael é indeciso, e suas demandas são cada vez mais absurdas." +
                "\nVocê precisa agir rápido antes que ele mude de ideia novamente." +
                "\nSerá que você consegue realizar essa tarefa sem perder a cabeça?");
        return hero.attack(NpcCreator.createMichaelLunch());
    }



}
