package me.liamdodds.framework.input;

import me.liamdodds.framework.Framework;
import me.liamdodds.framework.Manager;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Liam Cristoforo-Dodds on 18/04/2015.
 */
public class MouseManager extends Manager implements MouseListener {

    private static boolean[] state = new boolean[3];
    private Framework framework;

    public MouseManager(Framework framework) {
        this.framework = framework;
    }


    @Override
    public void mousePressed(MouseEvent e) {
        state[e.getButton() - 1] = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        state[e.getButton() - 1] = false;
    }

    public Point getPosition() {
        try {
            Point mousePosition = framework.getMousePosition();
            return mousePosition != null ? mousePosition : new Point(0,0);
        } catch(Exception e) {
            return new Point(0,0);
        }
    }

    public boolean isButtonDown(int buttonCode) {
        return state[buttonCode - 1];
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
