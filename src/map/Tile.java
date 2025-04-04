package map;

import java.awt.image.BufferedImage;

public class Tile {
    private boolean collision;
    private BufferedImage image;

    public boolean isCollision() {
        return collision;
    }

    public void setCollision(boolean collision) {
        this.collision = collision;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
