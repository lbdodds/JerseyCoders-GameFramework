package me.lbcd.config;

import me.liamdodds.framework.configuration.Configuration;

import java.awt.event.KeyEvent;

/**
 * Created by liamdodds on 10/06/15.
 */
public class KeyboardConfig {

    public final static String KEYBOARD_KEYS_UP = "keyboard.keys.up";
    public final static String KEYBOARD_KEYS_DOWN = "keyboard.keys.down";
    public final static String KEYBOARD_KEYS_LEFT = "keyboard.keys.left";
    public final static String KEYBOARD_KEYS_RIGHT = "keyboard.keys.right";

    private KeyboardConfig(){}
    
    public static void configure(Configuration config) {
        config.add(KEYBOARD_KEYS_UP, new int[]{KeyEvent.VK_UP, KeyEvent.VK_W});
        config.add(KEYBOARD_KEYS_DOWN, new int[]{KeyEvent.VK_DOWN, KeyEvent.VK_S});
        config.add(KEYBOARD_KEYS_LEFT, new int[]{KeyEvent.VK_LEFT, KeyEvent.VK_A});
        config.add(KEYBOARD_KEYS_RIGHT, new int[]{KeyEvent.VK_RIGHT, KeyEvent.VK_D});
    }
}
