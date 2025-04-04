package gui;

import javax.swing.*;
import java.awt.*;

public class GameView extends JPanel {
    private GameModel model;

    public GameView(GameModel model) {
        this.model = model;
        setPanelSize();
    }

    private void setPanelSize() {
        setPreferredSize(new Dimension(GameModel.GAME_WIDTH, GameModel.GAME_HEIGHT));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
