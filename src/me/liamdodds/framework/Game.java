package me.liamdodds.framework;

import me.liamdodds.framework.asset.AudioManager;
import me.liamdodds.framework.asset.SpriteManager;
import me.liamdodds.framework.input.KeyboardManager;
import me.liamdodds.framework.input.MouseManager;
import me.liamdodds.framework.logging.Logger;
import me.liamdodds.framework.logging.ScreenLogger;
import me.liamdodds.framework.screens.ScreenManager;

import java.awt.*;
import java.util.Random;

/**
 * Created by Liam Cristoforo-Dodds on 18/04/2015.
 */
public class Game {
    private Framework framework;

    private Random random;
    private ScreenManager screenManager;
    private SpriteManager spriteManager;
    private AudioManager audioManager;
    private KeyboardManager keyboardManager;
    private MouseManager mouseManager;
    private Logger logger;

    public Game(Framework framework) {
        this.framework = framework;
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

        keyboardManager.setLogger(logger);
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

}
