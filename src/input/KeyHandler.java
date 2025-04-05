package input;

import gui.CollisionChecker;
import gui.GameModel;
import gui.PlayerView;



import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    private GameModel model;

    public KeyHandler(GameModel model) {
        this.model = model;
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
