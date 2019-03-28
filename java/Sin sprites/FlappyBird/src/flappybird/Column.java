package flappybird;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Column extends Rectangle{
    int midDistance;
    Color color;
    int speed;
    int distance;
    boolean awarded;
    
    public Column(){
        super(FlappyBird.getResolutionX(), 0, 40, 180);
        midDistance = 90;
        color = Color.GREEN;
        speed = 3;
        awarded = false;
    }
    
    public void restartColumn(){
        x = FlappyBird.getResolutionX();
    }
    
    public void paintColumn(Graphics g){
        g.setColor(color);
        g.fillRect(x, distance, width, height); // up column
        g.fillRect(x, height+distance+midDistance, width, height); // down column
    }
    
    public void updateColumn(){
        if(x < -width){
            x = FlappyBird.getResolutionX();
            generateNewDistance();
            awarded = false;
        }else if(x < (FlappyBird.getResolutionX()/2)-width && !awarded){
            awarded = true;
            FlappyBird.awardScore();
        }
    }
    
    public void generateNewDistance(){
        distance = (int)(Math.random()*-120);
    }
    
    public void moveColumns(){
        x -= speed;
    }
    
    public int getColumnX(){
        return x;
    }
    
    public int getColumnY(String gCX){
        if("up".equals(gCX)){
            return distance;
        }
        return height+distance+midDistance;
    }
    
    public int getColumnHeight(){
        return height;
    }
    
    public int getColumnWidth(){
        return width;
    }
}
