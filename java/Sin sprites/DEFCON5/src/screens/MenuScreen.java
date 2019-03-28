package screens;

import defcon5.Game;
import java.awt.Graphics;
import java.awt.Rectangle;

public class MenuScreen extends Rectangle{
    boolean visible;
    
    public MenuScreen(boolean v){
       super(0, 0, Game.getResolutionX(),Game.getResolutionY());
       visible = v;
    }
    
    public void setMenuScreen(Graphics g){
        g.drawRect(x, y, width, height);
    }
    
}
