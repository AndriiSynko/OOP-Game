package item.weapon;

import item.Item;
import item.property.Breakable;
import item.property.Repairable;
import item.property.Upgradable;
import item.property.Upgrade;

public class Weapon extends Item implements Upgradable, Repairable, Breakable {
     protected int damage;
     protected int durability;

    @Override
    public void crack(){};

     @Override
     public void repair(){};

    @Override
    public void upgrade(Upgrade upgrade) {
    }
}
