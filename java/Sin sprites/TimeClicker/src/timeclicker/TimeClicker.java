/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timeclicker;

import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TimeClicker extends Frame implements Runnable{
    Image img;
    Graphics blinkFix;
    Thread gameThread;
    int threadCounter1, threadCounter2;
    int timerSeconds, timerMinutes;
    int threadSleepTime;
    int resX, resY;
    int clicksToEnd;
    int clickCounter;
    boolean gameStarted, canRestart;
    Font gameFont;
    int gamesPlayed;
    
    public static void main(String[] args) {
        TimeClicker app = new TimeClicker();
    }
    
    public TimeClicker(){
        super("hi");
        this.setup();
        this.pack();
        this.setSize(resX, resY);
        this.setVisible(true);
    }
    
    public void setup(){
        setupFrame();
        setupGame();
        setupListeners();
    }
    
    public void setupFrame() {
        resX = resY = 500;
        this.setResizable(false);
        this.setBackground(Color.BLACK);
        this.setLocation(250, 200);
    }
    
    private void setupGame() {
        clicksToEnd = 100;
        gameThread = new Thread(this);
        gameThread.start();
        threadSleepTime = 5;
        gameFont = new Font("gameFont", Font.PLAIN, 35);
        gameStarted = false;
        canRestart = true;
    }
    
    private void setupListeners() {
        this.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getExtendedKeyCode() == KeyEvent.VK_SPACE){
                    if(!gameStarted && canRestart){
                        resetGame();
                        gameStarted = true;
                        canRestart = false;
                    }else{
                        clickCounter++;
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });
    }
    
    public void paint(Graphics g){
        g.setFont(gameFont);
        g.setColor(Color.WHITE);
        if(!gameStarted){
            if(gamesPlayed > 0){
                if(!canRestart){
                    g.drawString("Last score: " + timerMinutes + ":" + timerSeconds + "" + threadCounter1, 100, 250);
                }else{
                    g.drawString("Space to begin the game", 60, 200);
                    g.drawString("Last score: " + timerMinutes + ":" + timerSeconds + "" + threadCounter1, 100, 400);
                }
            }else{
                g.drawString("Space to begin the game", 60, 250);
            }
        }else{
            g.drawString(timerMinutes + ":" + timerSeconds + "" + threadCounter1, 205, 200);
            g.drawString(Integer.toString(clickCounter) + "/" + Integer.toString(clicksToEnd), 205, 400);
            System.out.println("paintgame");
        }
    }
    
    private void resetGame() {
        threadCounter1 = 0;
        timerSeconds = 0;
        timerMinutes = 0;
        clickCounter = 0;
        System.out.println("reset");
    }
    
    public void activateRestartIn(int t){
        if(threadCounter2 >= t){
            threadCounter2 = 0;
            canRestart = true;
        }else{
            threadCounter2 += threadSleepTime;
        }
    }
    
    public void timer(){
        threadCounter1 += threadSleepTime;
        if(threadCounter1 >= 1000){
            threadCounter1 = 0;
            timerSeconds++;
        }
        
        if(timerSeconds == 60){
            timerSeconds = 0;
            timerMinutes++;
        }
        System.out.println("timer");
    }
    
    public void run(){
        do{
            if(gameStarted){
                System.out.println("gamestarted");
                timer();
                if(clickCounter == clicksToEnd){
                    gameStarted = false;
                    gamesPlayed++;
                }
            }else if(!gameStarted && !canRestart){
                activateRestartIn(5000);
            }
            
            repaint();
            try{
                Thread.sleep(threadSleepTime);
            }catch(InterruptedException exc){
                // Do nothing with exception
            }
        }while(true);
    }

    //@Override
    public boolean handleEvent(Event e) {
        if(e.id == Event.WINDOW_DESTROY){
            System.exit(0);
            return true;
        }
        return false;
    }
    
    

}
