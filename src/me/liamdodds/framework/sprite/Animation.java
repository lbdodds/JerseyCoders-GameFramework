package me.liamdodds.framework.sprite;

import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 * Created by josephrikmaguire
 */
public class Animation {
    private Spritesheet spritesheet;
    private ArrayList<String> spriteList = new ArrayList<>();
    private boolean once = false;
    private int frame =0;

    public Animation(Spritesheet spritesheet){
        this.spritesheet = spritesheet;
    }
    public Animation(Spritesheet spritesheet, boolean once){
        this(spritesheet);
        this.once = once;
    }
    public void addFrame(String key){
        spriteList.add(key);
    }
    public void addFrame(String ...keys) {
        for(String key : keys) {
            addFrame(key);
        }
    }
    public void draw(Graphics2D g2d, int x, int y){
        spritesheet.draw(g2d, spriteList.get(frame), x, y);
    }
    public void update(){
        if(spriteList.size() -1 > frame){
            frame ++;
        }else{
            if(once == false){
                frame = 0;
            }
        }

    }


}