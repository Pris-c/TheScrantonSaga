package Entities;

import Items.CombatConsumable;
import Items.Consumable;
import Items.Weapon;
import Util.Util;

import java.util.ArrayList;

import static Util.Util.readAndValidateInput;

public class Receptionist extends Hero {

    public Receptionist(String name, int maxHp, int strenght, int gold, Weapon mainWeapon, ArrayList<Consumable> inventory) {
        super(name, maxHp, strenght, gold, mainWeapon, inventory);
    }

    @Override
    public void showDetails() {
        System.out.println("\n** Herói: Recepcionista **");
        System.out.println("Nome: " + super.name);
        super.showDetails();
    }

    @Override
    public boolean attack(Npc enemy) {
        // Feiticeiro

        boolean specialAttack = true;
        boolean endOfFight = false;
        System.out.println("Sua vez!!");

        // turn
        do {

            int decrement = 0;
            boolean next;
            int option;

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
                        int instantAttack = super.instantAttack();
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
            if (this.decrementHp(enemy.strength) <= 0){
                System.out.println("Opss, o inimigo acabou com você!");
                return false;
            }
            System.out.println("Ouch! Você foi atingido! Agora só te restam " + this.getHp() + " HP");

        } while (!endOfFight);
        return false;
    }

}
