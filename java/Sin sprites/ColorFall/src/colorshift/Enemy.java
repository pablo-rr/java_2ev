/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colorshift;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

/**
 *
 * @author 1h
 */
public class Enemy extends Rectangle{
    Color color;
    Random random;
    int colorNum;
    int speed;
    int resY;
    boolean active;
    final int RED = 1;
    final int YELLOW = 2;
    final int BLUE = 3;
    final int MAGENTA = 4;
    final int GREEN = 5;
    
    public Enemy(int resX, int resY){
        super(0, 0, resX, 30);
        random = new Random();
        colorNum = random.nextInt(5)+1;
        speed = 1;
        this.resY = resY;
        active = true;
        randomColor();
    }
    
    public void randomColor(){
        switch(colorNum){
            case RED:
                color = Color.RED;
                break;
            case YELLOW:
                color = Color.YELLOW;
                break;
            case BLUE:
                color = Color.BLUE;
                break;
            case MAGENTA:
                color = Color.MAGENTA;
                break;
            case GREEN:
                color = Color.GREEN;
                break;
        }
    }
    
    public void draw(Graphics g){
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
    
    public void goDown(){
        y += speed;
    }
    
    public int getPosY(){
        return y;
    }
    
    public void setColor(Color newColor){
        color = newColor;
    }
    
        
    public Color getColor(){
        return color;
    }
    
    public void setActive(boolean newActive){
        active = newActive;
    }
    
    public boolean isActive(){
        return active;
    }
    
}
