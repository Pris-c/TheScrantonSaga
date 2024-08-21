package Entities;

public abstract class Entity {

    protected String name;
    protected int maxHp;
    protected int hp;
    protected int strength;
    protected int gold;

    public Entity(String name, int maxHp, int strength, int gold) {
        this.name = name;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.strength = strength;
        this.gold = gold;
    }

    protected void showDetails(){
        System.out.println("| Hp máximo       : " + this.maxHp);
        System.out.println("| Hp atual        : " + this.hp);
        System.out.println("| Força           : " + this.strength);
        System.out.println("| Moedas          : " + this.gold);
    }

    public void addHp(int hp){
        int newHp = this.hp + hp;
        this.hp = Math.min(newHp, this.maxHp);
    }

    public int decrementHp(int hp){
        int newHp = this.hp - hp;
        this.hp = Math.max(0, newHp);
        return this.hp;
    }

    public String getName() {
        return name;
    }

    public int getMaxHp() {
        return maxHp;
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
