package Entities;

import Util.Creator.ItemsCreator.CombatConsumableCreator;
import Util.Creator.ItemsCreator.PotionCreator;
import Util.Creator.ItemsCreator.WeaponCreator;

import java.util.ArrayList;
import java.util.List;

import static Util.Util.largeDetailFormat;
import static Util.Util.largeTextFormat;

/**
 * Represents a specific type of Hero with unique characteristics.
 * The Intern is equipped with a "Secret Threat" weapon and starts with specific potions and combat consumables.
 */
public class Intern extends Hero {

    /**
     * Constructs an Intern hero with the specified attributes.
     *
     * @param name     The name of the intern character.
     * @param maxHp    Maximum health points (HP) the intern can keep.
     * @param strength The value of strength attribute, it influences attack power.
     * @param gold     The initial amount of gold the intern has.
     */
    public Intern(String name, int maxHp, int strength, int gold) {
        super(name, maxHp, strength, gold, WeaponCreator.createSecretThreat(), new ArrayList<>(List.of(PotionCreator.coffee(), CombatConsumableCreator.createRyanHelp())));
    }

    /**
     * Print to the console the details of the Intern hero.
     */
    @Override
    public void showDetails() {
        System.out.println("+-----------------------------------------------------------------------------+");
        System.out.printf(largeTextFormat, "                      ESTAGIÁRIO");
        System.out.println("+-----------------------------------------------------------------------------+");
        System.out.printf(largeDetailFormat, "Nome", super.name);
        super.showDetails();
    }


    /**
     * Executes the Intern's attack strategy during combat.
     * The enemy's attacks are increased by 10% against the Intern.
     * The special instant attack can only be used once per combat.
     *
     * @param enemy the enemy that the Intern is fighting against.
     * @return true if the Intern ends the fight with HP greater than 0; false otherwise.
     */
    @Override
    public boolean attack(Npc enemy) {
        boolean specialAttack = true;
        boolean endOfFight = false;

        do {
            int attack = super.heroAttack(enemy, specialAttack);
            if (attack == 3) {
                specialAttack = false;
            }
            if (enemy.getHp() <= 0) {
                return true;
            }

            if (!super.enemyAttack(enemy, 1.1)) {
                return false;
            }
        } while (!endOfFight);
        return false;
    }
}

