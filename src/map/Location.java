package map;

import entity.BossEnemy;
import util.LoadData;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Location {
    private ParkourPhase parkouLevelOne;
    private BattlePhase battle;
    private Tile[] tiles;

    public Location() {
        parkouLevelOne = new ParkourPhase(LoadData.getLevelData(LoadData.LEVEL_1_MAP));
    }

    private List<Level> levels = new ArrayList<>();
    private BossEnemy boss;

    void enter(){};
    void complete(){};

    public void update() {}

    public ParkourPhase getParkorLevelOne() {
        return parkouLevelOne;
    }

    public Tile[] getTiles() {
        return tiles;
    }

    public void setTiles(Tile[] tiles) {
        this.tiles = tiles;
    }

    public Tile getTile(int index) {
        if (index >= 0 && index < tiles.length) return tiles[index];
        return null;
    }
}
