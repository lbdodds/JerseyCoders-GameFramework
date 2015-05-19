package me.liamdodds.framework;

import me.liamdodds.framework.configuration.ConfigObject;
import me.liamdodds.framework.configuration.Configurable;
import me.liamdodds.framework.configuration.Configuration;

import javax.swing.*;
import java.awt.*;

/**
 * Create a window for the game to be rendered in. The starting class of the entire application.
 * Created by Liam Cristoforo-Dodds on 05/04/2015.
 */
public class Window extends JFrame implements Configurable {

    /**
     * Constructs the window, setting parameters.
     */
    private Window(Configuration configuration) {
        configuration.subscribe(this);
        this.setTitle(configuration.cast("window.title", String.class, "Jersey Coders 2D Game Framework"));
        this.setSize(configuration.cast("window.size", Dimension.class, new Dimension(800, 600)));
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        // Sets the action that occurs when the window is closed
        this.setDefaultCloseOperation(configuration.cast("window.defaultCloseOperation", int.class, WindowConstants.EXIT_ON_CLOSE));

        // Sets the inside panel of the window
        this.setContentPane(new Framework());

        // Makes sure the window is visible
        this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Window(new Configuration()));
    }

    @Override
    public void onConfigurationChange(ConfigObject configObject) {
        if(configObject.isKey("window.title")) {
            this.setTitle(configObject.cast(String.class, this.getTitle()));
        }
        if(configObject.isKey("window.size")) {
            this.setSize(configObject.cast(Dimension.class, this.getSize()));
        }
    }
}
