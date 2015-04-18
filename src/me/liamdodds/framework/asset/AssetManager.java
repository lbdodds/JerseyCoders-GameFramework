package me.liamdodds.framework.asset;

import me.liamdodds.framework.Game;
import me.liamdodds.framework.utility.Manager;

/**
 * Created by Liam Cristoforo-Dodds on 18/04/2015.
 */
public abstract class AssetManager extends Manager {
    protected String baseURL = "/";

    public AssetManager(Game game) {
        super(game);
    }

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }
}
