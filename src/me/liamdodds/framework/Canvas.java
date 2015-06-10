package me.liamdodds.framework;

import javax.swing.*;
import java.awt.*;

/**
 * A canvas to be drawn to, rendered in the window
 * Created by Liam Cristoforo-Dodds on 05/04/2015.
 */
public abstract class Canvas extends JPanel {

    public Canvas() {
        // Makes sure that the entities drawn to the pane are visible
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        // Makes the background black
        this.setBackground(Color.black);

    }

    /**
     * Called to paint to the panel
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        super.paintComponent(g2d);
        draw(g2d);
    }

    /**
     * Updates the panel
     */
    public abstract void update();

    /**
     * Draws to the panel
     * @param g2d
     */
    public abstract void draw(Graphics2D g2d);

}
