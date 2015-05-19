package me.liamdodds.framework.configuration;

/**
 * Created by Liam Cristoforo-Dodds on 17/05/15.
 */
public class ConfigObject {
    String key;
    Object value;

    public ConfigObject(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    public boolean isKey(String key) {
        return this.key == key;
    }

    public String getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }

    public <T> boolean is(Class <T> type) {
        return value.getClass().isAssignableFrom(type);
    }

    public <T> T cast(Class<T> type) {
        return cast(type, null);
    }

    public <T> T cast(Class<T> type, T def) {
        if(value.getClass().isAssignableFrom(type)) {
            return (T) value;
        }
        return def;
    }
}
