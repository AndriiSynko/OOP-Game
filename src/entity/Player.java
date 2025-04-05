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
        super.jumpSpeed = -11;
        super.velocityY = 0;
        super.onGround = false;
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
        int dx = 0;

        if (left) dx -= speed;
        if (right) dx += speed;

        if (!onGround) {
            velocityY += GRAVITY;
            if (velocityY > MAX_FALL_SPEED) velocityY = MAX_FALL_SPEED;
        }

        int dy = (int) velocityY;

        Rectangle futureXHitbox = new Rectangle(x + dx, y, hitBox.width, hitBox.height); // horizontal movement
        if (!CollisionChecker.isCollidingWithTiles(futureXHitbox, location)) {
            x += dx;
        } else {
            dx = 0; // hit wall, cancel horizontal movement
        }

        Rectangle futureYHitbox = new Rectangle(x, y + dy, hitBox.width, hitBox.height); //vertical movement
        if (!CollisionChecker.isCollidingWithTiles(futureYHitbox, location)) { // if player does not collide with something above
            y += dy;
            onGround = false;
        } else { // stop before the collision tile (ground or ceiling)
            // trying to move 1p/time in the direction until hitting into something.
            int direction = (int) Math.signum(velocityY); // direction (positive : 1 : move up), (negative : -1 : move down)
            while (!CollisionChecker.isCollidingWithTiles(new Rectangle(x, y + direction, hitBox.width, hitBox.height), location)) {
                y += direction;
            }
            velocityY = 0; // hit something, stop moving

            if (dy > 0) {
                onGround = true; // if falling
            }
        }
    }

    public void jump() {
        System.out.println(onGround);
        if (onGround) {
            velocityY = jumpSpeed;
            onGround = false;
        }
    }
    public int getState() {
        if (up) return JUMPING;
        if (left || right) return RUNNING;
        return IDLE;
    }
}
