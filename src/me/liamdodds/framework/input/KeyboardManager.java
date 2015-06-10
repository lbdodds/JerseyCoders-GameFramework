package me.liamdodds.framework.input;

import me.liamdodds.framework.GameData;
import me.liamdodds.framework.utility.Manager;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Liam Cristoforo-Dodds on 18/04/2015.
 */
public class KeyboardManager extends Manager implements KeyListener {

    private boolean[] state = new boolean[525];

    public KeyboardManager(GameData gameData) {
        super(gameData);
    }

    @Override
    public void keyTyped(KeyEvent e) { /* Do Nothing */ }

    @Override
    public void keyPressed(KeyEvent e) {
        state[e.getKeyCode()] = true;
        StringBuilder b = new StringBuilder();
        for(int i = 0; i < 525; i++) {
            if(state[i]) {
                b.append(KeyEvent.getKeyText(i));
                b.append(" + ");
            }
        }
        b = b.reverse().delete(0, 3).reverse();
        logger.log("Keyboard Manager", b.toString());

    }

    @Override
    public void keyReleased(KeyEvent e) {
        state[e.getKeyCode()] = false;
    }

    /**
     * Checks to see whether the key is down
     * @param key the key to check
     * @return
     */
    public boolean isKeyDown(int key) {
        return state[key];
    }

    /**
     * Checks to see whether any of the passed keys has been pressed
     * @param keys
     * @return
     */
    public boolean isKeyDown(int ...keys) {
        for(int key : keys) {
            if(state[key]) {
                return true;
            }
        }
        return false;
    }
}
