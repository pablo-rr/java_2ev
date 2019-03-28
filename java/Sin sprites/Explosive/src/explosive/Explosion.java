package explosive;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Explosion extends Rectangle implements Runnable{
    Color color;
    boolean active;
    Thread gameThread;
    int threadCounter;
    int threadStopTime;
    int alpha;
    
    public Explosion(int posX, int posY, int wh) {
        super(posX, posY, wh, wh);
        alpha = 0;
        active = true;
        color = new Color(255, 255, 0, alpha);
        threadCounter = 0;
        gameThread = new Thread(this);
        gameThread.start();
        threadStopTime = 20;
    }
    
    public void draw(Graphics g){
        g.setColor(color);
        g.fillOval(x, y, width, height);
    }
    
    public void update(){
        if(threadCounter < 1000){
            this.grow(1, 1);
        }else if(threadCounter >= 1000 && threadCounter <= 2000){
            this.grow(-1, -1);
            alpha += 25;
        }else if(threadCounter > 2000){
            gameThread.stop();
        }
        threadCounter += threadStopTime;
    }
    
    @Override
    public void run() {
        do{
            try{
                Thread.sleep(threadStopTime);
            }catch(InterruptedException exc){
                // do nothing with catched exception
            }
        }while(active);
    }
    
}
