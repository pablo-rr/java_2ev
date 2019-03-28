package infiniterunner;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.*;
import java.awt.event.ActionEvent;
        
public class InfiniteRunner extends Frame implements Runnable{
    private Thread game;
    private Player player;
    private static Block block1;
    private int screenSizeX, screenSizeY;
    private int playerSizeX, playerSizeY;
    private static int pos1, pos2, pos3;
    private KeyListener keyListener;
    private static boolean gameOver;
    private MenuBar menuBar;
    private Menu gameMenu;
    private MenuItem newGame;
    private MenuItem exitGame;
    private static int score;
    
    public static void main(String[] args) {
        InfiniteRunner app = new InfiniteRunner();
    }
    
    public InfiniteRunner(){
        super("Infinite Runner");
        setup();
        pack();
        resize(screenSizeX, screenSizeY);
        show();
    }
    
    public void paint(Graphics g){
        if(!gameOver){
            player.drawPlayer(g);
            block1.drawBlock(g);
            g.drawString("Score: " + score, 10, 275);
            g.drawString("Level: " + block1.getDifficulty(), 10, 290);
        }else{
            g.drawString("GAME OVER", 115, 145);
            g.drawString("Your final score is: " + score, 100, 160);
            g.drawString("You died at level: " + block1.getDifficulty(), 105, 175);
        }
    }
    
    public void setup(){
        setupMenu();
        setupResizable();
        setupListeners();
        setupThread();
        setupVars();
        setupClasses();
    }
    
    public void setupMenu(){
        menuBar = new MenuBar();
        gameMenu = menuBar.add(new Menu("Game"));
        newGame = gameMenu.add(new MenuItem("New"));
        exitGame = gameMenu.add(new MenuItem("Exit"));
        gameMenu.add(exitGame);
        
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restart();
            }
        });
        
        exitGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        this.setMenuBar(menuBar);
    }
    
    public void setupResizable(){
        this.setResizable(false);
    }
    
    public void setupListeners(){
        keyListener = new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_A){
                    player.moveTo("left");
                }else if(e.getKeyCode() == KeyEvent.VK_D){
                    player.moveTo("right");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        this.addKeyListener(keyListener);
        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent wE){
                System.exit(0);
            }
        });
    }
    
    public void setupThread(){
        game = new Thread(this);
        game.start();
    }
    
    public void setupVars(){
        screenSizeX = screenSizeY = 300;
        playerSizeX = playerSizeY = 50;
        pos1 = 50;
        pos2 = screenSizeX/2 - playerSizeX/2;
        pos3 = 200;
        gameOver = false;
        score = 0;
    }
    
    public void setupClasses(){
        player = new Player(screenSizeX/2 - playerSizeX/2, playerSizeX, playerSizeY, Color.RED);
        block1 = new Block(50, playerSizeX, playerSizeY, Color.BLACK);
    }
    
    public void restart(){
        gameOver = false;
        block1.resetBlock();
        score = 0;
        player.resetPlayer();
    }
    
    public void run(){
        do{
            if(!gameOver){
                try{
                    Thread.sleep(40);
                }catch(InterruptedException exc){
                    // do nothing
                }
                block1.goDown(player);
            }else{
                block1.setVisible(false);
                player.setVisible(false);     
            }
            repaint();
        }while(true);
    }
    
    public static int getPos1(){
        return pos1;
    }
    
    public static int getPos2(){
        return pos2;
    }
    
    public static int getPos3(){
        return pos3;
    }

    public static boolean isGameOver() {
        return gameOver;
    }

    public static void setGameOver(boolean gO) {
        gameOver = gO;
    }
    
    public static void increaseScore(){
        score += 10 * block1.getDifficulty();
    }
}
