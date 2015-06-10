package me.liamdodds.framework.screens;

/**
 * The state at which the screen is processed (update or draw) depending on position in the stack
 * Created by Liam Cristoforo-Dodds on 12/04/2015.
 */
public enum ScreenProcessState {
    PRIMARY, // Only process if this screen is the primary screen
    SECONDARY, // Only process if this screen is the primary screen OR the secondary screen
    TRANSPARENT // Treat the next screen as if a primary screen
}
