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
    ArrayList<LogMessage> queue = new ArrayList<>();

    /**
     * Adds the log to the current queue
     * @param cls The name of the class that called for the log
     * @param message The message to log
     */
    public void log(String cls, String message) {

        queue.add(new LogMessage(cls, message));
    }

    /**
     * Flushes the log to the screen (and removes any logs that can't be seen anymore)
     * @param g2d
     */
    public void draw(Graphics2D g2d) {
        ArrayList<LogMessage> buffer = (ArrayList<LogMessage>)queue.clone();
        ArrayList<LogMessage> toBeRemoved = new ArrayList<>();
        Collections.reverse(buffer);
        int height = framework.getHeight();
        int y = height;

        for(LogMessage message : buffer) {
            if(y < 0-message.getFont().getSize()) {
                toBeRemoved.add(message);
                continue;
            }

            g2d.setColor(message.getColor());
            g2d.setFont(message.getFont());
            g2d.drawString(message.getLog(), 10, y - message.getFont().getSize());
            y -= message.getLineHeight();
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
