package me.lbcd;

import me.lbcd.config.KeyboardConfig;
import me.lbcd.screens.BottleScreen;
import me.liamdodds.framework.Game;
import me.liamdodds.framework.Window;
import me.liamdodds.framework.asset.AudioManager;
import me.liamdodds.framework.asset.SpriteManager;

import java.awt.event.KeyEvent;

/**
 * Created by Liam Cristoforo-Dodds on 19/05/15.
 */
public class MyGame extends Game {

    /**
     * By creating an instance of MyGame, the start method is called (through the Game constructor)
     * The start method is meant to be used for configuration and preparing at least the first screen
     * before the actual window is displayed. The Window will be created by calling super.start()
     */
    public void start() {

        configuration.add(Window.CONFIG_TITLE, "The Bottle Game");
        configuration.add(Window.CONFIG_RESIZE, false);

        gameData.getSpriteManager().addBasePath(SpriteManager.DEFAULT_FOLDER);
        gameData.getAudioManager().addBasePath(AudioManager.DEFAULT_FOLDER);
        
        gameData.getSpriteManager().load("spritesheet.bottles", "bottles.png");
        gameData.getAudioManager().play("audio");

        gameData.getScreenManager().add("screen.bottles", new BottleScreen(gameData));
        
        KeyboardConfig.configure(gameData.getConfiguration());

        super.start();
    }

    public static void main(String[] args) {
        new MyGame();
    }
}
