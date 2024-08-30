package Entities;

import Util.Creator.ItemsCreator.CombatConsumableCreator;
import Util.Creator.ItemsCreator.PotionCreator;
import Util.Creator.ItemsCreator.WeaponCreator;
import Util.Util;

import java.util.ArrayList;
import java.util.List;

import static Util.Util.*;

/**
 * Represents a specific type of Hero with unique characteristics.
 * The SalesRepresentative is equipped with a "CEO Friendship" weapon and starts with specific potions and combat consumables.
 */
public class SalesRepresentative extends Hero {

    /**
     * Constructs a new SalesRepresentative character with specified attributes.
     *
     * @param name     The name of the SalesRepresentative.
     * @param maxHp    The maximum hit points (HP) the SalesRepresentative can keep.
     * @param strenght The value of strength attribute, it influences attack power.
     * @param gold     The initial amount of gold the SalesRepresentative has.
     */
    public SalesRepresentative(String name, int maxHp, int strenght, int gold) {
        super(name, maxHp, strenght, gold, WeaponCreator.createCEOFriendship(), new ArrayList<>(List.of(PotionCreator.coffee(), CombatConsumableCreator.createPamHelp())));
    }

    /**
     * Print to the console the details of the SalesRepresentative hero.
     */
    @Override
    public void showDetails() {
        System.out.println("+-----------------------------------------------------------------------------+");
        System.out.printf(largeTextFormat, "                REPRESENTANTE VENDAS");
        System.out.println("+-----------------------------------------------------------------------------+");
        System.out.printf(largeDetailFormat, "Nome", super.name);
        super.showDetails();
    }

    /**
     * Executes the SalesRepresentative's attack strategy during combat.
     * The enemy's attacks are decreased by 20% against the SalesRepresentative.
     * The special instant attack can only be used once per combat.
     *
     * @param enemy the enemy that the SalesRepresentative is fighting against.
     * @return true if the SalesRepresentative ends the fight with HP greater than 0; false otherwise.
     */
    @Override
    public boolean attack(Npc enemy) {

        boolean specialAttack = true;
        boolean endOfFight = false;

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
