package gamePackage;

import java.awt.Frame;
import java.awt.Graphics;

public class Game extends Frame implements Runnable{
    Thread gameThread;
    static int framesPerSecond;
    
    public static void main(String[] args){
        Game app = new Game();
        setFramesPerSecond(60);
        System.out.println(framesPerSecond);
    }
    
    public static void setFramesPerSecond(int fps){
        framesPerSecond = 1000/fps;
    }

    public void paint(Graphics g){
        
    }
    
    @Override
    public void run(){
        repaint();
        try{
            Thread.sleep(300);
        }catch(InterruptedException exc){
            // do nothing with catched exception
        }
    }
    
}
