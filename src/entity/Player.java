package entity;

import item.armor.Armor;
import item.weapon.Weapon;

import java.util.ArrayList;
import java.util.List;

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


}
