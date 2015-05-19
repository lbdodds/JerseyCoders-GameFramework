package me.liamdodds.framework;

import me.liamdodds.framework.configuration.Configuration;

import javax.swing.*;

/**
 * The Game is the starting point of the framework and instantiates everything
 * requires and exposes game configuration options, along with the framework
 * and gameData to a parent class.
 * Created by Liam Cristoforo-Dodds on 19/05/15.
 */
public class Game {
    protected Framework framework;
    protected GameData gameData;
    protected Configuration configuration;

    protected Game() {
        framework = new Framework(this);
        gameData = new GameData(this);
        configuration = new Configuration();
    }

    /**
     * Starts the window
     */
    protected void start() {
        SwingUtilities.invokeLater(() -> new Window(this));
    }

    /**
     * Returns the framework
     * @return
     */
    public Framework getFramework() {
        return framework;
    }

    /**
     * Returns the game data
     * @return
     */
    public GameData getGameData() {
        return gameData;
    }

    /**
     * Returns the game configuration
     * @return
     */
    public Configuration getConfiguration() {
        return configuration;
    }
}
