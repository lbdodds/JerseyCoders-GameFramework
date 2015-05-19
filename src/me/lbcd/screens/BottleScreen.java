package me.lbcd.screens;

import me.liamdodds.framework.GameData;
import me.liamdodds.framework.screens.Screen;
import me.liamdodds.framework.screens.ScreenProcessState;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

/**
 * A sample screen that displays a bottle image that has been loaded
 * Created by Liam Cristoforo-Dodds on 19/05/15.
 */
public class BottleScreen extends Screen {

    int x = 0;
    int y = 0;

    public BottleScreen(GameData gameData) {
        super(gameData);
    }

    @Override
    public void becomesActive() {

    }

    @Override
    public void becomeInactive() {

    }

    @Override
    public ScreenProcessState getUpdateState() {
        return ScreenProcessState.PRIMARY;
    }

    @Override
    public ScreenProcessState getDrawState() {
        return ScreenProcessState.PRIMARY;
    }

    /**
     * Draw that sweet sweet bottle
     * @param g2d
     */
    @Override
    public void draw(Graphics2D g2d) {
        BufferedImage bottles = gameData.getSpriteManager().get("bottles");
        g2d.drawImage(bottles, x, y, null);
    }

    /**
     * On update, check to see if you can move the bottle using the arrow keys
     * @param gameData
     */
    @Override
    public void update(GameData gameData) {
        super.update(gameData);

        if(gameData.getKeyboardManager().isKeyDown(KeyEvent.VK_UP)) {
            y--;
        }
        if(gameData.getKeyboardManager().isKeyDown(KeyEvent.VK_DOWN)) {
            y++;
        }
        if(gameData.getKeyboardManager().isKeyDown(KeyEvent.VK_LEFT)) {
            x--;
        }
        if(gameData.getKeyboardManager().isKeyDown(KeyEvent.VK_RIGHT)) {
            x++;
        }
    }
}
