package entity;

import gui.CollisionChecker;
import item.armor.Armor;
import item.weapon.Weapon;
import map.Location;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import static util.Constants.PlayerConstants.*;

public class Player extends Character{
    private int xp;
    private List<Weapon> weapons = new ArrayList<>();
    private List<Armor> armors = new ArrayList<>();

    public Player(float x, float y, float width, float height) {
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

        if (left && !right) dx -= speed;
        else if (right && !left) dx += speed;
        else dx = 0;

        if (!onGround) { //gravity handling
            velocityY += GRAVITY;
            if (velocityY > MAX_FALL_SPEED) velocityY = MAX_FALL_SPEED;
        }

        float dy = (float) velocityY;

        Rectangle2D.Float futureXHitbox = new Rectangle2D.Float(x + dx, y, hitBox.width, hitBox.height); // horizontal movement
        if (!CollisionChecker.isCollidingWithTiles(futureXHitbox, location)) {
            x += dx;
        }


        Rectangle2D.Float futureYHitbox = new Rectangle2D.Float(x, y + dy, hitBox.width, hitBox.height); //vertical movement
        if (!CollisionChecker.isCollidingWithTiles(futureYHitbox, location)) { // if player does not collide with something
            y += dy;
            onGround = false;
        } else {// stop before the collision tile (ground or ceiling)
            // trying to move 1p/time in the direction until hitting into something.
            int direction = (int) Math.signum(velocityY); // direction (positive : 1 : move up), (negative : -1 : move down)
            while (!CollisionChecker.isCollidingWithTiles(
                    new Rectangle2D.Float(x, y + direction, hitBox.width, hitBox.height), location)) {
                y += direction;
            }
            velocityY = 0; // hit something, stop moving
            if (dy > 0) {
                onGround = true; // if falling

                // if holding jump
                if (jumping) {
                    velocityY = jumpSpeed;
                    onGround = false;
                    jumping = false;
                }
            }
        }
    }

    public void jump(boolean jumpPressed) {
        this.jumping = jumpPressed;
        if (jumpPressed && onGround) {
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
