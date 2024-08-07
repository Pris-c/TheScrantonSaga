package Entities;

public class Npc extends Entity {

    public Npc(String name, int maxHp, int strenght, int gold) {
        super(name, maxHp, strenght, gold);
    }

    @Override
    public void showDetails() {
        // Shows important information about the NPC
    }
}
