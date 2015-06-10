package me.liamdodds.framework.logging;

import java.awt.*;

/**
 * Created by Liam Cristoforo-Dodds on 18/04/2015.
 */
public interface Logger {
    void log(String cls, String message);
    void draw(Graphics2D g2d);
}
