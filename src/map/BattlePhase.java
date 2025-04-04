package map;

import entity.Enemy;

import java.util.ArrayList;
import java.util.List;

public class BattlePhase implements Level{
    private List<Enemy> enemies = new ArrayList<>();
    private int[][] lvlData;

    public BattlePhase(int[][] lvlData) {
        this.lvlData = lvlData;
    }

    void spawnEnemy(Enemy enemy){
        enemies.add(enemy);
    }

    @Override
    public void start() {}

    @Override
    public void complete() {}

    @Override
    public int[][] getLvlData() {
        return lvlData;
    }

    public int getSpriteIndex(int x, int y) {
        return lvlData[y][x];
    }
}
