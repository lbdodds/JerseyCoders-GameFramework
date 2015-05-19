package me.lbcd;

import me.lbcd.screens.BottleScreen;
import me.liamdodds.framework.Game;

/**
 * Created by Liam Cristoforo-Dodds on 19/05/15.
 */
public class MyGame extends Game {

    public void start() {

        configuration.add("window.title", "Butts");

        gameData.getSpriteManager().setLogger(gameData.getLogger());
        gameData.getSpriteManager().load("bottles", "me/liamdodds/resources/sprites/bottles.png");
        gameData.getAudioManager().play("audio");

        gameData.getScreenManager().add("bottles", new BottleScreen(gameData));

        super.start();
    }

    public static void main(String[] args) {
        new MyGame();
    }
}
