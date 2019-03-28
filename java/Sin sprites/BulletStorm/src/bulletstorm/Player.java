package bulletstorm;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends Rectangle{
    Color color;

    public Player(){
        super(0, 0, 60, 20);
        color = Color.WHITE;
    }
    
    public void draw(Graphics g){
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
    
    public int getHeightMid(){
        return height/2;
    }
    
    public int getWidthMid(){
        return width/2;
    }
    
    public void setPlayerX(int newPos){
        x = newPos;
    }
    
    public void setPlayerY(int newPos){
        y = newPos;
    }
}
