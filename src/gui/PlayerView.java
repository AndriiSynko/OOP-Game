package gui;

import entity.Player;
import util.LoadData;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;


public class PlayerView {
    private BufferedImage[][] rightAnim, leftAnim;
    private int aniTick=0, aniSpeed=10, aniIndex=0;
    private Player player;

    public PlayerView(Player player) {
        this.player = player;
        loadAnimation();
    }

    private void loadAnimation() {
        BufferedImage img = LoadData.getImage(LoadData.PLAYER);
        rightAnim = new BufferedImage[10][4];
        leftAnim = new BufferedImage[10][4];
        for (int i = 0; i < rightAnim.length; i++) {
            for (int j = 0; j < rightAnim[i].length; j++) {
                rightAnim[i][j] = img.getSubimage(j * 32, i * 32, 32, 32);
                leftAnim[i][j]=img.getSubimage((j+4) * 32, i * 32, 32, 32);
            }
        }
    }

    private void updateAnimationTick() {
        aniTick++;
        if (aniTick >= aniSpeed) {
            aniTick = 0;
            aniIndex++;
            if (aniIndex >= 4) {
                aniIndex = 0;
            }
        }
    }

    public void render(Graphics g) {
        updateAnimationTick();

        if (player.isLeft()) {
            g.drawImage(leftAnim[player.getState()][aniIndex], (int)player.getX(),(int)player.getY() ,(int)player.getWidth(), (int)player.getHeight(), null);
        }else {
            g.drawImage(rightAnim[player.getState()][aniIndex], (int)player.getX(),(int)player.getY() ,(int)player.getWidth(), (int)player.getHeight(), null);
        }

        //FOR DEBUG
        drawHitbox(g);
    }

    private void drawHitbox(Graphics g) {
        Rectangle2D.Float hb = player.getHitBox();
        g.setColor(Color.RED);
        g.drawRect((int)hb.x, (int)hb.y, (int)hb.width, (int)hb.height);
    }

}
