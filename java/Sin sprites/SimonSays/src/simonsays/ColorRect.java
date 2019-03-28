/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simonsays;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

public class ColorRect extends Rectangle{
    Color color;
    Random random;
    
    public ColorRect(int posX, int posY, int resX, int resY) {
        super(posX, posY, resX/2, resX/2);
    }
    
    public ColorRect(int resX, int resY, ArrayList<Color> colorList) {
        super(resX/2 - 25, 75, 50, 50);
        color = Color.BLACK;
    }
    
    public void draw(Graphics g){
        g.setColor(color);
        g.fillRect(x, y, width, height);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, width, height);
    }
    
    public void setColor(Color newColor){
        color = newColor;
    }
    
    public Color getColor(){
        return color;
    }
}
