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

    public abstract void showDetails();
}
