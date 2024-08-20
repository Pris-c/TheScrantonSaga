package Entities;

import Items.Consumable;
import Items.Weapon;
import Util.Util;

import java.util.ArrayList;

public class SalesRepresentative extends Hero {

    public SalesRepresentative(String name, int maxHp, int strenght, int gold) {
        // TODO: Define main Weapon and initial inventory
        super(name, maxHp, strenght, gold, null, new ArrayList<>());
    }

    @Override
    public void showDetails() {
        System.out.println("\n** Herói: Representante de vendas **");
        System.out.println("Nome: " + super.name);
        super.showDetails();
    }

    @Override
    public boolean attack(Npc enemy) {
        // Cavaleiro

        int decrement = 0;
        boolean next;
        boolean specialAttack;
        boolean endOfFight = false;
        int option;
        int enemyStrength;
        specialAttack = true;

        do {

            // Enemy Attack
            enemyStrength = (int) Math.round(enemy.strength * 0.8);
            if (this.decrementHp(enemyStrength) <= 0){
                System.out.println("Opss, o inimigo acabou com você!");
                return false;
            }
            System.out.println("Ouch! Você foi atingido! Agora só te restam " + this.getHp() + " HP");

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


        } while (!endOfFight);

        return false;
    }

}
