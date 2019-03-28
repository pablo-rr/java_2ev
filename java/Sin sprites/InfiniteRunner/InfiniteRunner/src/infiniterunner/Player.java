package infiniterunner;

import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player extends Block{
    private Color color;
    private int moveX;
    private int pos1, pos2, pos3;
    private static boolean visible;
    
    public Player(int x, int w, int h, Color c){
        super(x, w, h, c);
        color = c;
        y = 220;
        moveX = 20;
        pos1 = InfiniteRunner.getPos1();
        pos2 = InfiniteRunner.getPos2();
        pos3 = InfiniteRunner.getPos3();
        visible = true;
    }
    
    public void drawPlayer(Graphics g){
        if(visible){
            g.setColor(color);
            g.fillOval(x, y, width, height);
        }
    }
    
    public void moveTo(String to){
        if("left".equals(to)){
            if(x == pos3){
                x = pos2;
            }else if(x == pos2){
                x = pos1;
            }
        }else{
            if(x == pos1){
                x = pos2;
            }else if(x == pos2){
                x = pos3;
            }
        } 
    }
    
    public static boolean isVisible() {
        return visible;
    }

    public static void setVisible(boolean aVisible) {
        visible = aVisible;
    }
    
    public void resetPlayer(){
        x = pos2;
        visible = true;
    }
}
