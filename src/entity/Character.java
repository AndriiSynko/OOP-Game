package entity;

public abstract class Character implements Killable {
    protected int x, y;
    protected int width, height;
    protected int speed;
    protected int hitBox;
    protected String name;
    protected int hp;
    protected int damage;

    void attack(Character character){};
    abstract void takeDamage(int damage);
    void move(){}
}
