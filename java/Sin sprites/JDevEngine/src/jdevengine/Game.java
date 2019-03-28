package jdevengine;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Game extends Frame implements Runnable{
    Thread gameThread;
    static float framesPerSecond;
    int resolutionX, resolutionY;
    
    // LISTENERS
    KeyListener keyListener;
    WindowAdapter windowListener;
    MouseListener mouseListener;
    
    public static void main(String[] args){
        Game app = new Game();
        framesPerSecond = setFramesPerSecond(60);
    }
    
    public Game(){
        super("Game Title");
        setup();
        pack();
        resize(resolutionX, resolutionY);
        show();
    }
    
    public void setup(){ // Starts the game and all its elements
        setupFrame();
        setupGame();
        setupListeners();
    }
    
    public void setupListeners(){
        keyListener = new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyPressed(KeyEvent e) {
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        
        windowListener = new WindowAdapter(){

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
        };
        
        mouseListener = new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        };
        
        this.addKeyListener(keyListener);
        this.addWindowListener(windowListener);
        this.addMouseListener(mouseListener);
    }
    
    private void setupFrame(){
        setBackground(Color.BLACK);
        setLocation(200, 200);
        setResizable(false);
        setAlwaysOnTop(true);
    }
    
    private void setupGame(){
        resolutionX = 800;
        resolutionY = 600;
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    public static float setFramesPerSecond(float fps){
        return (float)(1000/fps);
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

// 1000/16 = 60
// 1000/60 = 16
