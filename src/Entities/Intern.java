package Entities;

import Items.CombatConsumable;
import Items.Consumable;
import Items.Weapon;
import Util.Util;

import java.util.ArrayList;

import static Util.Util.readAndValidateInput;

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
        // Arqueiro

        boolean specialAttack = true;
        boolean endOfFight = false;
        System.out.println("Sua vez!!");

        // turn
        do {

            int decrement = 0;
            boolean next;
            int option;
            int enemyStrength;

            //Hero Attack
            do{
                next = true;
                if (specialAttack) {
                    String message = "Escolha o tipo de ataque:\n1 - Utilizar um Consumível de Combate\n2 - Ataque comum \n3 - Ataque Especial";
                    option = Util.readAndValidateInput(message, 1, 3);
                } else {
                    String message = "Escolha o tipo de ataque:\n1 - Utilizar um Consumível de Combate\n2 - Ataque comum";
                    option = Util.readAndValidateInput(message, 1, 2);
                }

                switch (option) {
                    case 1:
                        int instantAttack = instantAttack();
                        if (instantAttack != -1){
                            decrement = instantAttack;
                        } else {
                            next = false;
                        }
                        break;
                    case 2:
                        decrement = this.strength + this.mainWeapon.getStandardAttack();
                        break;
                    case 3:
                        decrement = this.strength + this.mainWeapon.getSpecialAttack();
                        specialAttack = false;
                        break;
                }
            } while (!next);

            // Decrement enemy HP
            if (enemy.decrementHp(decrement) <= 0){
                System.out.println("Yeah! Você derrotou o inimigo!");
                return true;
            }
            System.out.println("Boa! Você acertou o inimigo! Agora só restam " + enemy.getHp() + " HP");

            // Enemy Attack
            enemyStrength = (int) Math.round(enemy.strength * 1.10);
            if (this.decrementHp(enemyStrength) <= 0){
                System.out.println("Opss, o inimigo acabou com você!");
                return false;
            }
            System.out.println("Ouch! Você foi atingido! Agora só te restam " + this.getHp() + " HP");

        } while (!endOfFight);
        return false;
    }


    private int instantAttack() {
        // Shows CombatConsumables in inventory
        if (super.inventory.isEmpty()) {
            System.out.println("Desculpe, o seu inventário está vazio!");
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
            System.out.println("Desculpe, você não tem nenhum Consumível de Combate disponível!");
            return -1;
        }

        // Show available consumables
        System.out.println("Consumíveis disponíveis: ");
        for (int i = 0; i < consumables.size(); i++) {
            System.out.println("# " + (i + 1));
            consumables.get(i).showDetails();
            System.out.println();
        }

        // Read and validate an option
        int option = readAndValidateInput("Escolha o item a utilizar:", 0, consumables.size());
        if (option != 0) {
            CombatConsumable consumable = consumables.get(option-1);
            int decrement = consumable.getInstantAttack();
            inventory.remove(consumable);
            return decrement;
        }
        return -1;
    }


}

