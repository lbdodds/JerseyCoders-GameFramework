package me.liamdodds.framework;

import me.liamdodds.framework.configuration.Configuration;

import javax.swing.*;

/**
 * Created by Liam Cristoforo-Dodds on 19/05/15.
 */
public class Game {
    protected Framework framework;
    protected GameData gameData;
    protected Configuration configuration;

    protected Game() {
        framework = new Framework(this);
        gameData = new GameData(framework);
        configuration = new Configuration();
    }

    protected void start() {
        SwingUtilities.invokeLater(() -> new Window(framework, configuration));
    }

    public Framework getFramework() {
        return framework;
    }

    public GameData getGameData() {
        return gameData;
    }

    public Configuration getConfiguration() {
        return configuration;
    }
}
