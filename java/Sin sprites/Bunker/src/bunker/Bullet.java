/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bunker;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet extends Rectangle{
    Color color;
    int speed;
    
    public Bullet(int mX, int rY){
        super(mX-3, rY, 6, 6);
        color = Color.WHITE;
        speed = 5;
    }
    
    public void draw(Graphics g){
        g.setColor(color);
        g.fillOval(x, y, width, height);
    }
    
    public void goUp(){
        y -= speed;
        //System.out.println("uppp");
    }
    
    public int getPosX(){
        return x;
    }
    
    public void setPosX(int newX){
        x = newX;
    }
}
