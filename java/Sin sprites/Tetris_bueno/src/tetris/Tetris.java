package tetris;

import java.awt.Frame;
import java.awt.Graphics;
import java.util.Random;

public class Tetris extends Frame implements Runnable{
    int resolutionX, resolutionY;
    Thread game;
    Figure figures[];
    Figure figure;
    Random randomGenerator;
    
    public static void main(String args[]){
        Tetris app = new Tetris();
    }
    
    public Tetris(){
        super("T E T R I S");
        setup();
        pack();
        resize(resolutionX, resolutionY);
        show();
    }
    
    public void setup(){
        setupFrame();
        setupGame();
        setupThread();
    }

    public void setupFrame(){
        setResizable(false);
    }
    
    public void setupGame(){
        resolutionX = 400;
        resolutionY = 800;
    }
    
    public void setupThread(){
        game = new Thread(this);
        game.start();
    }
    
    public void paint(Graphics g) {
        //figure.drawFigure(g);
    }
   
    public void run(){
        do{
            try{
                Thread.sleep(1000);
            } catch (InterruptedException IE) {
            }
                figure.updateFigure();
            repaint();
            }while(true);
    }
}
