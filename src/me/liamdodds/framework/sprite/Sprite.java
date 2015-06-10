package me.liamdodds.framework.sprite;

/**
 * Created by josephrikmaguire
 */
public class Sprite {
    private int x;
    private int y;
    private int width;
    private int height;

    private String name;

    public Sprite(String name, int x, int y, int width, int height){
        this.name = name;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

    }
    
    public String getName(){
        return name;
    }
    public int getHeight(){
        return height;
    }
    public int getWidth(){
        return width;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

}

