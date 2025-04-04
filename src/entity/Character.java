package entity;

public abstract class Character implements Killable {
    protected String name;
    protected int hp;
    protected int damage;

    void attack(Character character){};
    abstract void takeDamage(int damage);
}
