package gui;

import java.awt.event.ActionListener;

public class GameController{
    private GameModel model;
    private GameView view;
    private GameWindow window;

    public GameController() {
        model = new GameModel();
        view = new GameView(model);
        window = new GameWindow(view);
    }
}
