package gameloop;

import gui.GameModel;
import gui.GameView;

public class GameLoop implements Runnable {

    private final int FPS = 60; //frames per second (what we see on the screen)
    private final int UPS = 60; // updates per second (how often game states of objects are updated)
    private boolean running = true;


    private GameModel model;
    private GameView view;

    public GameLoop(GameModel model, GameView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void run() {

        double timePerFrame = 1000000000 / FPS; // 8,3ms per frame
        double timePerUpdate = 1000000000 / UPS; // 8,3ms per update

        long lastTime = System.nanoTime();
        double deltaU = 0;
        double deltaF = 0;

        while (running) {
            long now = System.nanoTime(); // check current time
            deltaU += (now - lastTime) / timePerUpdate;  // calculates how many units (updates since last loop) have passed
            deltaF += (now - lastTime) / timePerFrame;
            lastTime = now;

            // If enough time have passed: update and repaint

            if (deltaU >= 1) {
                model.update();
                deltaU--;
            }

            if (deltaF >= 1) {
                view.render();
                deltaF--;
            }
        }

    }

    public void stop() {
        running = false;
    }

}
