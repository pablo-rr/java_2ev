/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colorfall;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

/**
 *
 * @author 1h
 */
public class ColorBlock extends Rectangle{
    int color;
    int lastColor;
    Color colors[];
    Random random;
    boolean visible;
    
    public ColorBlock(int posX, int posY, int gridSize, Color[] cs){
        super(posX, posY, gridSize, gridSize);
        random = new Random();
        visible = true;
        colors = cs;
        //do{
            color = random.nextInt(colors.length);
        //}while(color == lastColor);
        //lastColor = color;
    }
    
    public void setVisible(boolean newVisible){
        visible = newVisible;
    }
    
    public boolean isVisible(){
        return visible;
    }
    
    public void draw(Graphics g){
        if(visible){
            g.setColor(colors[color]);
            g.fillRect(x, y, width, height);
        }
    }
    
    public Color getColor(){
        return colors[color];
    }
}
