package Entities;

import Util.Creator.ItemsCreator.CombatConsumableCreator;
import Util.Creator.ItemsCreator.PotionCreator;
import Util.Creator.ItemsCreator.WeaponCreator;
import Util.Util;

import java.util.ArrayList;
import java.util.List;

import static Util.Util.*;

public class SalesRepresentative extends Hero {

    public SalesRepresentative(String name, int maxHp, int strenght, int gold) {
        super(name, maxHp, strenght, gold, WeaponCreator.createCEOFriendship(), new ArrayList<>(List.of(PotionCreator.coffee(), CombatConsumableCreator.createPamHelp())));
    }

    @Override
    public void showDetails() {
        System.out.println("+-----------------------------------------------------------------------------+");
        System.out.printf(largeTextFormat, "                REPRESENTANTE VENDAS");
        System.out.println("+-----------------------------------------------------------------------------+");
        System.out.printf(largeDetailFormat, "Nome", super.name);
        super.showDetails();
    }

    @Override
    public boolean attack(Npc enemy) {

        boolean specialAttack = true;
        boolean endOfFight = false;
        boolean heroWon = false;

        do {
            if (!super.enemyAttack(enemy, 0.8)) {
                return false;
            }

            int attack = super.heroAttack(enemy, specialAttack);
            if (attack == 3){
                specialAttack = false;
            }
            if (enemy.getHp() <= 0){
                return true;
            }
        } while (!endOfFight);
        return false;
    }
}
