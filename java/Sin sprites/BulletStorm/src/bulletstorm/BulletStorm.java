package bulletstorm;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.*;
import java.util.ArrayList;
        
public class BulletStorm extends Frame implements Runnable{
    Thread gameThread;
    int resolutionX, resolutionY;
    int threadStopTime;
    int threadCounter;
    int threadCounter2;
    int fallingSpeed;
    Player player;
    ArrayList<Falling> falling;
    
    static boolean gameOver;
    
    public static void main(String[] args) {
        BulletStorm app = new BulletStorm();
    }
    
    public BulletStorm(){
        super("Infinite Runner");
        setup();
        pack();
        resize(resolutionX, resolutionY);
        show();
    }
    
    public void paint(Graphics g){
        player.draw(g);
        for(int i = 0; i < falling.size(); i++){
            falling.get(i).draw(g);
        }
    }
    
    public void setup(){
        setupFrame();
        setupGame();
        setupListeners();
    }
  
    public void setupFrame(){
        resolutionX = 800;
        resolutionY = 600;
        this.setResizable(false);
        this.setLocation(200, 200);
        this.setBackground(Color.BLACK);
    }
    
    public void setupGame(){
        threadStopTime = 10;
        player = new Player();
        falling = new ArrayList<>();
        gameThread = new Thread(this);
        gameThread.start();
        gameOver = false;
        fallingSpeed = 3;
    }

    public void setupListeners(){
        this.addMouseMotionListener(new MouseMotionListener() {

            @Override
            public void mouseDragged(MouseEvent e) {
                
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                player.setPlayerX(e.getX() - player.getWidthMid());
                player.setPlayerY(e.getY() - player.getHeightMid());
            }
        });
        
        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent wE){
                System.exit(0);
            }
        });
    }
    
    public void newBullet(int timeBetween, int speed){
        if(threadCounter >= timeBetween){
            falling.add(new Falling(resolutionX, resolutionY-100, speed));
            threadCounter = 0;
        }else{
            threadCounter += threadStopTime;
        }
    }
    
    public void difficultyIncreaser(int timeBetween){
        if(threadCounter2 >= timeBetween){
            for(int i = 0; i < falling.size(); i++){
                fallingSpeed++; 
            }
            threadCounter2 = 0;
        }else{
            threadCounter2 += threadStopTime;
        }
    }
    
    public void run(){
        do{
            newBullet(50, fallingSpeed);
            difficultyIncreaser(1000);
            for(int i = 0; i < falling.size(); i++){
                falling.get(i).fall();
                if(falling.get(i).getPosY() > resolutionY){
                    falling.remove(i);
                }
                if(player.intersects(falling.get(i))){
                    gameOver = true;
                }
            }
            repaint();
            try{
                Thread.sleep(threadStopTime);
            }catch(InterruptedException exc){
                // do nothing
            }
        }while(!gameOver);
    }
}

