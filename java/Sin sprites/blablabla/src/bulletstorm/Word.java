package bulletstorm;

import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Word extends Rectangle{
    Color colorBack;
    Color colorWord;
    String word;
    int speed;
    Random random;
    boolean visible;
    //Color colors[];

    public Word(int resX, int resY, String w){
        super(resX, 0, 80, 25);
        colorBack = Color.WHITE;
        colorWord = Color.BLACK;
        random = new Random();
        y = random.nextInt(resY-80)+20;
        word = w;
        speed = 2;
        visible = true;
        //colors = new Color[] {Color.RED, Color.CYAN, Color.PINK, Color.YELLOW};
    }
    
    public String getText(){
        return word;
    }
    
    public void setColor(Color newColor){
        colorBack = newColor;
    }
    
    public void draw(Graphics g){
        if(visible){
            g.setColor(colorBack);
            g.fillRect(x, y, width, height);
            g.setColor(colorWord);
            g.drawString(word, x+5, y+18);
        }
    }
    
    public Color getColor(){
        return colorBack;
    }
    
    public void moveLeft(){
        x -= speed;
    }
    
    public int getPosX(){
        return x;
    }
    
    public int getPosY(){
        return y;
    }
    
    public int getH(){
        return height;       
    }
    
    public int getW(){
        return width;
    }
    
    public boolean mouseDown(Event e, int x, int y){
        visible = false;
        System.out.println("hi");
        return true;
    }
    
}
