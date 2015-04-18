package me.liamdodds.framework;

import me.liamdodds.framework.logging.Loggable;
import me.liamdodds.framework.logging.Logger;
import me.liamdodds.framework.logging.NullLogger;

/**
 * Created by Liam Cristoforo-Dodds on 18/04/2015.
 */
public abstract class Manager implements Loggable {
    protected Logger logger = NullLogger.instance;

    @Override
    public void setLogger(Logger logger) { this.logger = logger; }
}
