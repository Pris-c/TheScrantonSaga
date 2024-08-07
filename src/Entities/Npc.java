package Entities;

public class Npc extends Entity {

    public Npc(String name, int maxHp, int strenght, int gold) {
        super(name, maxHp, strenght, gold);
    }

    @Override
    public void showDetails() {
        System.out.println("\n ** Informações do Desafio **");
        super.showDetails();
    }
}
