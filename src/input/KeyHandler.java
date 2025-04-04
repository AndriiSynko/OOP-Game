package input;

import gui.GameModel;
import gui.PlayerView;

import static util.Constants.PlayerConstants.*;
import static util.Constants.Directions.*;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    private GameModel model;
    private PlayerView playerView;

    public KeyHandler(GameModel model, PlayerView playerView) {
        this.model = model;
        this.playerView = playerView;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                model.getPlayer().setUp(true);
                break;
            case KeyEvent.VK_A:
                model.getPlayer().setLeft(true);
                break;
            case KeyEvent.VK_S:
                model.getPlayer().setDown(true);
                break;
            case KeyEvent.VK_D:
                model.getPlayer().setRight(true);
                break;
            case KeyEvent.VK_SPACE:
                model.getPlayer().setUp(true);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                model.getPlayer().setUp(false);
                break;
            case KeyEvent.VK_A:
                model.getPlayer().setLeft(false);
                break;
            case KeyEvent.VK_S:
                model.getPlayer().setDown(false);
                break;
            case KeyEvent.VK_D:
                model.getPlayer().setRight(false);
                break;
            case KeyEvent.VK_SPACE:
                model.getPlayer().setUp(false);
                break;
        }
    }
}
