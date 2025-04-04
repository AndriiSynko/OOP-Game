package gui;

import javax.swing.*;

public class GameWindow extends JFrame {

    public GameWindow(GameView view) {
        this.setTitle("OOP 2D Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        this.add(view);
        this.pack();
        this.setVisible(true);    }
}
