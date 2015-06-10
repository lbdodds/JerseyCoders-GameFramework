package me.liamdodds.framework.utility;

import me.liamdodds.framework.GameData;
import me.liamdodds.framework.logging.Loggable;
import me.liamdodds.framework.logging.Logger;
import me.liamdodds.framework.logging.NullLogger;

import java.awt.event.KeyEvent;

/**
 * Created by Liam Cristoforo-Dodds on 18/04/2015.
 */
public abstract class GameObject implements Loggable {
    protected Logger logger = NullLogger.instance;
    protected GameData gameData;
    
    protected GameObject helpers = this;

    public GameObject(GameData gameData) {
        this.gameData = gameData;
    }

    @Override
    public void setLogger(Logger logger) { this.logger = logger; }
    
    public int[] getKeysFromConfig(String key) {
        return gameData.getConfiguration().cast(key, int[].class, new int[]{});
    }
}
