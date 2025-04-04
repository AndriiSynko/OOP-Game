package item.armor;

import item.Item;
import item.property.Breakable;
import item.property.Repairable;
import item.property.Upgradable;
import item.property.Upgrade;

public class Armor extends Item implements Breakable, Repairable, Upgradable {

    protected int protection;
    protected int durability;

    @Override
    public void crack() {

    }

    @Override
    public void repair() {

    }

    @Override
    public void upgrade(Upgrade upgrade) {

    }
}
