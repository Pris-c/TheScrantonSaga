package Items;

import java.util.ArrayList;

public abstract class ItemHero {

    protected String name;
    protected int price;
    protected ArrayList<String> allowedTo;

    public ItemHero(String name, int price, ArrayList<String> allowedTo) {
        this.name = name;
        this.price = price;
        this.allowedTo = allowedTo;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public ArrayList<String> getAllowedTo() {
        return allowedTo;
    }

    public void showDetails(){
        System.out.println("Nome: " + this.name);
        System.out.println("Preço: " + this.price);
        System.out.println("Disponível para: [");
        for (String heroi : allowedTo){
            // TODO: change to: allowedTo.forEach(h -> System.out.println("\t" + h));
            System.out.println("\t" + heroi);
        }
        System.out.println("]");

    }
}
