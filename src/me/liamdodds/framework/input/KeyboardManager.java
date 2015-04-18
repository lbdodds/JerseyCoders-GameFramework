package me.liamdodds.framework.input;

import me.liamdodds.framework.logging.Loggable;
import me.liamdodds.framework.logging.Logger;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Liam Cristoforo-Dodds on 18/04/2015.
 */
public class KeyboardManager implements KeyListener, Loggable {

    private boolean[] state = new boolean[525];
    private Logger logger;

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

    @Override
    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}
