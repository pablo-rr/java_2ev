package screens;

import defcon5.Game;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Screen extends Rectangle{
    
    public Screen(){
       super(0, 0, Game.getResolutionX(), Game.getResolutionY());
    }
    
    public void setScreen(Graphics g, Color c, boolean v){
        if(v){
            g.setColor(c);
            g.drawRect(x, y, width, height);
        }
    }
}
