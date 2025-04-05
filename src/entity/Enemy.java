package entity;

public class Enemy extends NPC{
    public Enemy(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    void attack(Character character) {
        super.attack(character);
    }


}
