package bulletstorm;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Falling extends Rectangle{
    Random random;
    Color color;
    int xSpeed;
    int xModifier;
    int ySpeed;
    int resX;
    int speed;
    
    public Falling(int resX, int resY, int sp){
        super(60, 60, 30, 30);
        speed = sp;
        random = new Random();
        color = Color.RED;
        x = random.nextInt(resX);
        xModifier = random.nextInt(2) + 1;
        xSpeed = random.nextInt(3) + 1;
        ySpeed = speed;
        this.resX = resX;
    }
    
    public void draw(Graphics g){
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
    
    public void fall(){
        if(xModifier == 1){
            x += xSpeed;
        }else if(xModifier == 2){
            x -= xSpeed;
        }
        
        y += speed;
        //System.out.println("ySpeed: " + ySpeed);
        System.out.println("speed: " + speed);
    }
    
    public int getPosY(){
        return y;
    }
}
