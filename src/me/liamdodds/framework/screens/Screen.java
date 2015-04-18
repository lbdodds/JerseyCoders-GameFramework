package me.liamdodds.framework.screens;

import me.liamdodds.framework.Game;
import me.liamdodds.framework.utility.Drawable;
import me.liamdodds.framework.utility.GameObject;
import me.liamdodds.framework.utility.Updatable;

/**
 * Created by Liam Cristoforo-Dodds on 12/04/2015.
 */
public abstract class Screen extends GameObject implements Updatable, Drawable {

    public Screen(Game game) {
        super(game);
    }

    public abstract void becomesActive();
    public abstract void becomeInactive();
    public abstract ScreenProcessState getUpdateState();
    public abstract ScreenProcessState getDrawState();
}
