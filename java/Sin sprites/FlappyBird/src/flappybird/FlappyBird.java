package flappybird;

import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FlappyBird extends Frame implements Runnable{
    private static int resolutionX;
    private static int resolutionY;
    Thread gameThread;
    Bird player;
    Column column;
    Column columnDown;
    MouseListener mouseListener;
    WindowAdapter windowListener;
    KeyListener keyListener;
    boolean gameOver;
    boolean started;
    private static int score;
    int finalScore;
    Image icon;
    
    public static void main(String[] args) {
        FlappyBird app = new FlappyBird();
    }
    
    public FlappyBird(){
        super("Flappy Bird");
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
    
    public void restart(){
        player.restartBird();
        column.restartColumn();
        score = 0;
        finalScore = 0;
        gameOver = false;
        repaint();
        System.out.println("restarting");
    }
    
    public void setupListeners(){
        keyListener = new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getExtendedKeyCode() == KeyEvent.VK_SPACE){
                    player.setFallingAcceleration(0);
                    player.goUp();
                }else if(e.getExtendedKeyCode() == KeyEvent.VK_R && gameOver){
                    restart();
                }
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
                player.setFallingAcceleration(0);
                player.goUp();
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
        setLocation(200, 200);
        setResizable(false);
        setAlwaysOnTop(true);
    }
    
    private void setupGame(){
        started = false;
        resolutionX = resolutionY = 300;
        gameThread = new Thread(this);
        gameThread.start();
        player = new Bird();
        column = new Column();
        column.generateNewDistance();
        gameOver = false;
        score = 0;
        setBackground(Color.BLACK);
    }
    
    public void paint(Graphics g){
        if(!gameOver){
            player.paintBird(g);
            column.paintColumn(g);
            g.setColor(Color.WHITE);
            g.drawString("SCORE: " + score, 125, 50);
        }else{
            g.setColor(Color.WHITE);
            g.drawString("GAME OVER", 115, 140);
            g.drawString("YOUR SCORE: " + finalScore, 105, 155);
            
            g.drawString("PRESS 'R' TO RESTART", 85, 180);
        }
    }
    
    public boolean checkCollisions(){
        if(((checkCollisionOnUpColumnY() || checkCollisionOnDownColumnY()) && checkCollisionOnColumnX()) || checkResolutionCollision()){
            return true;
        }
        return false;
    }
    
    public boolean checkResolutionCollision(){
        if(player.getBirdY()-player.getBirdHeight() < 0 || player.getBirdY() > resolutionY-player.getBirdHeight()){
            return true;
        }
        return false;
    }
    
    public boolean checkCollisionOnColumnX(){
        if(player.getBirdX() + player.getBirdWidth() > column.getColumnX() && player.getBirdX() < column.getColumnX() + column.getColumnWidth()){
            return true;
        }
        return false;
    }
    
    public boolean checkCollisionOnUpColumnY(){
        if(player.getBirdY() < column.getColumnY("up") + column.getColumnHeight()){
            return true;
        }
        return false;
    }
    
    public boolean checkCollisionOnDownColumnY(){
        if(player.getBirdY() + player.getBirdHeight() > column.getColumnY("down")){
            return true;
        }
        return false;
    }
    
    public boolean checkCollisionOnColumnY(){
        if(checkCollisionOnDownColumnY() && checkCollisionOnUpColumnY()){
            return true;
        }
        return false;
    }
    
    public void run(){
        
        do{
            if(!gameOver){
                try{
                    Thread.sleep(20);
                }catch(InterruptedException ie){
                    // do nothing with exception
                }
                column.moveColumns();
                column.updateColumn();
                player.applyPhysics();
                if(checkCollisions()){
                    gameOver = true;
                    finalScore = score;
                }
            }
            repaint();
        }while(true);
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
    
    public boolean handleEvent(Event e){
        if(e.id == Event.WINDOW_DESTROY){
            System.exit(0);
            return true;
        }
        return false;
    }
    
    public static void awardScore() {
        score++;
    }
}
