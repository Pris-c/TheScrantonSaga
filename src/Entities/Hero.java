package Entities;

import Items.Consumable;
import Items.Potion;
import Items.Weapon;

import java.util.ArrayList;

public abstract class Hero extends Entity {

    protected int level;
    protected Weapon mainWeapon;
    protected ArrayList<Consumable> inventory;

    public Hero(String name, int maxHp, int strength, int gold, Weapon mainWeapon, ArrayList<Consumable> inventory) {
        super(name, maxHp, strength, gold);
        this.level = 1;
        this.mainWeapon = mainWeapon;
        this.inventory = inventory;
    }

    @Override
    public void showDetails() {
        super.showDetails();
        System.out.println("Nível: " + this.level);
        System.out.println("Arma Principal: " + this.mainWeapon);
        System.out.println("Consumíveis: \n[");
        for (Consumable c : inventory){
            // TODO: change to: inventory.forEach(c -> System.out.println(c.getName()));
            System.out.println("\t" + c.getName());
        }
        System.out.println("]");
    }

    public void usePotion(Potion potion){
        // Shows inventory
        // Reads and validates an option
        // Increments strength or Hp
        // Remove potion
        // Could it use an ItemConsumable with the Item and Quantity?
    }

    public abstract boolean attack(Npc enemy);
}
