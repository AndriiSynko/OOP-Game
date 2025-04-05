package gui;

import gameloop.GameLoop;
import input.KeyHandler;

public class GameController{
    private GameModel model;
    private GameView view;
    private GameWindow window;
    private CollisionChecker collisionChecker;


    private GameLoop gameLoop;
    private Thread gameThread;


    public GameController() {
        model = new GameModel();
        view = new GameView(model);
        window = new GameWindow(view);
//        view.requestFocus();
        startGameLoop();
    }

    private void startGameLoop() {
        gameLoop = new GameLoop(model, view);
        gameThread = new Thread(gameLoop);
        gameThread.start();
    }
}
