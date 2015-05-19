package me.liamdodds.framework.asset;

import me.liamdodds.framework.GameData;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.HashMap;

/**
 * Loads and stored sprites to be used
 * Created by Liam Cristoforo-Dodds on 18/04/2015.
 */
public class SpriteManager extends AssetManager {
    private HashMap<String, BufferedImage> sprites = new HashMap<>();

    public SpriteManager(GameData gameData) {
        super(gameData);
    }

    /**
     * Loads a sprite to be managed
     * @param name the reference of the sprite
     * @param path the path of the sprite
     * @return the loaded sprite
     */
    public BufferedImage load(String name, String path) {
        if(!sprites.containsKey(name)) {
            try {
                URL url = this.getClass().getResource(baseURL + path);
                BufferedImage sprite = ImageIO.read(url);
                sprites.put(name, sprite);
            } catch (Exception e) {
                logger.log("SpriteManager", "Error loading resource " + path);
                logger.log("SpriteManager", e.getMessage());
            }
        } else {
            logger.log("SpriteManager", "Sprite " + name + " already exists");
        }

        return sprites.get(name);
    }

    /**
     * Fetches a sprite from loaded sprites
     * @param name the sprite reference
     * @return the sprite
     */
    public BufferedImage get(String name) {
        return sprites.get(name);
    }

}
