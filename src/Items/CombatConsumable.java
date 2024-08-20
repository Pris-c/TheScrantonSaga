package Items;

import java.util.ArrayList;

public class CombatConsumable extends Consumable {

    private int instantAttack;
    private String description;

    public CombatConsumable(String name, int price, ArrayList<String> allowedTo, int instantAttack, String description) {
        super(name, price, allowedTo);
        this.instantAttack = instantAttack;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public void showDetails() {
        System.out.println("** Consumível de Combate " + super.name + " **");
        System.out.println("Descrição: " + this.description);
        System.out.println("Ataque instantâneo: " + this.instantAttack);
        super.showDetails();
    }

    public void showAttackInfo() {
        System.out.println("\t" + super.name);
        System.out.println("\tForça da ajuda: " + this.instantAttack);
    }

    public int getInstantAttack() {
        return instantAttack;
    }
}
