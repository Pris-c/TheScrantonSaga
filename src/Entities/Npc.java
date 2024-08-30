package Entities;

import static Util.Util.largeDetailFormat;
import static Util.Util.largeTextFormat;

/**
 * Represents a non-player character (NPC) in the game.
 * This class extends the Entity class and is used to create various enemies or challenge characters
 * that the player (Hero) can encounter and fight.
 */
public class Npc extends Entity {

    /**
     * Constructs a new Npc (non-player character) with the specified attributes.
     *
     * @param name     the name of the NPC.
     * @param hp       the hit points (HP) of the NPC.
     * @param strength the strength of the NPC, which affects its attack power.
     * @param gold     the amount of gold the NPC possesses.
     */
    public Npc(String name, int hp, int strength, int gold) {
        super(name, hp, strength, gold);
    }

    /**
     * Print to the console the detailed information of the NPC.
     */
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
