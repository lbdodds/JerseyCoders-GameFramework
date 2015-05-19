package me.liamdodds.framework.screens;

import me.liamdodds.framework.GameData;
import me.liamdodds.framework.utility.Drawable;
import me.liamdodds.framework.utility.GameObject;
import me.liamdodds.framework.utility.Updatable;

/**
 * Created by Liam Cristoforo-Dodds on 12/04/2015.
 */
public abstract class Screen extends GameObject implements Updatable, Drawable {

    public Screen(GameData gameData) {
        super(gameData);
    }

    @Override
    public void update(GameData gameData) {
        this.gameData = gameData;
    }

    public abstract void becomesActive();
    public abstract void becomeInactive();
    public abstract ScreenProcessState getUpdateState();
    public abstract ScreenProcessState getDrawState();
}
