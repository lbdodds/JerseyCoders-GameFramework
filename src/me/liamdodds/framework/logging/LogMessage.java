package me.liamdodds.framework.logging;

import java.awt.*;

/**
 * Created by Liam Cristoforo-Dodds on 18/04/2015.
 */
public class LogMessage {
    private static final Font DEFAULT_FONT = new Font("TimesRoman", Font.PLAIN, 16);

    private String cls;
    private String message;

    private Font font;
    private Color color;
    private int lineHeight;

    public LogMessage(String cls, String message) {
        this.cls = cls;
        this.message = message;
        initialize();
    }

    private void initialize() {
        setFont(DEFAULT_FONT);
        setColor(Color.WHITE);
    }

    public String getLog() {
        return "[" + cls + "] " + message;
    }

    public Font getFont() { return font; }
    public int getLineHeight() { return lineHeight; }

    public void setFont(Font font) {
        this.font = font;
        lineHeight = (int)(getFont().getSize() * 1.5);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
