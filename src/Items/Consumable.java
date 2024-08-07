package Items;

import java.util.ArrayList;

public abstract class Consumable extends ItemHero {

    public Consumable(String name, int price, ArrayList<String> allowedTo) {
        super(name, price, allowedTo);
    }

    public void showDetails(){
        System.out.println("Nome: " + super.name);
        // TODO: Add coin emoji
        System.out.println("Preço: " + super.price);
        System.out.println("Disponível para: \n[");
        for (String heroi: allowedTo){
            System.out.println("\t" + heroi);
        }
        System.out.println("]");
    }

}
