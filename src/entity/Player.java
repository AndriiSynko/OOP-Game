package entity;

import gui.CollisionChecker;
import item.armor.Armor;
import item.weapon.Weapon;
import map.Location;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import static util.Constants.PlayerConstants.*;

public class Player extends Character{
    private int xp;
    private List<Weapon> weapons = new ArrayList<>();
    private List<Armor> armors = new ArrayList<>();

    public Player(int x, int y, int width, int height) {
        super(x,y,width,height);
        super.speed = 5;
    }

    @Override
    public void attack(Character character) {}

    @Override
    public void takeDamage(int damage) {}
    public void heal() {}

    @Override
    public void getKilled() {

    }
    public void update(Location location) {
        updatePosition(location);
        updateHitBox();
    }

    private void updatePosition(Location location) {

        if (!left && !right &&!inAir) { return; }

        int xSpeed = 0, ySpeed = 0; // delta that determines where player want to move
        if (left) xSpeed -= speed;
        if (right) xSpeed += speed;

        if (up) ySpeed -= speed;
        if (down) ySpeed += speed;

        int newX = x + xSpeed;
        int newY = y + ySpeed;

        Rectangle futureHitBox = new Rectangle(newX, newY, hitBox.width, hitBox.height);

        if (!CollisionChecker.isCollidingWithTiles(futureHitBox, location)) {
            x = newX;
            y = newY;
        }
    }

    public int getState() {
        if (up) return JUMPING;
        if (left || right) return RUNNING;
        return IDLE;
    }
}
