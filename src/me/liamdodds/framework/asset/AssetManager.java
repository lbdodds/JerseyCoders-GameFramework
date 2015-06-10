package me.liamdodds.framework.asset;

import me.liamdodds.framework.GameData;
import me.liamdodds.framework.utility.Manager;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Liam Cristoforo-Dodds on 18/04/2015.
 */
public abstract class AssetManager extends Manager {
    protected String baseURL = "/";
    protected ArrayList<String> basePaths;
    
    public AssetManager(GameData gameData) {
        super(gameData);
        basePaths = new ArrayList<>();
        basePaths.add(""); // Always include a default basePath that can be used to create a root
    }

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }
    
    public AssetManager addBasePath(String ...basePaths) {
        this.basePaths.addAll(Arrays.asList(basePaths));
        return this;
    }
}
