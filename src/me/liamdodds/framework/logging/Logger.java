package me.liamdodds.framework.logging;

import me.liamdodds.framework.Framework;

import java.awt.*;

/**
 * Created by Liam Cristoforo-Dodds on 18/04/2015.
 */
public interface Logger {
    public void log(String cls, String message);
    public void draw(Graphics2D g2d);
    public void setFramework(Framework framework);
}
