package Entities;

import Items.CombatConsumable;
import Items.Consumable;
import Items.Potion;
import Items.Weapon;

import java.util.ArrayList;

import static Util.Util.*;

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

    public void setMainWeapon(Weapon mainWeapon) {
        this.mainWeapon = mainWeapon;
    }

    public boolean pay(int price) {
        if (this.gold < price) {
            return false;

        } else {
            this.gold -= price;
            return true;
        }
    }

    public void addConsumableToInventory(Consumable consumable) {
        this.inventory.add(consumable);
    }

    @Override
    public void showDetails() {
        super.showDetails();
        System.out.printf(largeDetailFormat, "Nível", this.level);
        System.out.printf(largeDetailFormat, "Arma Principal", this.mainWeapon.getName());

        System.out.println("+-----------------------------------------------------------------------------+");
        System.out.printf(largeTextFormat, " -- Consumíveis -- ");
        System.out.println("+-----------------------------------------------------------------------------+");
        if (inventory.isEmpty()) {
            System.out.printf(largeTextFormat, "Nenhum consumível disponível");
        } else {
            for (Consumable c : inventory) {
                if (c instanceof CombatConsumable) {
                    System.out.printf(largeTextFormat, "Ajuda: " + c.getName());
                } else {
                    System.out.printf(largeTextFormat, c.shortDescription());
                }
            }
        }
        System.out.println("+-----------------------------------------------------------------------------+\n");
    }

    public void usePotion() {
        String headerFormat = " %-31s \n";

        if (this.inventory.isEmpty()) {
            System.out.println("+---------------------------------+");
            System.out.printf(headerFormat, "INVENTÁRIO VAZIO");
            System.out.println("+---------------------------------+\n");
        } else {
            // Filter potions in inventory
            ArrayList<Potion> potions =
                    new ArrayList<>(inventory.stream().
                            filter(i -> i instanceof Potion)
                            .map(i -> (Potion) i)
                            .toList()
                    );

            if (potions.isEmpty()) {
                System.out.println("+---------------------------------+");
                System.out.printf(headerFormat, "NENHUMA POÇÃO DISPONÍVEL");
                System.out.println("+---------------------------------+\n");
            } else {


                // Show potions
                System.out.println("+---------------------------------+");
                System.out.printf(headerFormat, "POÇÕES DISPONÍVEIS");
                System.out.println("+---------------------------------+\n");

                for (int i = 0; i < potions.size(); i++) {
                    System.out.printf(headerFormat, "# " + (i + 1));
                    potions.get(i).showDetails();
                }
                System.out.println();


                // Read and validate an option
                int option = readAndValidateInput("Escolha a poção a utilizar:\n\033[3mPara voltar, digite 0. \033[0m", 0, potions.size());

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


    //protected int instantAttack() {
    public int instantAttack() {
        String headerFormat = "| %-31s |\n";
        // Shows CombatConsumables in inventory
        if (this.inventory.isEmpty()) {
            System.out.println("Infelizmente você não tem favores a cobrar. Terá que lidar com isso sozinho!\n\n");
            return -1;
        }

        // Filter CombatConsumable in inventory
        ArrayList<CombatConsumable> consumables =
                new ArrayList<>(inventory.stream().
                        filter(i -> i instanceof CombatConsumable)
                        .map(i -> (CombatConsumable) i)
                        .toList()
                );

        if (consumables.isEmpty()) {
            System.out.println("Você não tem sido um bom colega e ninguém te deve favor algum.\nVocê terá que lidar com isso sozinho!\n\n");
            return -1;
        }

        // Show available consumables
        // Show potions
        System.out.println("+---------------------------------+");
        System.out.printf(headerFormat, "AJUDAS DISPONÍVEIS");
        System.out.println("+---------------------------------+\n");
        for (int i = 0; i < consumables.size(); i++) {
            System.out.println("+---------------------------------+");
            System.out.println("   # " + (i + 1));
            consumables.get(i).showAttackInfo();
            System.out.println("+---------------------------------+\n");
            System.out.println();
        }

        // Read and validate an option
        int option = readAndValidateInput("Escolha a ajuda a utilizar:\n\033[3mPara voltar, digite 0.\033[0m", 0, consumables.size());
        if (option != 0) {
            CombatConsumable consumable = consumables.get(option - 1);
            int decrement = consumable.getInstantAttack();
            inventory.remove(consumable);
            // System.out.println(consumable.getDescription());
            return decrement;
        }
        return -1;
    }

    public abstract boolean attack(Npc enemy);
}
