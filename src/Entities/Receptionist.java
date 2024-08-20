package Entities;

import Items.Consumable;
import Util.ItemsCreator.CombatConsumableCreator;
import Util.ItemsCreator.PotionCreator;
import Util.ItemsCreator.WeaponCreator;
import Util.Util;

import java.util.ArrayList;
import java.util.List;

public class Receptionist extends Hero {

    public Receptionist(String name, int maxHp, int strenght, int gold) {
        super(name, maxHp, strenght, gold, WeaponCreator.createClientRecommendation(), new ArrayList<Consumable>(List.of(PotionCreator.coffee(), CombatConsumableCreator.createDwightHelp())));
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

        // turn
        do {

            int decrement = 0;
            boolean next;
            int option;

            //Hero Attack
            do {
                next = true;
                if (specialAttack) {
                    String message = "Escolha como lidar com essa situação::\n1 - Utilizar ajuda de um colega que te deve um favor.\n2 - Utilizar seus próprios meios para cumprir a missão \n3 - Utilizar seus próprios meios com energia extra";
                    option = Util.readAndValidateInput(message, 1, 3);
                } else {
                    String message = "Escolha como lidar com essa situação::\n1 - Utilizar ajuda de um colega que te deve um favor.\n2 - Utilizar seus próprios meios para cumprir a missão";
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
                        System.out.println(this.mainWeapon.getStandarAttackddescription());
                        break;
                    case 3:
                        decrement = this.strength + this.mainWeapon.getSpecialAttack();
                        System.out.println(this.mainWeapon.getSpecialAttackdescription());
                        specialAttack = false;
                        break;
                }
            } while (!next);

            // Decrement enemy HP
            if (enemy.decrementHp(decrement) <= 0) {
                System.out.println("Yeah! Você conseguiu passar pela missão!");
                return true;
            }
            System.out.println("Boa! Você tornou as coisas mais fáceis! Faltam " + enemy.getHp() + " pontos para concluir a missão");

            // Enemy Attack
            if (this.decrementHp(enemy.strength) <= 0) {
                System.out.println("Opss, Michael não gostou da sua abordagem diante do problema e te demitiu.");
                return false;
            }
            System.out.println("Michal acha que você ainda não se esforçou o suficiente! Agora só te restam " + this.getHp() + " HP");

        } while (!endOfFight);
        return false;
    }

}
