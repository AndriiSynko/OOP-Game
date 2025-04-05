package entity;

public class NPC extends Character {

    public NPC(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    void takeDamage(int damage) {}

    @Override
    public void getKilled() {

    }
}
