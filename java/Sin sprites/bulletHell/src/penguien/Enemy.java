/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penguien;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;
import java.awt.Color;

public class Enemy extends Rectangle{
    Color color;
    Random random;
    int speed;
    
    public Enemy(int resX, int resY){
        super(resX-12, 0, 100, 100);
        random = new Random();
        color = Color.RED;
    }
    
    public void draw(Graphics g){
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
    
    public void move(){
        x -= speed;
    }
    
    public int getPosX(){
        return x;
    }
}