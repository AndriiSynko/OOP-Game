package entity;

import java.awt.*;

public abstract class Character implements Killable {
    protected int x, y;
    protected Rectangle hitBox;
    protected int width, height;
    protected int speed, airSpeed;
    protected int gravity;
    protected int jumpSpeed;
    protected int fallSpeedAfterCollision;
    protected boolean inAir = false;
    protected boolean right,left,up,down,moving, jumping;
    protected String name;
    protected int hp;
    protected int damage;

    public Character(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        this.airSpeed = 0;
        this.gravity = 1;
        this.jumpSpeed = -3;
        this.fallSpeedAfterCollision = 2;
        this.inAir = false;
        initHitBox();
    }

    protected void initHitBox() {
        hitBox = new Rectangle(x,y,width,height);
    }

    protected void updateHitBox(){
        hitBox.x = x;
        hitBox.y = y;
    }


    void attack(Character character){};
    abstract void takeDamage(int damage);

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
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

    public Rectangle getHitBox() {
        return hitBox;
    }
}
