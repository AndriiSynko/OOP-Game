package entity;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public abstract class Character implements Killable {
    protected float x, y;
    protected Rectangle2D.Float hitBox;
    protected float width, height;
    protected int speed;
    protected double velocityY;
    protected final double GRAVITY = 0.5;
    protected final double MAX_FALL_SPEED = 10;
    protected double jumpSpeed;
    protected boolean right,left,up,down,moving, onGround, jumping;
    protected String name;
    protected int hp;
    protected int damage;

    public Character(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        initHitBox();
    }

    protected void initHitBox() {
        hitBox = new Rectangle2D.Float(x, y, width, height);
    }

    protected void updateHitBox(){
        hitBox.x = x;
        hitBox.y = y;
    }


    void attack(Character character){};
    abstract void takeDamage(int damage);

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public Rectangle2D.Float getHitBox() {
        return hitBox;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public int getSpeed() {
        return speed;
    }

    public void setJumping(boolean jumping) {
        this.jumping = jumping;
    }
}
