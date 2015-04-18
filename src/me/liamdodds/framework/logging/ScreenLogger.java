package me.liamdodds.framework.logging;

import me.liamdodds.framework.Framework;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * An instance of a logger that logs to the screen (from bottom to top)
 * Created by Liam Cristoforo-Dodds on 18/04/2015.
 */
public class ScreenLogger implements Logger {
    Framework framework;
    ArrayList<String> queue = new ArrayList<>();

    /**
     * Adds the log to the current queue
     * @param cls The name of the class that called for the log
     * @param message The message to log
     */
    public void log(String cls, String message) {

        queue.add("[" + cls + "] " + message);
    }

    /**
     * Flushes the log to the screen (and removes any logs that can't be seen anymore)
     * @param g2d
     */
    public void draw(Graphics2D g2d) {
        ArrayList<String> buffer = (ArrayList<String>)queue.clone();
        ArrayList<String> toBeRemoved = new ArrayList<>();
        Collections.reverse(buffer);
        int height = framework.getHeight();
        int y = height;

        int fontSize = 16;
        int lineHeight = (int)(fontSize * 1.5);

        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
        for(String message : buffer) {
            if(y < -fontSize) {
                toBeRemoved.add(message);
                continue;
            }
            g2d.drawString(message, 10, y - fontSize);
            y -= lineHeight;
        }

        toBeRemoved.forEach(queue::remove);
    }

    /**
     * Sets the framework
     * @param framework
     */
    @Override
    public void setFramework(Framework framework) {
        this.framework = framework;
    }
}
