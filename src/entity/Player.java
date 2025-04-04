package entity;

import item.armor.Armor;
import item.weapon.Weapon;

import java.util.ArrayList;
import java.util.List;

import static util.Constants.PlayerConstants.*;

public class Player extends Character{
    private int xp;
    private List<Weapon> weapons = new ArrayList<>();
    private List<Armor> armors = new ArrayList<>();

    @Override
    public void attack(Character character) {}

    @Override
    public void takeDamage(int damage) {}
    public void heal() {}

    @Override
    public void getKilled() {

    }
    public void update(){
        updatePosition();
    }

    private void updatePosition() {
            if (up) y -= speed;
            if (down) y += speed;
            if (right) x += speed;
            if (left) x -= speed;
    }

    public int getState() {
        if (up) return JUMPING;
        if (left || right) return RUNNING;
        return IDLE;
    }
}
