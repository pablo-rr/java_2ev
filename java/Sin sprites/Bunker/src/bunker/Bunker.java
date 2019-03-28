/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bunker;

import com.sun.glass.ui.Cursor;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class Bunker extends Frame implements Runnable{
    private static int resolutionX;
    private static int resolutionY;
    Thread gameThread;
    int threadCounter;
    int threadCounter2;
    int threadTime;
    boolean gameOver;
    int difficulty;
    int timeBetweenEnemies;
    int lives;
    Font gameOverFont;
    ShootAligner shootAligner;
    ArrayList<Enemy> enemies;
    ArrayList<Bullet> bullets;
    Bullet bullet;
    int mouseX;
    boolean canShoot;
    boolean bulletGoingUp;
    
    public static void main(String[] args) {
        Bunker app = new Bunker();
    }
    
    public Bunker(){
        super("Bunker");
        this.setup();
        this.pack();
        this.setSize(resolutionX, resolutionY);
        this.setVisible(true);
    }
    
    public void setup(){
        setupListeners();
        setupFrame();
        setupGame();
    }
    
    public void setupListeners(){
        
        this.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(canShoot){
                    bulletGoingUp = true;
                    canShoot = false;
                    System.out.println("uppo");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
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
        
        this.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
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
        
        this.addMouseMotionListener(new MouseMotionListener() {

            @Override
            public void mouseDragged(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                shootAligner.align(e.getX());
                mouseX = e.getX();
            }
        });
    }
    
    private void setupFrame(){
        setLocation(400, 50);
        setResizable(false);
        setAlwaysOnTop(true);
    }
    
    private void setupGame(){
        resolutionX = 400;
        resolutionY = 900;
        gameOver = false;
        setBackground(Color.BLACK);
        threadTime = 8;
        threadCounter = 0;
        timeBetweenEnemies = 2100;
        difficulty = 0;
        lives = 3;
        gameOverFont = new Font("gameOverFont", 0, 35);
        enemies = new ArrayList<>();
        shootAligner = new ShootAligner(resolutionY);
        bullet = new Bullet(mouseX, resolutionY);
        mouseX = 0;
        canShoot = true;
        bulletGoingUp = false;
        
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    public void paint(Graphics g){
        if(!gameOver){
            for(int i = 0; i < enemies.size(); i++){
                enemies.get(i).draw(g);
            }
            bullet.draw(g);
            shootAligner.draw(g);
        }else{
            g.setFont(gameOverFont);
            g.setColor(Color.WHITE);
            g.drawString("GAME OVER", 100, resolutionY/2);
        } 
    }

    public void addEnemy(int timeBetweenEach){
        if(threadCounter < timeBetweenEach){
            threadCounter += threadTime;
        }else{
            enemies.add(new Enemy(resolutionX));
            threadCounter = 0;
        }
    }
    
    public void increaseDifficulty(int timeBeforeUpdate){
        if(threadCounter2 < timeBeforeUpdate){
            threadCounter2 += threadTime;
            //System.out.println(threadCounter2);
        }else{
            if(difficulty < 6){
                timeBetweenEnemies -= 300;
                difficulty++;
            }
            //System.out.println("difficulty: " + difficulty);
            threadCounter2 = 0;
        }
    }
    
    public void collisions(){
        for(int j = 0; j < enemies.size(); j++){
            if(bullet.intersects(enemies.get(j))){
                System.out.println("borrrrrrrr");
                enemies.remove(j);
            }
        }
    }
    
    public void run(){
        addEnemy(0);
        do{
            repaint();
            addEnemy(1000);
            for(int i = 0; i < enemies.size(); i++){
                enemies.get(i).goDown();
            }
            if(bulletGoingUp){
                bullet.goUp();
                System.out.print("a");
                if(bullet.getPosX() > 0){
                    bullet.setPosX(resolutionY);
                    System.out.println("swosh");
                }
            }
            collisions();
            try{
                Thread.sleep(threadTime);
            }catch(InterruptedException ie){
                // do nothing with exception
            }
        }while(!gameOver);
    }
}


