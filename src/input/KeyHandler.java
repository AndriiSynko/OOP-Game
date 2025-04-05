package input;

import gui.GameModel;



import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    private GameModel model;
    private boolean leftPressed, rightPressed, spacePressed;

    public KeyHandler(GameModel model) {
        this.model = model;
        this.leftPressed = false;
        this.rightPressed = false;
        this.spacePressed = false;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A:
                leftPressed = true;
                break;
            case KeyEvent.VK_D:
                rightPressed = true;
                break;
            case KeyEvent.VK_SPACE:
                spacePressed = true;
                model.getPlayer().jump();
                break;
        }
        updateMovement();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A:
                leftPressed = false;
                break;
            case KeyEvent.VK_D:
                rightPressed = false;
                break;
            case KeyEvent.VK_SPACE:
                spacePressed = false;
                break;
        }
        updateMovement();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    private void updateMovement() {
        model.getPlayer().setLeft(leftPressed);
        model.getPlayer().setRight(rightPressed);
        if (spacePressed){
            model.getPlayer().jump();
        }
    }
}
