package me.liamdodds.framework.screens;

import me.liamdodds.framework.GameData;
import me.liamdodds.framework.utility.Drawable;
import me.liamdodds.framework.utility.GameObject;
import me.liamdodds.framework.utility.Updatable;

/**
 * Created by Liam Cristoforo-Dodds on 12/04/2015.
 */
public abstract class Screen extends GameObject implements Updatable, Drawable {

    protected boolean isActive = false;
    
    public Screen(GameData gameData) {
        super(gameData);
    }

    @Override
    public void update(GameData gameData) {
        this.gameData = gameData;
    }

    public void becomesActive() {
        isActive = true;
    }
    
    public void becomeInactive() {
        isActive = false;
    }
    
    public ScreenProcessState getUpdateState() {
        return ScreenProcessState.PRIMARY;
    }
    
    public ScreenProcessState getDrawState() {
        return ScreenProcessState.PRIMARY;
    }
}
