package me.liamdodds.framework.screens.test;

import me.liamdodds.framework.GameData;
import me.liamdodds.framework.screens.Screen;
import me.liamdodds.framework.screens.ScreenProcessState;

import java.awt.*;
import java.util.Random;

/**
 * Created by Liam Cristoforo-Dodds on 12/04/2015.
 */
public class PrimaryScreen extends Screen {

    private Color color;
    private int num = 10;
    private Random random = new Random();

    public PrimaryScreen(GameData gameData, Color color) {
        super(gameData);
        this.color = color;
    }

    @Override
    public void update(GameData gameData) {
        num = random.nextInt(100);
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(color);
        for(int i = 0; i < num; i++) {
            g2d.drawRect(random.nextInt(500), random.nextInt(500), 25 + random.nextInt(50), 25 + random.nextInt(50));
        }
    }

    @Override
    public void becomesActive() {

    }

    @Override
    public void becomeInactive() {

    }

    @Override
    public ScreenProcessState getUpdateState() {
        return ScreenProcessState.PRIMARY;
    }

    @Override
    public ScreenProcessState getDrawState() {
        return ScreenProcessState.PRIMARY;
    }
}
