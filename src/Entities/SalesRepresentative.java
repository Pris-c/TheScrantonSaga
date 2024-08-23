package Entities;

import Util.ItemsCreator.CombatConsumableCreator;
import Util.ItemsCreator.PotionCreator;
import Util.ItemsCreator.WeaponCreator;
import Util.Util;

import java.util.ArrayList;
import java.util.List;

import static Util.Util.*;

public class SalesRepresentative extends Hero {

    public SalesRepresentative(String name, int maxHp, int strenght, int gold) {
        super(name, maxHp, strenght, gold, WeaponCreator.createCEOFriendship(), new ArrayList<>(List.of(PotionCreator.coffee(), CombatConsumableCreator.createPamHelp())));
    }

    @Override
    public void showDetails() {
        System.out.println("+-----------------------------------------------------------------------------+");
        System.out.printf(largeTextFormat, "                  DETALHES REPRESENTANTE VENDAS");
        System.out.println("+-----------------------------------------------------------------------------+");
        System.out.printf(largeDetailFormat, "Nome", super.name);
        super.showDetails();
    }

    @Override
    public boolean attack(Npc enemy) {

        int decrement = 0;
        boolean next;
        boolean specialAttack;
        boolean endOfFight = false;
        int option;
        int enemyStrength;
        specialAttack = true;

        do {
            printScoreboard(enemy);

            // Enemy Attack
            enemyStrength = (int) Math.round(enemy.strength * 0.8);
            if (this.decrementHp(enemyStrength) <= 0) {
                return false;
            }
            System.out.println("Você não agiu rápido o suficiente e perdeu " + enemy.getStrength() + " HP.\n");

            do {
                printScoreboard(enemy);

                next = true;
                if (specialAttack) {
                    String message = "\nEscolha como lidar com essa situação:\n1 - Utilizar ajuda de um colega que te deve um favor.\n2 - Utilizar seus próprios meios para cumprir a missão \n3 - Utilizar seus próprios meios com energia extra";
                    option = Util.readAndValidateInput(message, 1, 3);
                } else {
                    String message = "Escolha como lidar com essa situação:\n1 - Utilizar ajuda de um colega que te deve um favor.\n2 - Utilizar seus próprios meios para cumprir a missão";
                    option = Util.readAndValidateInput(message, 1, 2);
                }

                cleanScreen();
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
                cleanScreen();
            } while (!next);

            if (enemy.decrementHp(decrement) <= 0) {
                return true;
            }
            System.out.println("Boa! Você tornou as coisas mais fáceis!\n");

        } while (!endOfFight);

        return false;
    }

    private void printScoreboard(Npc enemy) {
        String headerFormat = "\t| %-16s | %-16s |\n";
        String scoreFormat = "\t| %16d | %16d |\n";

        String scoreboard =
                "\t+------------------+------------------+\n" +
                        "\t|           PLACAR                    |\n" +
                        "\t+------------------+------------------+\n" +
                        String.format(headerFormat, "Herói", "Missão") +
                        "\t+------------------+------------------+\n" +
                        String.format(scoreFormat, this.hp, enemy.hp) +
                        "\t+------------------+------------------+\n\n";
        System.out.println(scoreboard);
    }


}
