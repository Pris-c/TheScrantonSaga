package Entities;

import Items.Consumable;
import Items.Weapon;

import java.util.ArrayList;

public class Receptionist extends Hero{

    public Receptionist(String name, int maxHp, int strenght, int gold, Weapon mainWeapon, ArrayList<Consumable> inventory) {
        super(name, maxHp, strenght, gold, mainWeapon, inventory);
    }

    @Override
    public boolean attack(Npc enemy) {
        // Builds a combat and returns yes if the hero wins
        return false;
    }

}
