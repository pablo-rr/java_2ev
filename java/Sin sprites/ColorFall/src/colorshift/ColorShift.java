package colorshift;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class ColorShift extends Frame implements Runnable{
    private static int resolutionX;
    private static int resolutionY;
    Thread gameThread;
    int threadCounter;
    int threadCounter2;
    int threadTime;
    boolean gameOver;
    Player player;
    ArrayList<Enemy> enemies;
    Enemy enemy;
    int timeBetweenEnemies;
    int difficulty;
    Font gameOverFont;
    
    public static void main(String[] args) {
        ColorShift app = new ColorShift();
    }
    
    public ColorShift(){
        super("ColorShift");
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
        
        this.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getExtendedKeyCode() == KeyEvent.VK_1){
                    player.setColor(Color.RED);
                }else if(e.getExtendedKeyCode() == KeyEvent.VK_2){
                    player.setColor(Color.YELLOW);
                }else if(e.getExtendedKeyCode() == KeyEvent.VK_3){
                    player.setColor(Color.BLUE);
                }else if(e.getExtendedKeyCode() == KeyEvent.VK_4){
                    player.setColor(Color.MAGENTA);
                }else if(e.getExtendedKeyCode() == KeyEvent.VK_5){
                    player.setColor(Color.GREEN);
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
    }
    
    private void setupFrame(){
        setLocation(200, 200);
        setResizable(false);
        setAlwaysOnTop(true);
    }
    
    private void setupGame(){
        resolutionX = 800;
        resolutionY = 600;
        gameOver = false;
        setBackground(Color.BLACK);
        player = new Player(resolutionX, resolutionY);
        enemies = new ArrayList<>();
        enemy = new Enemy(resolutionX, resolutionY);
        threadTime = 8;
        threadCounter = 0;
        timeBetweenEnemies = 2100;
        difficulty = 0;
        gameOverFont = new Font("gameOverFont", 0, 100);
        
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    public void paint(Graphics g){
        if(!gameOver){
            player.draw(g);
            //enemy.draw(g);

            for(int i = 0; i < enemies.size(); i++){
                enemies.get(i).draw(g);
            }
            g.setColor(Color.WHITE);
            g.drawString("Difficulty: " + difficulty, 20, resolutionY - 20);
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
            enemies.add(new Enemy(resolutionX, resolutionY));
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
            System.out.println("difficulty: " + difficulty);
            threadCounter2 = 0;
        }
    }

    public void intersections(){
        for(int i = 0; i < enemies.size(); i++){
            if(enemies.get(i).intersects(player) && enemies.get(i).getColor() != player.getColor() && enemies.get(i).isActive()){
                gameOver = true;
            }else if(enemies.get(i).intersects(player) && enemies.get(i).getColor() == player.getColor()){
                enemies.get(i).setActive(false);
            }
        }
    }
    
    public void run(){
        enemies.add(new Enemy(resolutionX, resolutionY));
        do{
            if(!gameOver){
                addEnemy(timeBetweenEnemies);
                for(int i = 0; i < enemies.size(); i++){
                    enemies.get(i).goDown();
                    if(enemies.get(i).getPosY() > resolutionY){
                        enemies.remove(i);
                    }
                }
                intersections();
                increaseDifficulty(10000);
                try{
                    Thread.sleep(threadTime);
                }catch(InterruptedException ie){
                    // do nothing with exception
                }
                repaint();
            }
        }while(true);
    }
}

