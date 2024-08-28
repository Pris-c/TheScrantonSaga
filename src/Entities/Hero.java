package Entities;

import Items.CombatConsumable;
import Items.Consumable;
import Items.Potion;
import Items.Weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static Util.Util.*;

public abstract class Hero extends Entity {

    protected int maxHp;
    protected int level;
    protected Weapon mainWeapon;
    protected ArrayList<Consumable> inventory;
    protected Random rd;

    public Hero(String name, int hp, int strength, int gold, Weapon mainWeapon, ArrayList<Consumable> inventory) {
        super(name, hp, strength, gold);
        this.rd = new Random();
        this.level = 1;
        this.maxHp = hp;
        this.mainWeapon = mainWeapon;
        this.inventory = inventory;
    }

    public int getLevel() {
        return level;
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
        String detailsWeaponFormat = "|                             %-17s : %-27s |\n";
        super.showDetails();
        System.out.printf(largeDetailFormat, "Vida máx", this.maxHp);
        System.out.printf(largeDetailFormat, "Nível", this.level);
        System.out.printf(largeDetailFormat, "Instrumento de Poder", this.mainWeapon.getName());
        System.out.printf(detailsWeaponFormat, "Manobra Comum:", this.mainWeapon.getStandardAttack());
        System.out.printf(detailsWeaponFormat, "Enfrentamento Criativo:", this.mainWeapon.getSpecialAttack());


        System.out.println("+-----------------------------------------------------------------------------+");
        System.out.printf(largeTextFormat, " -- Suplementos -- ");
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
        System.out.println("+-----------------------------------------------------------------------------+");
    }

    public void usePotion() {
        String headerFormat = " %-31s \n";

        if (this.inventory.isEmpty()) {
            System.out.println("+---------------------------------+");
            System.out.printf(headerFormat, "INVENTÁRIO VAZIO");
            System.out.println("+---------------------------------+\n");
            readContinue();
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
                readContinue();
            } else {
                // Show potions
                System.out.println("\n+---------------------------------+");
                System.out.printf(headerFormat, "POÇÕES DISPONÍVEIS");
                System.out.println("+---------------------------------+");

                for (int i = 0; i < potions.size(); i++) {
                    System.out.printf(headerFormat, "# " + (i + 1));
                    potions.get(i).offerPotion();
                }
                System.out.println();


                // Read and validate an option
                int option = readAndValidateInput("Escolha a poção a utilizar:\n\033[3mPara seguir, digite 0. \033[0m", 0, potions.size());
                cleanScreen();
                if (option != 0) {
                    option--;

                    // Increment strength or Hp
                    Potion potionToUse = potions.get(option);
                    this.incrementHp(potionToUse.getHealing());
                    super.strength += potionToUse.getStrengthIncrement();
                    // Remove potion
                    inventory.remove(potionToUse);

                    cleanScreen();
                    System.out.println("Ótima escolha!\nAgora você está mais preparado para as próximas missões!\n");

                    option = readAndValidateInput("Digite 1 para consultar informações da personagem\n\033[3mDigite 0 para continuar..\033[0m", 0, 1);
                    if (option == 1) {
                        this.showDetails();
                        readContinue();
                    }
                    cleanScreen();
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
            readContinue();
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
            readContinue();
            return -1;
        }

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

    public void upgradeLevel(Npc enemy) {
        this.level += 1;
        this.maxHp += 10;
        this.hp += 10;
        super.strength += 1;
        super.gold += enemy.gold;
    }

    public void incrementStrength(int strengthIncrement) {
        int newStrength = super.strength + strengthIncrement;
        super.strength = Math.min(newStrength, 100);
    }

    public void decrementStrength(int strengthDecrement) {
        int newStrength = super.strength - strengthDecrement;
        super.strength = Math.max(newStrength, 1);
    }

    public void incrementHp(int hp) {
        int newHp = this.hp + hp;
        if (newHp > maxHp){
            cleanScreen();
            System.out.println("Seu teto de pontos de vida é " + this.maxHp +".");
            System.out.println("Ao usar esta poção, perderá o excedente de " + (newHp + maxHp) + "pontos.");
            int option = readAndValidateInput("Deseja continuar?\n1 - Sim\n0 - Cancelar", 0, 1);
            if (option == 1){
                super.hp = maxHp;
            }
            return;
        }
        super.hp = newHp;
    }

    public String getHeroAttackMessage(){
        ArrayList<String> attackMessages = new ArrayList<>(List.of(
                "Seu plano funcionou muito bem! O desafio está enfraquecido.",
                "Você avançou com firmeza e fez um bom progresso!",
                "Uma jogada certeira! O desafio está começando a ser vencido.",
                "Você encontrou uma boa estratégia e reduziu a pressão!",
                "Com essa ação, o desafio perdeu força. Continue assim!"
        ));
        return attackMessages.get(rd.nextInt(0, attackMessages.size()));
    }
    public String getEnemyAttackMessage(){
        ArrayList<String> enemyAttackMessages = new ArrayList<>(List.of(
                "Parece que você se atrapalhou... Isso custou alguns pontos de energia.",
                "O desafio te pegou desprevenido. Sua confiança está um pouco abalada.",
                "A missão está mais difícil do que parecia... Você perdeu terreno.",
                "A missão está difícil. Você sente o peso do escritório se intensificar.",
                "Um erro estratégico... Isso te deixou um pouco mais cansado."
        ));
        return enemyAttackMessages.get(rd.nextInt(0, enemyAttackMessages.size()));
    }



    public abstract boolean attack(Npc enemy);
}
