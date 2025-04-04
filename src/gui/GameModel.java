package gui;

import entity.Player;

public class GameModel {

    private GameView gameView;

    //CONFIGURATION
    public final static int TILES_DEFAULT_SIZE = 32;
    public final static float SCALE = 1.5f;
    public final static int TILES_IN_WIDTH = 30;
    public final static int TILES_IN_HEIGHT = 15;
    public final static int TILE_SIZE = (int)(TILES_DEFAULT_SIZE*SCALE);
    public final static int GAME_WIDTH = TILE_SIZE*TILES_IN_WIDTH;
    public final static int GAME_HEIGHT = TILE_SIZE*TILES_IN_HEIGHT;

    private Player player;

    public GameModel() {
        initPlayer();
    }

    private void initPlayer(){
        player = new Player();
        player.setX(GAME_WIDTH/2);
        player.setY(GAME_HEIGHT/2);
        player.setWidth(TILE_SIZE);
        player.setHeight(TILE_SIZE);
    }

    public void update() {
        player.update();
    }

    public Player getPlayer() {
        return player;
    }
}
