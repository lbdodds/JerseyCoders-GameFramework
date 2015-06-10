package me.liamdodds.framework.sprite;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import me.liamdodds.framework.GameData;
import me.liamdodds.framework.utility.GameObject;

/**
 * Created by josephrikmaguire
 */
public class Spritesheet extends GameObject {
    HashMap<String,Sprite> sprites = new HashMap<>();
    String name;
    BufferedImage spritesheet;
    
    public Spritesheet(String name, String uri, GameData gameData){
        super(gameData);
        this.name = name;
        this.spritesheet = gameData.getSpriteManager().load(name, uri);
    }
    
    public Spritesheet(String name, GameData gameData) {
        super(gameData);
        this.spritesheet = this.gameData.getSpriteManager().get(name);
    }
    
    public void add(Sprite ...spritesToAdd){
        for(Sprite sprite : spritesToAdd) {
            sprites.put(sprite.getName(), sprite);
        }
    }
    public Sprite get(String key){
        return sprites.get(key);
    }
    
    public void draw(Graphics2D gtd, String key, int x, int y){
        Sprite sprite = sprites.get(key);
        gtd.drawImage(spritesheet,
                x,y,x+sprite.getWidth(),y+sprite.getHeight(),
                sprite.getX(),sprite.getY(),sprite.getX()+sprite.getWidth(),sprite.getY()+ sprite.getHeight(),
                null);
    }
}
