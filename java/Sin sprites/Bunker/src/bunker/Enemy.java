/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bunker;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Enemy extends Rectangle{
    Random random;
    Color color;
    int speed;
    
    public Enemy(int rX){
        super(0, 0, 30, 30);
        random = new Random();
        x = random.nextInt(rX - width);
        color = Color.BLUE;
        speed = 1;
    }
    
    public void draw(Graphics g){
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
    
    public void goDown(){
        y += speed;
    }
    
    public void addSpeed(){
        speed++;
    }
}
