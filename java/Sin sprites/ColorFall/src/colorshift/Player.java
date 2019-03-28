/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colorshift;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author 1h
 */
public class Player extends Rectangle{
    Color color;
    
    public Player(int resX, int resY){
        super(0, 0, 50, 50);
        x = resX/2 - width/2;
        y = resY - 100;
        color = Color.RED;
    }
    
    public void draw(Graphics g){
        g.setColor(color);
        g.fillOval(x, y, width, height);
    }
    
    public void setColor(Color newColor){
        color = newColor;
    }
    
    public Color getColor(){
        return color;
    }
    
}
