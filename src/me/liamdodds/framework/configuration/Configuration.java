package me.liamdodds.framework.configuration;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Liam Cristoforo-Dodds on 17/05/15.
 */
public class Configuration {
    private static HashMap<String, ConfigObject> configObjects;
    private static ArrayList<Configurable> configurables;
    static {
        configObjects = new HashMap<>();
        configurables = new ArrayList<>();
    }

    public static void notifyConfigurables(ConfigObject configObject) {
        configurables.forEach((configurable -> configurable.onConfigurationChange(configObject)));
    }

    public static void registerConfigurable(Configurable configurable) {
        configurables.add(configurable);
    }

    public static void add(String key, Object object) {
        ConfigObject configObject = new ConfigObject(key, object);
        configObjects.put(key, configObject);
        notifyConfigurables(configObject);
    }

    public static ConfigObject get(String key) {
        return configObjects.get(key);
    }

    public static Object getValue(String key) {
        return getValue(key, null);
    }

    public static <T> T cast(String key, Class<T> type) {
        return cast(key, type, null);
    }

    public static Object getValue(String key, Object def) {
        if(configObjects.containsKey(key)) {
            return configObjects.get(key).getValue();
        }

        return def;
    }

    public static <T> T cast(String key, Class<T> type, T def) {
        if(configObjects.containsKey(key)) {
            return configObjects.get(key).cast(type);
        }
        return def;
    }
}
