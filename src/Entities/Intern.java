package Entities;

import Items.Consumable;
import Util.ItemsCreator.CombatConsumableCreator;
import Util.ItemsCreator.PotionCreator;
import Util.ItemsCreator.WeaponCreator;
import Util.Util;

import java.util.ArrayList;
import java.util.List;

public class Intern extends Hero {

    public Intern(String name, int maxHp, int strenght, int gold) {
        super(name, maxHp, strenght, gold, WeaponCreator.createSecretThreat(), new ArrayList<Consumable>(List.of(PotionCreator.coffee(), CombatConsumableCreator.createRyanHelp())));
    }

    @Override
    public void showDetails() {
        System.out.println("\n** Herói: Estagiário **");
        System.out.println("Nome: " + super.name);
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
            do {
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
                        if (instantAttack != -1) {
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
            if (enemy.decrementHp(decrement) <= 0) {
                System.out.println("Yeah! Você derrotou o inimigo!");
                return true;
            }
            System.out.println("Boa! Você acertou o inimigo! Agora só restam " + enemy.getHp() + " HP");

            // Enemy Attack
            enemyStrength = (int) Math.round(enemy.strength * 1.10);
            if (this.decrementHp(enemyStrength) <= 0) {
                System.out.println("Opss, o inimigo acabou com você!");
                return false;
            }
            System.out.println("Ouch! Você foi atingido! Agora só te restam " + this.getHp() + " HP");

        } while (!endOfFight);
        return false;
    }

}

