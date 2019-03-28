/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flappybird;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bird extends Rectangle{
    Color color;
    private double fallingAcceleration;
    double upSpeed;
    int restartPosition;
    
    public Bird(){
        super(FlappyBird.getResolutionX()/2-15, 80, 30, 30);
        color = Color.YELLOW;
        fallingAcceleration = 0;
        upSpeed = 5.3;
        restartPosition = y;
    }
    
    public void restartBird(){
        fallingAcceleration = 0;
        y = restartPosition;
    }
    
    public void paintBird(Graphics g){
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
    
    public void applyPhysics(){
        fallingAcceleration += 0.25;
        y += fallingAcceleration;
    }

    public void goUp(){
        fallingAcceleration = -upSpeed;
    }
    
    public double getFallingAcceleration() {
        return fallingAcceleration;
    }
    
    public void setFallingAcceleration(int fallingAcceleration) {
        this.fallingAcceleration = fallingAcceleration;
    }
    
    public int getBirdX(){
        return x;
    }
    
    public int getBirdY(){
        return y;
    }
    
    public int getBirdHeight(){
       return height; 
    }
    
    public int getBirdWidth(){
        return width;
    }
}
