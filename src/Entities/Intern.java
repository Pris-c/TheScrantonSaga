package Entities;

import Util.Creator.ItemsCreator.CombatConsumableCreator;
import Util.Creator.ItemsCreator.PotionCreator;
import Util.Creator.ItemsCreator.WeaponCreator;
import Util.Util;

import java.util.ArrayList;
import java.util.List;

import static Util.Util.*;

public class Intern extends Hero {

    public Intern(String name, int maxHp, int strenght, int gold) {
        super(name, maxHp, strenght, gold, WeaponCreator.createSecretThreat(), new ArrayList<>(List.of(PotionCreator.coffee(), CombatConsumableCreator.createRyanHelp())));
    }

    @Override
    public void showDetails() {
        System.out.println("+-----------------------------------------------------------------------------+");
        System.out.printf(largeTextFormat, "                      ESTAGIÁRIO");
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
            int attack = super.heroAttack(enemy, specialAttack);
            if (attack == 3){
                specialAttack = false;
            }
            if (enemy.getHp() <= 0){
                return true;
            }

            if (!super.enemyAttack(enemy, 1.1)) {
                return false;
            }
        } while (!endOfFight);
        return false;
    }
}

