/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simonsays;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Random;

public class SimonSays extends Frame implements Runnable{
    private static int resolutionX;
    private static int resolutionY;
    Thread gameThread;
    int threadCounter;
    int threadCounter2;
    int threadTime;
    boolean gameOver;
    int timeBetweenEnemies;
    int difficulty;
    Random random;
    boolean simonMakingSequence;
    boolean newColorAdded;
    Font gameOverFont;
    ColorRect colorSimon;
    ArrayList<Color> colorList;
    ArrayList<ColorRect> colorButtons;
    ArrayList<Color> simonSequence;
    ArrayList<Color> userSequence;
    int score;
    
    public static void main(String[] args) {
        SimonSays app = new SimonSays();
    }
    
    public SimonSays(){
        super("Simon Says");
        setup();
        pack();
        resize(resolutionX, resolutionY);
        show();
    }
    
    public void setup(){
        setupListeners();
        setupFrame();
        setupGame();
    }
    
    public void setupListeners(){
        this.addWindowListener(new WindowAdapter(){

            @Override
            public void windowOpened(WindowEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowIconified(WindowEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowActivated(WindowEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        this.addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if(!simonMakingSequence){
                    for(int i = 0; i < colorButtons.size(); i++){
                        if(colorButtons.get(i).contains(e.getX(), e.getY())){
                            userSequence.add(colorButtons.get(i).getColor());
                        }
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        });
    }
    
    private void setupFrame(){
        setLocation(200, 200);
        setResizable(false);
        setAlwaysOnTop(true);
    }
    
    private void setupGame(){
        resolutionX = 500;
        resolutionY = resolutionX + 200;
        gameOver = false;
        setBackground(Color.BLACK);
        threadTime = 50;
        threadCounter = 0;
        timeBetweenEnemies = 2100;
        difficulty = 0;
        gameOverFont = new Font("gameOverFont", 0, 50);
        colorSimon = new ColorRect(resolutionX, resolutionY, colorList);
        random = new Random();
        simonSequence = new ArrayList<>();
        newColorAdded = false;
        simonMakingSequence = true;
        score = -10;
        setupColors();
        setupColorButtons();
        
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    public void setupColors(){
        colorList = new ArrayList<>();
        colorList.add(Color.RED);
        colorList.add(Color.BLUE);
        colorList.add(Color.YELLOW);
        colorList.add(Color.GREEN);
    }
    
    public void setupColorButtons(){
        colorButtons = new ArrayList<>(); 
        for(int i = 0; i < colorList.size()/2; i++){
            for(int j = 0; j < colorList.size()/2; j++){
                colorButtons.add(new ColorRect(resolutionX/2 * i, resolutionX/2 * j + resolutionY-resolutionX, resolutionX, resolutionY));
            }
        }
    }
    
    public void paint(Graphics g){
        if(!gameOver){
            for(int i = 0; i < colorList.size(); i++){
                colorButtons.get(i).draw(g);
                colorButtons.get(i).setColor(colorList.get(i));
            }
            colorSimon.draw(g);
            g.setColor(Color.WHITE);
            g.drawString("score: " + score, 350, 105);
        }else{
            g.setFont(gameOverFont);
            g.setColor(Color.WHITE);
            g.drawString("GAME OVER", 100, resolutionY/2);
            g.drawString("FINAL SCORE: " + score, 70, resolutionY/2 + 50);
        } 
    }

    public void showNewSquence(){
        for(int i = 0; i < simonSequence.size(); i++){
            repaint();
            colorSimon.setColor(simonSequence.get(i));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                // do nothing with exception
            }
            colorSimon.setColor(Color.BLACK);
            repaint();
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                // do nothing with exception
            }
        }
    }
    
    public void setNewColorInSimonSequence(){
        simonSequence.add(randomSimonColor());
    }
    
    public Color randomSimonColor(){
        int newColor = random.nextInt(4);
        //colorSimon.setColor(colorList.get(newColor));
        return colorList.get(newColor);
    }
    
    public void checkUserSequence(){
        for(int i = 0; i < userSequence.size(); i++){
            if(userSequence.get(i) != simonSequence.get(i)){
                gameOver = true;
            }else if(userSequence.size() == simonSequence.size() && userSequence.get(i) == simonSequence.get(i)){
                simonMakingSequence = true;
            }
        }   
    }
    
    public void run(){
       
        do{
            
            if(simonMakingSequence){
                score += 10;
                if(!newColorAdded){
                    setNewColorInSimonSequence();
                }
                showNewSquence();
                colorSimon.setColor(Color.BLACK);
                simonMakingSequence = false;
                //threadTime = 50;
                userSequence = new ArrayList<>();
                
            }else{
                checkUserSequence();
            }
            
            //randomSimonColor();
            
            try{
                Thread.sleep(threadTime /*threadTime*/);
            }catch(InterruptedException ie){
                // do nothing with exception
            }
        }while(!gameOver);
        repaint();
    }
}


