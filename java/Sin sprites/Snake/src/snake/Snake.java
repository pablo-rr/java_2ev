package snake;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class Snake extends Frame implements Runnable{
    Thread gameThread;
    private static int resolutionX, resolutionY;
    private static int gridDimension;
    private static int lastPlayerPosX, lastPlayerPosY, currentPlayerPosX, currentPlayerPosY;
    Player player;
    static ArrayList<PlayerBody> playerBody;
    Food food;
            
    public static void main(String[] args){
        Snake app = new Snake();
    }
    
    public Snake(){
        super("snake");
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
                if(e.getExtendedKeyCode() == KeyEvent.VK_A){
                    player.changeDirection("left");
                }else if(e.getExtendedKeyCode() == KeyEvent.VK_D){
                    player.changeDirection("right");
                }else if(e.getExtendedKeyCode() == KeyEvent.VK_W){
                    player.changeDirection("up");
                }else if(e.getExtendedKeyCode() == KeyEvent.VK_S){
                    player.changeDirection("down");
                }
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
        gridDimension = resolutionX/20; // 25
        player = new Player();
        food = new Food();
        gameThread = new Thread(this);
        gameThread.start();
        playerBody = new ArrayList<PlayerBody>();
    }

    public void paint(Graphics g){
        food.draw(g);
        player.draw(g);
        for(int i = 0; i < playerBody.size(); i++){
            playerBody.get(i).draw(g);
        }
    }
    
    public void grow(){
        playerBody.add(new PlayerBody());
    }
    
    public void run() {
        do{
            if(player.intersects(food)){
                food.updatePosition();
                grow();
            }
            for(int i = 0; i < playerBody.size(); i++){
                if(player.intersects(playerBody.get(i))){
                    System.out.println("GAME OVER DUDE");
                }
            }
            lastPlayerPosX = player.getPlayerX();
            lastPlayerPosY = player.getPlayerY();
            player.updatePosition();
            player.updatePositionWhenOutOfScreen();
            currentPlayerPosX = player.getPlayerX();
            currentPlayerPosY = player.getPlayerY();
            for(int i = 0; i < playerBody.size(); i++){
                playerBody.get(i).updatePosition();
            }
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
    
    public static int getGridDimension() {
        return gridDimension;
    }
    
    public static int getPlayerBodySize(){
        return playerBody.size();
    }
    
    public static ArrayList getPlayerBody(){
        return playerBody;
    }

    public static int getLastPlayerPosX() {
        return lastPlayerPosX;
    }

    public static int getLastPlayerPosY() {
        return lastPlayerPosY;
    }

    public static int getCurrentPlayerPosX() {
        return currentPlayerPosX;
    }

    public static int getCurrentPlayerPosY() {
        return currentPlayerPosY;
    }
    
}
