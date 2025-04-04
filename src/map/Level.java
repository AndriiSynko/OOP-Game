package map;

public interface Level {
    void start();

    void complete();

    int[][] getLvlData();
    int getSpriteIndex(int x, int y);
}