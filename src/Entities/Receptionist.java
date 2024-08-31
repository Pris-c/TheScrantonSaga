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
 * The Receptionist is equipped with a "Client Recommendation" weapon and starts with specific potions and combat consumables.
 */
public class Receptionist extends Hero {

    /**
     * Constructs a new Receptionist character with specified attributes.
     *
     * @param name     The name of the Receptionist.
     * @param maxHp    The maximum hit points (HP) the Receptionist can keep.
     * @param strenght The value of strength attribute, it influences attack power.
     * @param gold     The initial amount of gold the recepcionist has.
     */
    public Receptionist(String name, int maxHp, int strenght, int gold) {
        super(name, maxHp, strenght, gold, WeaponCreator.createClientRecommendation(), new ArrayList<>(List.of(PotionCreator.coffee(), CombatConsumableCreator.createDwightHelp())));
    }

    /**
     * Print to the console the details of the Receptionist hero.
     */
    @Override
    public void showDetails() {
        System.out.println("+-----------------------------------------------------------------------------+");
        System.out.printf(largeTextFormat, "                        RECEPCIONISTA");
        System.out.println("+-----------------------------------------------------------------------------+");
        System.out.printf(largeDetailFormat, "Nome", super.name);
        super.showDetails();

    }


    /**
     * Executes the Recepcionist's attack strategy during combat.
     * The special instant attack can only be used once per combat.
     *
     * @param enemy the enemy that the Recepcionist is fighting against.
     * @return true if the Recepcionist ends the fight with HP greater than 0; false otherwise.
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

            if (!super.enemyAttack(enemy, 1)) {
                return false;
            }
        } while (!endOfFight);
        return false;
    }

}
