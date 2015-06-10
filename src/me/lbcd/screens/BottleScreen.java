package me.lbcd.screens;

import me.liamdodds.framework.GameData;
import me.liamdodds.framework.configuration.Configuration;
import me.liamdodds.framework.input.KeyboardManager;
import me.liamdodds.framework.screens.Screen;
import me.liamdodds.framework.sprite.Animation;
import me.liamdodds.framework.sprite.Sprite;
import me.liamdodds.framework.sprite.Spritesheet;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

/**
 * A sample screen that displays a bottle image that has been loaded
 * Created by Liam Cristoforo-Dodds on 19/05/15.
 */
public class BottleScreen extends Screen {

    Animation animation;
    int x = 0;
    int y = 0;

    public BottleScreen(GameData gameData) {
        super(gameData);
        Spritesheet spritesheet = new Spritesheet("spritesheet.bottles", gameData);
        
        spritesheet.add(
                new Sprite("bottle.one", 0, 0, 10, 10),
                new Sprite("bottle.two", 10,0, 10, 10),
                new Sprite("bottle.three", 20, 0, 10, 10)
        );
        
        animation = new Animation(spritesheet);
        animation.addFrame("bottle.one", "bottle.two", "bottle.three");
    }
    
    /**
     * Draw that sweet sweet bottle
     * @param g2d
     */
    @Override
    public void draw(Graphics2D g2d) {
        animation.draw(g2d,x,y);
    }

    /**
     * On update, check to see if you can move the bottle using the arrow keys
     * @param gameData
     */
    @Override
    public void update(GameData gameData) {
        super.update(gameData);
        KeyboardManager keyboard = gameData.getKeyboardManager();
        Configuration config = gameData.getConfiguration();

        if(keyboard.isKeyDown(
            config.cast(
                "keyboard.keys.up",
                int[].class,
                new int[]{KeyEvent.VK_UP, KeyEvent.VK_W}
            )
        )) {
            y--;
        }
        
        if(keyboard.isKeyDown(
                config.cast(
                        "keyboard.keys.down",
                        int[].class,
                        new int[]{KeyEvent.VK_DOWN, KeyEvent.VK_S}
                )
        )) {
            y++;
        }
        if(keyboard.isKeyDown(
                config.cast(
                        "keyboard.keys.left",
                        int[].class,
                        new int[]{KeyEvent.VK_LEFT, KeyEvent.VK_A}
                )
        )) {
            x--;
        }
        if(keyboard.isKeyDown(
                config.cast(
                        "keyboard.keys.right",
                        int[].class,
                        new int[]{KeyEvent.VK_RIGHT, KeyEvent.VK_D}
                )
        )) {
            x++;
        }
        
        animation.update();
    }
}
