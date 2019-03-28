/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penguien;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Player extends Rectangle{
    Color color;
    double acceleration = 0.3;
    double gravity;
    int speed;
    
    public Player(int resX, int resY){
        super(60, resY/2 - 30, 60, 60);
        color = Color.WHITE;
        gravity = 0.2;
        speed = 4;
       
    }
    
    public void draw(Graphics g){
        g.setColor(color);
        g.fillOval(x, y, width, height);
    }
    
    public void moveUp(){
        y -= speed;
    }
    
    public void moveDown(){
        y += speed;
    }
    
    public void moveLeft(){
        x -= speed;
    }
    
    public void moveRight(){
        x += speed;
    }

    public void shoot(ArrayList<Bullet> b){ // , int posMouseX, int posMouseY
        b.add(new Bullet(x, y, width, height)); // , posMouseX, posMouseY
    }
}
