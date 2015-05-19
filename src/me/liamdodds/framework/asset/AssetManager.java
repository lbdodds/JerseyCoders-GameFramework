package me.liamdodds.framework.asset;

import me.liamdodds.framework.GameData;
import me.liamdodds.framework.utility.Manager;

/**
 * Created by Liam Cristoforo-Dodds on 18/04/2015.
 */
public abstract class AssetManager extends Manager {
    protected String baseURL = "/";

    public AssetManager(GameData gameData) {
        super(gameData);
    }

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }
}
