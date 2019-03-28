package penguien;

import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Graphics;

public class Bullet extends Rectangle{
    Color color;
    int speedY;
    int speedX;
    boolean visible;
    
    public Bullet(int posPlayerX, int posPlayerY, int playerWidth, int playerHeight){ // , int posMouseX, int posMouseY
        super(posPlayerX+playerWidth, posPlayerY+playerHeight/2, 20, 2);
        color = Color.WHITE;
        //int startingPoint = posPlayerY+playerHeight/2;
        //int endingPoint = posMouseY;
        speedX = 5;
        visible = true;
        //speedY = (endingPoint-startingPoint)/5;
    }
     
    public void draw(Graphics g){
        if(visible){
            g.setColor(color);
            g.fillRect(x, y, width, height);
        }
    }
    
    public boolean isVisible(){
        return visible;
    }
    
    public void setVisible(boolean nV){
        visible = nV;
    }
    
    public void move(){
        x += speedX;
        y += speedY;
    }
    
    public int getPosX(){
        return x;
    }
}
