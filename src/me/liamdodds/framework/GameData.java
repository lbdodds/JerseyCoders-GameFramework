package me.liamdodds.framework;

import me.liamdodds.framework.asset.AudioManager;
import me.liamdodds.framework.asset.SpriteManager;
import me.liamdodds.framework.configuration.Configuration;
import me.liamdodds.framework.input.KeyboardManager;
import me.liamdodds.framework.input.MouseManager;
import me.liamdodds.framework.logging.Logger;
import me.liamdodds.framework.logging.ScreenLogger;
import me.liamdodds.framework.screens.ScreenManager;

import java.awt.*;
import java.util.Random;

/**
 * Game Data contains data information about the game and is used to pass
 * around a group of managers and a configuration object to all Updatable
 * objects
 * Created by Liam Cristoforo-Dodds on 18/04/2015.
 */
public class GameData {
    private Framework framework;

    private Random random;
    private ScreenManager screenManager;
    private SpriteManager spriteManager;
    private AudioManager audioManager;
    private KeyboardManager keyboardManager;
    private MouseManager mouseManager;
    private Configuration configuration;
    private Logger logger;

    public GameData(Game game) {
        this.framework = game.getFramework();
        initialize();
    }

    private void initialize() {
        random = new Random();
        logger = new ScreenLogger(this);

        screenManager   = new ScreenManager(this);
        spriteManager   = new SpriteManager(this);
        audioManager    = new AudioManager(this);
        keyboardManager = new KeyboardManager(this);
        mouseManager    = new MouseManager(this);

        configuration = new Configuration();

//        keyboardManager.setLogger(logger);
    }

    public Point getMousePosition() {
        return framework.getMousePosition();
    }

    public Dimension getWindowSize() {
        return new Dimension(framework.getWidth(), framework.getHeight());
    }

    public Logger getLogger() { return logger; }

    public ScreenManager getScreenManager() {
        return screenManager;
    }

    public SpriteManager getSpriteManager() {
        return spriteManager;
    }

    public AudioManager getAudioManager() {
        return audioManager;
    }

    public KeyboardManager getKeyboardManager() {
        return keyboardManager;
    }

    public MouseManager getMouseManager() {
        return mouseManager;
    }

    public Random getRandom() {
        return random;
    }

    public Configuration getConfiguration() {
        return configuration;
    }
}
