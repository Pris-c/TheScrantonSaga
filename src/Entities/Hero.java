package Entities;

import Items.Consumable;
import Items.Potion;
import Items.Weapon;

import java.util.ArrayList;

public abstract class Hero extends Entity {

    protected int level;
    protected Weapon mainWeapon;
    protected ArrayList<Consumable> inventory;

    public Hero(String name, int maxHp, int strenght, int gold, Weapon mainWeapon, ArrayList<Consumable> inventory) {
        super(name, maxHp, strenght, gold);
        this.level = 1;
        this.mainWeapon = mainWeapon;
        this.inventory = inventory;
    }

    public void usePotion(Potion potion){
        // Shows inventory
        // Reads and validates an option
        // Increments strength or Hp
        // Remove potion
        // Could it use an ItemConsumable with the Item and Quantity?
    }

    @Override
    public void showDetails() {
        // Shows important information about the Hero
    }

    public abstract boolean attack(Npc enemy);
}
