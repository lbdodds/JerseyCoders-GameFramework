package me.liamdodds.framework.asset;

import me.liamdodds.framework.GameData;

import javax.sound.sampled.*;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;

/**
 * Created by Liam Cristoforo-Dodds on 18/04/2015.
 */
public class AudioManager extends AssetManager {
    public final static String DEFAULT_FOLDER = "/me/liamdodds/resources/audio/";
    
    private HashMap<String, String> audio = new HashMap<>();

    public AudioManager(GameData gameData) {
        super(gameData);
    }

    public void load(String name, String path) {
        if(!audio.containsKey(name)) {
            for(String basePath : basePaths) {
                try {
                    InputStream is = this.getClass().getResourceAsStream(basePath + path);
                    audio.put(name, basePath + path);
                    break;
                } catch (Exception e) {
                    logger.log("AudioManager", "There was an exception attempting to load " + path);
                    logger.log("AudioManager", e.getMessage());
                }
            }
        }
    }

    public void play(String name) {
        Thread audioThread = new Thread() {
            public void run() {
                try {
                    InputStream is = this.getClass().getResourceAsStream(audio.get(name));
                    AudioInputStream stream = AudioSystem.getAudioInputStream(is);
                    AudioFormat format = stream.getFormat();
                    DataLine.Info info = new DataLine.Info(Clip.class, format);

                    stream.mark(0);
                    Clip clip = (Clip) AudioSystem.getLine(info);
                    clip.open(stream);
                    clip.start();
                    while(!clip.isRunning()) { Thread.sleep(10); }
                    while(clip.isRunning()) { Thread.sleep(10); }
                    clip.close();
                } catch (Exception e) {
                    logger.log("AudioManager", "There was an exception attempting to play " + name);
                    logger.log("AudioManager", e.getMessage());
                }
            }
        };
        audioThread.start();
    }
}
