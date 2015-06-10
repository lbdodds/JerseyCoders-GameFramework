package me.liamdodds.framework;

import me.liamdodds.framework.configuration.ConfigObject;
import me.liamdodds.framework.configuration.Configurable;
import me.liamdodds.framework.configuration.Configuration;

import javax.swing.*;
import java.awt.*;

/**
 * Create a window for the game to be rendered in.
 * Created by Liam Cristoforo-Dodds on 05/04/2015.
 */
public class Window extends JFrame implements Configurable {
    
    public static final String CONFIG_TITLE = "window.title";
    public static final String CONFIG_SIZE = "window.size";
    public static final String CONFIG_UNDECORATED = "window.undecorated";
    public static final String CONFIG_RESIZE = "window.resizable";
    public static final String CONFIG_DEFAULT_CLOSE = "window.defaultCloseOperation";
    public static final String CONFIG_VISIBLE = "window.visible";
    
    public static final String DEFAULT_TITLE = "Jersey Coders 2D Game Framework";
    public static final Dimension DEFAULT_SIZE = new Dimension(800, 600);
    public static final boolean DEFAULT_RESIZE = false;
    public static final boolean DEFAULT_UNDECORATED = false;
    public static final boolean DEFAULT_VISIBLE = true;
    public static final int DEFAULT_DEFAULT_CLOSE = WindowConstants.EXIT_ON_CLOSE;

    /**
     * Constructs the window, setting parameters.
     */
    public Window(Game game) {
        Configuration configuration = game.getConfiguration();
        Framework framework = game.getFramework();

        configuration.subscribe(this);
        this.setTitle(configuration.cast(CONFIG_TITLE, String.class, DEFAULT_TITLE));
        this.setSize(configuration.cast(CONFIG_SIZE, Dimension.class, DEFAULT_SIZE));
        this.setResizable(configuration.cast(CONFIG_RESIZE, boolean.class, DEFAULT_RESIZE));
        
        this.setUndecorated(configuration.cast(CONFIG_UNDECORATED, boolean.class, DEFAULT_UNDECORATED));
        
//        this.setLocationRelativeTo(null);

        // Sets the action that occurs when the window is closed
        this.setDefaultCloseOperation(configuration.cast(CONFIG_DEFAULT_CLOSE, int.class, DEFAULT_DEFAULT_CLOSE));

        // Sets the inside panel of the window
        this.setContentPane(framework);

        // Makes sure the window is visible
        this.setVisible(configuration.cast(CONFIG_VISIBLE, boolean.class, DEFAULT_VISIBLE));

        framework.start();
    }

    @Override
    public void onConfigurationChange(ConfigObject configObject) {
        if(configObject.isKey(CONFIG_TITLE)) {
            this.setTitle(configObject.cast(String.class, this.getTitle()));
        }
        if(configObject.isKey(CONFIG_SIZE)) {
            this.setSize(configObject.cast(Dimension.class, this.getSize()));
        }
    }
}
