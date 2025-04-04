package gui;

import gameloop.GameLoop;

public class GameController{
    private GameModel model;
    private GameView view;
    private GameWindow window;


    private GameLoop gameLoop;
    private Thread gameThread;

    public GameController() {
        model = new GameModel();
        view = new GameView(model);
        window = new GameWindow(view);
        startGameLoop();
    }

    private void startGameLoop() {
        gameLoop = new GameLoop(model, view);
        gameThread = new Thread(gameLoop);
        gameThread.start();
    }
}
