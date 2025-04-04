package map;

import entity.Enemy;

import java.util.ArrayList;
import java.util.List;

public class BattlePhase implements Level{
    private List<Enemy> enemies = new ArrayList<>();

    void spawnEnemy(Enemy enemy){
        enemies.add(enemy);
    }

    @Override
    public void start() {}

    @Override
    public void complete() {}
}
