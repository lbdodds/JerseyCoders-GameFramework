package me.liamdodds.framework.utility;

import me.liamdodds.framework.Game;

/**
 * Created by Liam Cristoforo-Dodds on 12/04/2015.
 */
public abstract class GameEntity extends GameObject implements Drawable, Updatable {
    public GameEntity(Game game) {
        super(game);
    }
}
