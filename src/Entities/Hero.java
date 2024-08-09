package Entities;

import Items.Consumable;
import Items.Potion;
import Items.Weapon;

import java.util.ArrayList;
import java.util.Scanner;

import static Util.Util.readAndValidateInput;

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
        for (Consumable c : inventory) {
            // TODO: change to: inventory.forEach(c -> System.out.println(c.getName()));
            System.out.println("\t" + c.getName());
        }
        System.out.println("]");
    }

    public void usePotion() {
        if (inventory.isEmpty()){
            System.out.println("Desculpe, o seu inventário está vazio!");

        } else {
            // Filter potions in inventory
            ArrayList<Potion> potions =
                    new ArrayList<>(inventory.stream().
                            filter(i -> i instanceof Potion)
                            .map(i -> (Potion) i)
                            .toList()
                    );

            if (potions.isEmpty()){
                System.out.println("Desculpe, você não tem nenhuma Poção disponível!");

            } else {

                // Show potions
                System.out.println("Poções disponíveis: ");
                for (int i = 0; i < potions.size(); i++) {
                    System.out.println("# " + (i + 1));
                    inventory.get(i).showDetails();
                    System.out.println();
                }

                // Read and validate an option
                int option = readAndValidateInput("Escolha a poção a utilizar:", 0, potions.size());

                if (option != 0) {
                    option--;

                    // Increment strength or Hp
                    Potion potionToUse = potions.get(option);
                    super.addHp(potionToUse.getHealing());
                    super.strength += potionToUse.getStrengthIncrement();

                    // Remove potion
                    inventory.remove(potionToUse);
                }
            }
        }
    }

    public abstract boolean attack(Npc enemy);
}
