package me.liamdodds.framework.logging;

import me.liamdodds.framework.Framework;

import java.awt.*;

/**
 * Created by Liam Cristoforo-Dodds on 18/04/2015.
 */
public class NullLogger implements Logger {
    public static Logger instance = new NullLogger();
    @Override
    public void log(String cls, String message) {
        // Do Nothing
    }

    @Override
    public void draw(Graphics2D g2d) {
        // Do Nothing
    }

    @Override
    public void setFramework(Framework framework) {
        // Do Nothing
    }
}
