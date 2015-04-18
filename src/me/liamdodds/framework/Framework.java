package me.liamdodds.framework;

import me.liamdodds.framework.input.KeyboardManager;
import me.liamdodds.framework.input.MouseManager;
import me.liamdodds.framework.logging.Logger;
import me.liamdodds.framework.logging.ScreenLogger;
import me.liamdodds.framework.screens.ScreenManager;
import me.liamdodds.framework.utility.FPSLock;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.Random;

/**
 * The Game Framework that runs the game loop
 * Created by Liam Cristoforo-Dodds on 06/04/2015.
 */
public class Framework extends Canvas {

    private Random random;
    private ScreenManager screenManager;
    private KeyboardManager keyboard;
    private MouseManager mouse;
    private Logger logger;

    public Framework() {
        super();

        /*
         *  Start a new a thread, as to avoid running the gameLoop on the
         *  AWT thread and blocking
         */
        Thread gameThread = new Thread() {
            @Override
            public void run() {
                gameLoop();
            }
        };
        gameThread.start();
    }

    /**
     * Initializes the framework
     */
    private void initialize() {
        random = new Random();
        screenManager = new ScreenManager();
        logger = new ScreenLogger();
        logger.setFramework(this);

        keyboard = new KeyboardManager();
        keyboard.setLogger(logger);

        mouse = new MouseManager(this);
        mouse.setLogger(logger);

        this.addKeyListener(keyboard);
        this.addMouseListener(mouse);
    }

    /**
     * Loops over the key elements to getting the game to run; Update, Draw, FPS Lock
     */
    private void gameLoop() {
        initialize();
        while(true) {
            FPSLock.start();
            update();
            repaint();
            FPSLock.finish();
        }
    }

    /**
     * Updates the game state
     */
    @Override
    public void update() {
        screenManager.update();
    }

    /**
     * Draws the game state
     * @param g2d
     */
    @Override
    public void draw(Graphics2D g2d) {
        screenManager.draw(g2d);
        logger.draw(g2d);
    }

    /**
     * Returns the Framework's Screen Manager
     * @return Framework's Screen Manager
     */
    public ScreenManager getScreenManager() {
        return screenManager;
    }

    /**
     * Returns the Framework's Logger instance
     * @return Framework's Logger instance
     */
    public Logger getLogger() { return logger; }
}
