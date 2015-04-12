package me.liamdodds.framework.screens;

import me.liamdodds.framework.utility.GameEntity;

/**
 * Created by Liam Cristoforo-Dodds on 12/04/2015.
 */
public interface Screen extends GameEntity {
    void becomesActive();
    void becomeInactive();
    ScreenProcessState getUpdateState();
    ScreenProcessState getDrawState();
}
