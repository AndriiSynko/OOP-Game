package entity;

public class BossEnemy extends Enemy{
    public BossEnemy(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    void attack(Character character) {
        super.attack(character);
    }
}
