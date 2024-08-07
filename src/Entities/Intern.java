package Entities;

import Items.Consumable;
import Items.Weapon;

import java.util.ArrayList;

public class Intern extends Hero {

    public Intern(String name, int maxHp, int strenght, int gold, Weapon mainWeapon, ArrayList<Consumable> inventory) {
        super(name, maxHp, strenght, gold, mainWeapon, inventory);
    }

    @Override
    public void showDetails() {
        System.out.println("\n** Herói: Estagiário **");
        super.showDetails();
    }

    @Override
    public boolean attack(Npc enemy) {
        // Builds a combat and returns yes if the hero wins
        return false;
    }


}

