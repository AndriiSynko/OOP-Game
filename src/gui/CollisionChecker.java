package gui;

import map.Location;
import map.Tile;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class CollisionChecker {
    public static boolean isCollidingWithTiles(Rectangle2D.Float hitBox, Location location) {
        //TOP LEFT CORNER
        int startX = (int) (hitBox.x / GameModel.TILE_SIZE); // left side
        int startY = (int) (hitBox.y / GameModel.TILE_SIZE); // top side
        //RIGHT BOTTOM CORNER
        int endX = (int)(hitBox.x + hitBox.width-1) / GameModel.TILE_SIZE; // right side
        int endY = (int)(hitBox.y + hitBox.height-1) / GameModel.TILE_SIZE; // bottom side

        //check whether hit box intersects with solid tile by checking position of hit box and tile
        for (int y = startY; y <= endY; y++) {
            for (int x = startX; x <= endX; x++) {
                if (x < 0 || y < 0 || x >= gui.GameModel.TILES_IN_WIDTH || y >= gui.GameModel.TILES_IN_HEIGHT) // if hit box touches bound of screen
                    return true;
                int tileIndex = location.getParkorLevelOne().getSpriteIndex(x, y);
                Tile tile = location.getTile(tileIndex);
                if (tile != null && tile.isCollision()) return true;
            }
        }

        return false;
    }
}
