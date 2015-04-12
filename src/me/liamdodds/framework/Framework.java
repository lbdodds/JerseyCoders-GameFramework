package me.liamdodds.framework;

import me.liamdodds.framework.screens.PrimaryScreen;
import me.liamdodds.framework.screens.ScreenManager;
import me.liamdodds.framework.screens.TestScreen;
import me.liamdodds.framework.utility.FPSLock;

import java.awt.*;

/**
 * The Game Framework that runs the game loop
 * Created by Liam Cristoforo-Dodds on 06/04/2015.
 */
public class Framework extends Canvas {

    private ScreenManager screenManager;

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
        screenManager = new ScreenManager();
//        screenManager.push("TestScreen", new TestScreen(Color.RED));
//        screenManager.add("ThirdTestScreen", new TestScreen(Color.GREEN));
//        screenManager.add("PrimaryScreen", new PrimaryScreen(Color.BLUE));

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
    }

    /**
     * Returns the Framework's Screen Manager
     * @return Framework's Screen Manager
     */
    public ScreenManager getScreenManager() {
        return screenManager;
    }
}
