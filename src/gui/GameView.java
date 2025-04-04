package gui;

import entity.Player;

import javax.swing.*;
import java.awt.*;

public class GameView extends JPanel {
    private GameModel model;
    private Player player;

    public GameView(GameModel model) {
        this.model = model;
        this.player = model.getPlayer();
        setPanelSize();
    }

    private void setPanelSize() {
        setPreferredSize(new Dimension(GameModel.GAME_WIDTH, GameModel.GAME_HEIGHT));
    }

    public void render(){
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillRect(player.getX(), player.getY(), player.getWidth(), player.getHeight());
    }
}
