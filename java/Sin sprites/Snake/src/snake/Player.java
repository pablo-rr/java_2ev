package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends Rectangle{
    Color color;
    int speed;
    int direction;
    final int DIR_UP = 0, DIR_DOWN = 1, DIR_LEFT = 2, DIR_RIGHT = 3;
    private int currentPosX;
    private int currentPosY;
    private int lastPosX;
    private int lastPosY;
    
    public Player(){
        super(250, 250, Snake.getGridDimension(), Snake.getGridDimension());
        color = Color.WHITE;
        speed = Snake.getGridDimension();
        direction = DIR_UP;
    }
    
    public void draw(Graphics g){
        g.setColor(color);
        g.drawRect(x, y, width, height);
    }
    
    public void updatePositionWhenOutOfScreen(){
        lastPosX = x;
        lastPosY = y;
        if(x >= Snake.getResolutionX()){
            //lastPosX = x;
            x = 0 - Snake.getGridDimension();
            //currentPosX = x;
        }else if(x < 0){
            //lastPosX = x;
            x = Snake.getResolutionX();
            //currentPosX = x;
        }else if(y >= Snake.getResolutionY()){
            //lastPosY = y;
            y = 0 - Snake.getGridDimension();
            //currentPosY = y;
        }else if(y < 0){
            //lastPosY = y;
            y = Snake.getResolutionY();
            //currentPosY = y;
        }
        currentPosX = x;
        currentPosY = y;
    }
    
    public void updatePosition(){
        lastPosX = x;
        lastPosY = y;
        if(direction == DIR_UP){
            //lastPosY = y;
            y -= speed;
            //currentPosY = y;
        }else if(direction == DIR_DOWN){
            //lastPosY = y;
            y += speed;
            //currentPosY = y;
        }else if(direction == DIR_LEFT){
            //lastPosX = x;
            x -= speed;
            //currentPosX = x;
        }else if(direction == DIR_RIGHT){
            //lastPosX = x;
            x += speed;
            //currentPosX = x;
        }
        currentPosX = x;
        currentPosY = y;
        
        /*
        System.out.println("LPX: " + lastPosX);
        System.out.println("CPX: " + currentPosX);
        System.out.println("LPY: " + lastPosY);
        System.out.println("CPY: " + currentPosY);
        System.out.println("-----------------------------------------");
        */
    }
    
    public void changeDirection(String dir){
        if("up".equals(dir)){
            direction = DIR_UP;
        }else if("down".equals(dir)){
            direction = DIR_DOWN;
        }else if("left".equals(dir)){
            direction = DIR_LEFT;
        }else if("right".equals(dir)){
            direction = DIR_RIGHT;
        }
    }
    
    public int getPlayerX(){
        return x;
    }
    
    public int getPlayerY(){
        return y;
    }

    public int getCurrentPosX() {
        return currentPosX;
    }

    public int getCurrentPosY() {
        return currentPosY;
    }

    public int getLastPosX() {
        return lastPosX;
    }

    public int getLastPosY() {
        return lastPosY;
    }
    
}
