package Items;

import java.util.ArrayList;

public class CombatConsumable extends Consumable{

    private int instantAttack;

    public CombatConsumable(String name, int price, ArrayList<String> allowedTo, int instantAttack) {
        super(name, price, allowedTo);
        this.instantAttack = instantAttack;
    }

    @Override
    public void showDetails() {
        System.out.println("** Detalhes do Consumível de Combate **");
        System.out.println("Ataque instantâneo: " + this.instantAttack);
        super.showDetails();
    }

}
