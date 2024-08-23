package Entities;

import static Util.Util.largeDetailFormat;
import static Util.Util.largeTextFormat;

public class Npc extends Entity {


    public Npc(String name, int maxHp, int strength, int gold) {
        super(name, maxHp, strength, gold);
    }

    @Override
    public void showDetails() {
        System.out.println("+-----------------------------------------------------------------------------+");
        System.out.printf(largeTextFormat, "                               DETALHES DESAFIO");
        System.out.println("+-----------------------------------------------------------------------------+");
        System.out.printf(largeDetailFormat, "Nome", super.name);
        super.showDetails();
        System.out.println("+-----------------------------------------------------------------------------+\n");
    }
}
