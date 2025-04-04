package map;

public class ParkourPhase implements Level{
    private int[][] lvlData;

    public ParkourPhase(int[][] lvlData) {
        this.lvlData = lvlData;
    }

    @Override
    public int[][] getLvlData() {
        return lvlData;
    }

    @Override
    public int getSpriteIndex(int x, int y) {
        return lvlData[y][x];
    }

    @Override
    public void start() {

    }

    @Override
    public void complete() {

    }
}
