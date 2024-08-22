package Entities;

import static Util.Util.detailFormat;
import static Util.Util.singleTextFormat;

public class Npc extends Entity {


    public Npc(String name, int maxHp, int strength, int gold) {
        super(name, maxHp, strength, gold);
    }

    @Override
    public void showDetails() {
        System.out.println("+-----------------------------------------------------------------------------+");
        System.out.printf(singleTextFormat, "                               DETALHES DESAFIO");
        System.out.println("+-----------------------------------------------------------------------------+");
        System.out.printf(detailFormat, "Nome", super.name);
        super.showDetails();
        System.out.println("+-----------------------------------------------------------------------------+\n");
    }
}
