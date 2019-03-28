package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Food extends Rectangle{
    private static Color color;
    Random random;
    int totalGridSquares;
    
    public Food(){
        super(0, 0, Snake.getGridDimension(), Snake.getGridDimension());
        color = Color.ORANGE;
        totalGridSquares = Snake.getResolutionX() / Snake.getGridDimension();
        random = new Random();
        updatePosition();
    }
    
    public void updatePosition(){
        int newPosX = random.nextInt(totalGridSquares-1);
        int newPosY = random.nextInt(totalGridSquares-1);
        x = newPosX * Snake.getGridDimension();
        y = newPosY * Snake.getGridDimension();
        //System.out.println(x);
        //System.out.println(y);
        //System.out.println("--------------------------");
    }
    
    public void draw(Graphics g){
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
    
    public static Color getColor(){
        return color;
    }
}