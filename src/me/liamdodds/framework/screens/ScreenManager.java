package me.liamdodds.framework.screens;

import me.liamdodds.framework.GameData;
import me.liamdodds.framework.utility.Manager;
import me.liamdodds.framework.utility.Drawable;
import me.liamdodds.framework.utility.Updatable;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Liam Cristoforo-Dodds on 12/04/2015.
 */
public class ScreenManager extends Manager implements Drawable, Updatable {

    private HashMap<String, Screen> screens = new HashMap<>();
    private ArrayList<Screen> stack = new ArrayList<>();

    public ScreenManager(GameData gameData) {
        super(gameData);
    }

    /**
     * Gets the primary screen
     * @return the primary screen
     */
    private Screen getPrimaryScreen() {
        if(stack.size() == 0) { return null; }
        return stack.get(0);
    }

    /**
     * Adds the passed screen to be managed
     * @param reference
     * @param screen
     */
    public void add(String reference, Screen screen) {
        if(reference == null || screen == null) { throw new NullPointerException(); }

        // Implement exception at some point
        if(screens.containsKey(reference)) { return; }

        screens.put(reference, screen);
        stack.add(screen);
    }

    /**
     * Adds the passed screen to be managed and makes it the primary screen
     * @param reference
     * @param screen
     */
    public void push(String reference, Screen screen) {
        add(reference, screen);
        makePrimary(reference);
    }

    /**
     * Make a screen primary
     * Triggers becomesInactive on the old primary and becomesActive on the new primary
     * @param reference
     */
    public void makePrimary(String reference) {
        Screen primary = getPrimaryScreen();
        Screen screen = screens.get(reference);
        if(screen != null) {
            int index = stack.indexOf(screen);
            if(index > 0) {
                stack.remove(screen);
                stack.add(0, screen);
                primary.becomeInactive();
                screen.becomesActive();
            }
        }
    }

    public boolean isPrimary(Screen screen) {
        return getPrimaryScreen() == screen;
    }

    /**
     * Updates the screens depending on their ScreenProcessState
     */
    public void update() {
        if(stack.isEmpty()) { return; }
        Screen active = getPrimaryScreen();
        Screen previous = active;
        for(Screen screen : stack) {
            if(previous.getUpdateState() == ScreenProcessState.TRANSPARENT) { active = screen; }
            if(screen.getUpdateState() == ScreenProcessState.PRIMARY && screen != active) { continue; }
            if(screen.getUpdateState() == ScreenProcessState.SECONDARY && previous != null && previous != active) { continue; }
            if(screen.getUpdateState() == ScreenProcessState.TRANSPARENT && screen != active)  { continue; }

            screen.update();
            previous = screen;
        }
    }

    /**
     * Draws the screens depending on their ScreenProcessState
     * @param g2d
     */
    public void draw(Graphics2D g2d) {
        if(stack.isEmpty()) { return; }
        Screen active = getPrimaryScreen();
        Screen previous = active;
        for(Screen screen : stack) {
            if(previous.getDrawState() == ScreenProcessState.TRANSPARENT) { active = screen; }
            if(screen.getDrawState() == ScreenProcessState.PRIMARY && screen != active) { continue; }
            if(screen.getDrawState() == ScreenProcessState.SECONDARY && previous != null && previous != active) { continue; }
            if(screen.getDrawState() == ScreenProcessState.TRANSPARENT && screen != active)  { continue; }

            screen.draw(g2d);
            previous = screen;
        }
    }
}
