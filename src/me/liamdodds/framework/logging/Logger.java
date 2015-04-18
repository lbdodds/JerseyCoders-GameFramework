package me.liamdodds.framework.logging;

import me.liamdodds.framework.Framework;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Liam Cristoforo-Dodds on 18/04/2015.
 */
public class Logger {
    Framework framework;
    ArrayList<String> queue = new ArrayList<>();

    public Logger(Framework framework) { this.framework = framework; }

    public void log(String cls, String message) {
        queue.add("[" + cls + "] " + message);
    }

    public void draw(Graphics2D g2d) {
        ArrayList<String> buffer = (ArrayList<String>)queue.clone();
        ArrayList<String> toBeRemove = new ArrayList<>();
        Collections.reverse(buffer);
        int height = framework.getHeight();
        int y = height;
        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("TimesRoman", Font.PLAIN, 16));
        for(String message : buffer) {
            if(y < -16) {
                toBeRemove.add(message);
                continue;
            }
            g2d.drawString(message, 10, y + 16);
            y -= 20;
        }

        for(String message : toBeRemove) {
            queue.remove(message);
        }
    }
}
