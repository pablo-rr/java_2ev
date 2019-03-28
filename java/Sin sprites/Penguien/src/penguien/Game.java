package penguien;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class Game extends Frame implements Runnable{
    Thread gameThread;
    int threadSleep;
    int threadCounter;
    static float framesPerSecond;
    int resolutionX, resolutionY;
    Player player;
    ArrayList<Bullet> bulletsShot;
    ArrayList<EnemyEasy> enemiesEasy;
    ArrayList<EnemyMedium> enemiesMedium;
    ArrayList<EnemyHard> enemiesHard;
    int bulletsInChamber;
    boolean gameOver;
    int difficulty;
    int score;
    int timeBetweenEnemies;
    boolean shielded;
    Font gameOverFont;
    
    // LISTENERS
    KeyListener keyListener;
    WindowAdapter windowListener;
    MouseListener mouseListener;
    
    public static void main(String[] args){
        Game app = new Game();
    }
    
    
    public Game(){
        super("Hell");
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
                if(e.getExtendedKeyCode() == KeyEvent.VK_SPACE){
                    player.goUp();
                }
                if(e.getExtendedKeyCode() == KeyEvent.VK_ENTER){
                    if(bulletsInChamber > 0){
                        player.shoot(bulletsShot); // , e.getX(), e.getY()
                        bulletsInChamber--;
                    }
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
        setLocation(150, 150);
        setResizable(false);
        setAlwaysOnTop(true);
    }
    
    private void setupGame(){
        resolutionX = 800;
        resolutionY = 600;
        player = new Player(resolutionX, resolutionY);
        bulletsInChamber = 0;
        bulletsShot = new ArrayList<>();
        enemiesEasy = new ArrayList<>();
        enemiesMedium = new ArrayList<>();
        enemiesHard = new ArrayList<>();
        threadSleep = 16;
        gameThread = new Thread(this);
        gameThread.start();
        gameOver = false;
        difficulty = 0;
        score = 0;
        timeBetweenEnemies = 300;
        shielded = false;
        gameOverFont = new Font("gameOverFont", 0, 50);
    }

    public void paint(Graphics g){
        if(!gameOver){
            player.draw(g);
            g.drawString("Score: " + score, 100, 100);
            for(int i = 0; i < bulletsShot.size(); i++){
                bulletsShot.get(i).draw(g);
            }
            for(int i = 0; i < enemiesEasy.size(); i++){
                enemiesEasy.get(i).draw(g);
            }
            for(int i = 0; i < enemiesMedium.size(); i++){
                enemiesMedium.get(i).draw(g);
            }
            for(int i = 0; i < enemiesHard.size(); i++){
                enemiesHard.get(i).draw(g);
            }
        }else{
            g.setColor(Color.WHITE);
            g.setFont(gameOverFont);
            g.drawString("GAME OVER", 100, 300);
            g.drawString("FINAL SCORE: " + score, 100, 425);
        }
    }
    
    public void checkPlayerOutOfScreen(){
        if(player.getPosY() < 0 || player.getPosY() > resolutionY - player.getH()){
            gameOver = true;
        }
    }
    
    public boolean countMiliSeconds(int ms){
        if(threadCounter >= ms){
            threadCounter = 0;
            return true;
        }
        threadCounter += threadSleep;
        return false;
    }
    
    public void moveBullets(){
        for(int i = 0; i < bulletsShot.size(); i++){
            bulletsShot.get(i).move();
            if(bulletsShot.get(i).getPosX() <= -100 && bulletsInChamber > 0){
                bulletsInChamber--;
            }
        }
    }
    
    public void intersections(){
        for(int i = 0; i < bulletsShot.size(); i++){
            for(int j = 0; j < enemiesEasy.size(); j++){
                    if(bulletsShot.get(i).intersects(enemiesEasy.get(j)) && bulletsShot.get(i).isVisible()){
                        enemiesEasy.remove(j);
                        bulletsShot.get(i).setVisible(false);
                        score += 10;
                    }
            }
            for(int j = 0; j < enemiesMedium.size(); j++){
                    if(bulletsShot.get(i).intersects(enemiesMedium.get(j)) && bulletsShot.get(i).isVisible()){
                        enemiesMedium.remove(j);
                        bulletsShot.get(i).setVisible(false);
                        score += 10;
                    }
            }
            for(int j = 0; j < enemiesHard.size(); j++){
                    if(bulletsShot.get(i).intersects(enemiesHard.get(j)) && bulletsShot.get(i).isVisible()){
                        enemiesHard.remove(j);
                        bulletsShot.get(i).setVisible(false);
                        score += 10;
                    }
            }
        }
    }
    
    public void moveEnemies(){
            for(int i = 0; i < enemiesEasy.size(); i++){
                enemiesEasy.get(i).move();
                if(player.intersects(enemiesEasy.get(i))){
                    gameOver = true;
                }
            }
            for(int i = 0; i < enemiesMedium.size(); i++){
                enemiesMedium.get(i).move();
                if(player.intersects(enemiesMedium.get(i))){
                    gameOver = true;
                }
            }
            for(int i = 0; i < enemiesHard.size(); i++){
                enemiesHard.get(i).move();
                if(player.intersects(enemiesHard.get(i))){
                    gameOver = true;
                }
            }
    }
    
    public void checkScore(){
        if(score == 100 && difficulty < 1){
            difficulty++;
            timeBetweenEnemies /= 3;
        }else if(score == 200  && difficulty < 2){
            difficulty++;
            timeBetweenEnemies /= 2;
        }
    }
    
    public void addEnemies(){
        if(countMiliSeconds(timeBetweenEnemies)){
            if(difficulty == 0){
                enemiesEasy.add(new EnemyEasy(resolutionX, resolutionY));
            }else if (difficulty == 1){
                enemiesMedium.add(new EnemyMedium(resolutionX, resolutionY));
            }else if (difficulty >= 2){
                enemiesHard.add(new EnemyHard(resolutionX, resolutionY));
            }
            bulletsInChamber++;
        }
    }
    
    public void runGame(){
        checkScore();
        addEnemies();
        moveBullets();
        moveEnemies();
        intersections();
        checkPlayerOutOfScreen();
    }

    public void run(){
        do{
            try{
                Thread.sleep(16);
            }catch(InterruptedException exc){
                // do nothing with catched exception
            }
            player.physics();
            runGame();
            repaint();
        }while(!gameOver);
    }
    
}
