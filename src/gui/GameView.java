package gui;

import entity.Player;
import input.KeyHandler;

import javax.swing.*;
import java.awt.*;

public class GameView extends JPanel {
    private GameModel model;
    private PlayerView playerView;

    public GameView(GameModel model) {
        this.model = model;
        this.playerView = new PlayerView(model.getPlayer());
        addKeyListener(new KeyHandler(model,playerView));
        setPanelSize();
    }

    private void setPanelSize() {
        setPreferredSize(new Dimension(GameModel.GAME_WIDTH, GameModel.GAME_HEIGHT));
    }

    public void render(Graphics g) {
        playerView.render(g);
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }
}
