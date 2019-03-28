/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bunker;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class ShootAligner extends Rectangle{
    Color color;
    
    public ShootAligner(int rY) {
        super(0, 0, 1, rY);
        color = Color.RED;
    }
    
    public void draw(Graphics g){
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
    
    public void align(int mX){
        x = mX;
    }
    
    public int getPosX(){
        return x;
    }
        
}
