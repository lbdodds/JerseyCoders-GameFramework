package me.lbcd;

import me.lbcd.screens.BottleScreen;
import me.liamdodds.framework.Game;

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

        configuration.add("window.title", "The Bottle Game");

        gameData.getSpriteManager().load("bottles", "me/liamdodds/resources/sprites/bottles.png");
        gameData.getAudioManager().play("audio");

        gameData.getScreenManager().add("bottles", new BottleScreen(gameData));

        super.start();
    }

    public static void main(String[] args) {
        new MyGame();
    }
}
