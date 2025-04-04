package map;

import entity.BossEnemy;
import util.LoadData;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Location {
    private ParkourPhase parkouLevelOne;
    private BattlePhase battle;

    public Location() {
        parkouLevelOne = new ParkourPhase(LoadData.getLevelData(LoadData.LEVEL_1_MAP));
    }

    private List<Level> levels = new ArrayList<>();
    private BossEnemy boss;

    void enter(){};
    void complete(){};

    public void update() {

    }

    public ParkourPhase getParkouLevelOne() {
        return parkouLevelOne;
    }
}
