package me.liamdodds.framework;

import me.liamdodds.framework.asset.AudioManager;
import me.liamdodds.framework.asset.SpriteManager;
import me.liamdodds.framework.logging.Logger;
import me.liamdodds.framework.screens.ScreenManager;
import me.liamdodds.framework.utility.FPSLock;

import java.awt.*;
import java.util.Random;

/**
 * The Game Framework that runs the game loop
 * Created by Liam Cristoforo-Dodds on 06/04/2015.
 */
public class Framework extends Canvas {
    private Game game;

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
        game = new Game(this);

        this.addKeyListener(game.getKeyboardManager());
        this.addMouseListener(game.getMouseManager());

        game.getSpriteManager().load("bottles", "bottles.png");
        game.getAudioManager().play("audio");
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
        game.getScreenManager().update();
    }

    /**
     * Draws the game state
     * @param g2d
     */
    @Override
    public void draw(Graphics2D g2d) {
        game.getScreenManager().draw(g2d);
        game.getLogger().draw(g2d);
    }
}
