package Entities;

public class Npc extends Entity {


    public Npc(String name, int maxHp, int strength, int gold) {
        super(name, maxHp, strength, gold);
    }

    @Override
    public void showDetails() {
        System.out.println("\n ** Desafio: " + super.name + " **");
        super.showDetails();
    }
}
