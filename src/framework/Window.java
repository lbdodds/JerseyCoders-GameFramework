package framework;

import javax.swing.*;

/**
 * Create a window for the game to be rendered in. The starting class of the entire application.
 * Created by Liam Cristoforo-Dodds on 05/04/2015.
 */
public class Window extends JFrame {

    /**
     * Constructs the window, setting parameters.
     */
    private Window() {
        this.setTitle("Jersey Coders 2D Game Framework");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        // Sets the action that occurs when the window is closed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Sets the inside panel of the window
        this.setContentPane(new Framework());

        // Makes sure the window is visible
        this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Window());
    }
}
