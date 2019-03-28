package defcon5;

import java.awt.Event;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
import screens.Screen;

public class Game extends Frame implements Runnable{
    String gameName;
    private static int resolutionX;
    private static int resolutionY;
    Thread gameThread;
    Screen menuScreen;
    
    
    public static void main(String args[]){
        Game app = new Game();
    }
    
    public Game(){
        super("DEFCON5");
        setup();
        pack();
        resize(resolutionX, resolutionY);
        show();
    }
    
    public void setup(){
        setupWindow();
        setupThread();
    }
    
    public void setupWindow(){
        setResolutionX(resolutionY = 300);
    }
    
    public void setupThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    public void setupMenus(){
        
    }
    
    /*
    @Override
    public void paint(Graphics g){
        
    }
    */
    
    @Override
    public void run() {
        do{
            try{
                Thread.sleep(20);
            }catch(InterruptedException exc){
                // do nothing with the exception
            }
            repaint();
        }while(true);
    }
    
    @Override
    public boolean handleEvent(Event e){
        if(e.id == Event.WINDOW_DESTROY){
            System.exit(0);
            return true;
        }
        return false;
    }

    public static int getResolutionX() {
        return resolutionX;
    }

    public void setResolutionX(int resolutionX) {
        this.resolutionX = resolutionX;
    }

    public static int getResolutionY() {
        return resolutionY;
    }

    public void setResolutionY(int resolutionY) {
        this.resolutionY = resolutionY;
    }
}
