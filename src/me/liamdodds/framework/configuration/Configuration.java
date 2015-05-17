package me.liamdodds.framework.configuration;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A way to store and use configurations. Can be subscribed to by Configurables.
 * Created by Liam Cristoforo-Dodds on 17/05/15.
 */
public class Configuration {
    private static HashMap<String, ConfigObject> configObjects;
    private static ArrayList<Configurable> configurables;
    static {
        configObjects = new HashMap<>();
        configurables = new ArrayList<>();
    }

    /**
     * Publishes out changes to configurable objects
     * @param configObject
     */
    public static void publish(ConfigObject configObject) {
        configurables.forEach((configurable -> configurable.onConfigurationChange(configObject)));
    }

    /**
     * Subscribes a configurable to all published events
     * @param configurable
     */
    public static void subscribe(Configurable configurable) {
        configurables.add(configurable);
    }

    /**
     * Adds a key / value to the configuration
     * @param key
     * @param object
     */
    public static void add(String key, Object object) {
        ConfigObject configObject = new ConfigObject(key, object);
        configObjects.put(key, configObject);
        publish(configObject);
    }

    /**
     * Returns a configuration object
     * @param key
     * @return
     */
    public static ConfigObject get(String key) {
        return configObjects.get(key);
    }

    /**
     * Returns the value of a configuration object (or null)
     * @param key
     * @return
     */
    public static Object getValue(String key) {
        return getValue(key, null);
    }

    /**
     * Return the value of a configuration object cast to T (or null)
     * @param key
     * @param type
     * @param <T>
     * @return
     */
    public static <T> T cast(String key, Class<T> type) {
        return cast(key, type, null);
    }

    /**
     * Returns the value of a configuration object (or the value of def)
     * @param key
     * @param def
     * @return
     */
    public static Object getValue(String key, Object def) {
        if(configObjects.containsKey(key)) {
            return configObjects.get(key).getValue();
        }

        return def;
    }

    /**
     * Retursn the value of a configuration object cast to T (or the value of def)
     * @param key
     * @param type
     * @param def
     * @param <T>
     * @return
     */
    public static <T> T cast(String key, Class<T> type, T def) {
        if(configObjects.containsKey(key)) {
            return configObjects.get(key).cast(type, def);
        }
        return def;
    }
}
