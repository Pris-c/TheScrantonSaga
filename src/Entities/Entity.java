package Entities;

import static Util.Util.largeDetailFormat;

public abstract class Entity {

    protected String name;
    protected int hp;
    protected int strength;
    protected int gold;

    public Entity(String name, int hp, int strength, int gold) {
        this.name = name;
        this.hp = hp;
        this.strength = strength;
        this.gold = gold;
    }

    protected void showDetails() {
        System.out.printf(largeDetailFormat, "Vida atual", this.hp);
        System.out.printf(largeDetailFormat, "Força", this.strength);
        System.out.printf(largeDetailFormat, "Moedas", this.gold);
    }

    public int decrementHp(int hp) {
        int newHp = this.hp - hp;
        this.hp = Math.max(0, newHp);
        return this.hp;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getStrength() {
        return strength;
    }

    public int getGold() {
        return gold;
    }
}
