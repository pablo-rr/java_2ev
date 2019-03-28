package mazegen;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class MazeGen extends Frame implements Runnable{
    Thread gameThread;
    private static int resolutionX, resolutionY;
            
    public static void main(String[] args){
        MazeGen app = new MazeGen();
    }
    
    public MazeGen(){
        super("Maze Generator");
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
        this.addWindowListener(new WindowAdapter() {

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
        this.addKeyListener(new KeyListener() {

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
        });
    }
    
    public void setupFrame(){
        resolutionX = resolutionY = 500;
        setResizable(true);
        setBackground(Color.BLACK);
    }
    
    public void setupGame(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void paint(Graphics g){
        
    }

    public void run() {
        do{
            
            repaint();
            
            try{
                Thread.sleep(200); // 200
            }catch(InterruptedException ie){
                // do nothing with catched exception
            }
        }while(true);
    }

    public static int getResolutionY() {
        return resolutionY;
    }
    
    public static int getResolutionX() {
        return resolutionX;
    }
}
