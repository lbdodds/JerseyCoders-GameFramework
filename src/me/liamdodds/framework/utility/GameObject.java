package me.liamdodds.framework.utility;

import me.liamdodds.framework.Game;
import me.liamdodds.framework.logging.Loggable;
import me.liamdodds.framework.logging.Logger;
import me.liamdodds.framework.logging.NullLogger;

/**
 * Created by Liam Cristoforo-Dodds on 18/04/2015.
 */
public abstract class GameObject implements Loggable {
    protected Logger logger = NullLogger.instance;
    protected Game game;

    public GameObject(Game game) {
        this.game = game;
    }

    @Override
    public void setLogger(Logger logger) { this.logger = logger; }
}
