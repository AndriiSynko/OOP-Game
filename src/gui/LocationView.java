package gui;

import map.Location;
import map.Tile;
import util.LoadData;

import java.awt.*;
import java.awt.image.BufferedImage;

public class LocationView {
    private Location location;
    private Tile[] tiles;

    public LocationView(Location location) {
        this.location = location;
        loadLocationSprite();
    }

    private void loadLocationSprite() {
        BufferedImage img = LoadData.getImage(LoadData.LEVEL_1_DESIGN);
        tiles = new Tile[256];
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                int index = i*16+j;

                tiles[index]=new Tile();
                tiles[index].setImage(img.getSubimage(j*16, i*16, 16, 16));
                tiles[index].setCollision(false);
            }
        }
        setSolidTiles();
        location.setTiles(tiles);
    }

    private void setSolidTiles() {
        int[] index = {0,1,2,3,4,5,6,7,8,9,
                16,17,18,19,20,21,22,23,24,25,
                36,37,38,39,40,41,42,43,44,
                148,164,180,196,212,226};
        for (int i : index) {
            tiles[i].setCollision(true);
        }
    }


    public void render(Graphics g) {
        for (int row = 0; row < GameModel.TILES_IN_HEIGHT; row++) {
            for (int col = 0; col < GameModel.TILES_IN_WIDTH; col++) {
                int index = location.getParkorLevelOne().getSpriteIndex(col, row);
                    g.drawImage(location.getTiles()[index].getImage(), col * GameModel.TILE_SIZE, row * GameModel.TILE_SIZE,
                            GameModel.TILE_SIZE, GameModel.TILE_SIZE, null);


                    //FOR COLLISION DEBUG
                    g.setColor(Color.CYAN);
                    if (location.getTiles()[index].isCollision()) {
                        g.drawRect(col * GameModel.TILE_SIZE, row * GameModel.TILE_SIZE, GameModel.TILE_SIZE, GameModel.TILE_SIZE);
                    }

            }
        }
    }
}
