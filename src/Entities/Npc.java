package Entities;

public class Npc extends Entity {

    private String description;

    public Npc(String name, int maxHp, int strength, int gold, String description) {
        super(name, maxHp, strength, gold);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public void showDetails() {
        System.out.println("\n ** Desafio: " + super.name + " **");
        System.out.println("Description: " + this.description);
        super.showDetails();
    }
}
