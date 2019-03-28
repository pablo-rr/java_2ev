package colorfall;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Random;

public class ColorFall extends Frame implements Runnable{
    private static int resolutionX;
    private static int resolutionY;
    int gridSize;
    Thread gameThread;
    int threadCounter;
    int threadCounter2;
    int threadTime;
    boolean gameOver;
    int timeBetweenEnemies;
    int difficulty;
    Font gameOverFont;
    Font newColorFont;
    ArrayList<ColorBlock> colorBlocks;
    int tilesPerRow;
    Color colors[];
    Random random;
    int colorToShow;
    String color;
    boolean isVis;
    boolean isMouseSafe;
    int mouseX, mouseY;
    int score;
    int changeSpeed;
    
    public static void main(String[] args) {
        ColorFall app = new ColorFall();
    }
    
    public ColorFall(){
        super("ColorFall");
        setup();
        pack();
        resize(resolutionX, resolutionY);
        show();
    }
    
    public void setup(){
        setupListeners();
        setupFrame();
        setupGame();
        setupBlocks();
    }
    
    public void setupListeners(){
        
        this.addMouseMotionListener(new MouseMotionListener(){

            @Override
            public void mouseDragged(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
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
        setLocation(200, 30);
        setResizable(false);
        setAlwaysOnTop(true);
    }
    
    private void setupGame(){
        resolutionX = 800;
        resolutionY = resolutionX + 100;
        gridSize = resolutionX/10;
        tilesPerRow = resolutionX/gridSize;
        gameOver = false;
        setBackground(Color.BLACK);
        threadTime = 40;
        threadCounter = 0;
        gameOverFont = new Font("gameOverFont", 0, 50);
        newColorFont = new Font("newColorFont", 0, 30);
        colorBlocks = new ArrayList<>();
        colors = new Color[] {Color.GRAY, Color.BLUE, Color.GREEN, Color.MAGENTA, Color.YELLOW, Color.ORANGE, Color.PINK, Color.WHITE, Color.CYAN, Color.RED};
        random = new Random();
        isVis = true;
        mouseX = mouseY = 0;
        score = 0;
        difficulty = 0;
        changeSpeed = 2000;
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    public void setupBlocks(){
        for(int i = 0; i < tilesPerRow; i++){
            for(int j = 0; j < tilesPerRow; j++){
                colorBlocks.add(new ColorBlock(i*gridSize, j*gridSize+(resolutionY - resolutionX), gridSize, colors));
            }
        }
    }
    
    public void paint(Graphics g){
        if(!gameOver){
            for(int i = 0; i < tilesPerRow*tilesPerRow; i++){
                colorBlocks.get(i).draw(g);
            }
            g.setFont(newColorFont);
            g.setColor(Color.WHITE);
            g.drawString("Color: " + color, 50, 75);
            g.drawString("Score: " + score, 300, 75);
        }else{
            g.setFont(gameOverFont);
            g.setColor(Color.WHITE);
            g.drawString("GAME OVER", 275, resolutionY/2);
            g.setFont(newColorFont);
            g.drawString("YOUR FINAL SCORE IS: " + score, 225, 500);
        } 
    }
    
    public void checkMouseSafety(){
        for(int i = 0; i < tilesPerRow*tilesPerRow; i++){
            //System.out.println(i);
            try{
                if(colorBlocks.get(i).contains(mouseX, mouseY) && colorBlocks.get(i).getColor() != colors[colorToShow] && !isVis){
                    isMouseSafe = false;
                }else if(colorBlocks.get(i).contains(mouseX, mouseY) && colorBlocks.get(i).getColor() == colors[colorToShow] && isVis){
                    isMouseSafe = true;
                }
            }catch(IndexOutOfBoundsException exc){
                // do nothing with exception
            }
        }
    }
    
    public void selectColor(){
        colorToShow = random.nextInt(colors.length);
        switch (colorToShow){
            case 0:
                color = "Gray";
                break;
            case 1:
                color = "Blue";
                break;
            case 2:
                color = "Green";
                break;
            case 3:
                color = "Magenta";
                break;
            case 4:
                color = "Yellow";
                break;
            case 5:
                color = "Orange";
                break;
            case 6:
                color = "Pink";
                break;  
            case 7:
                color = "White";
                break;
            case 8:
                color = "Cyan";
                break;
            case 9:
                color = "Red";
                break;
        }
    }
    
    public void hideBlocksTimer(int t){
        if(t > threadCounter){
            threadCounter += threadTime;
            //System.out.println(threadCounter);
        }else{
            if(isVis){
                invisibleBlocks();
            }else{
                visibleBlocks();
            }
            threadCounter = 0;
        }
    }
    
    public void invisibleBlocks(){
        for(int i = 0; i < colorBlocks.size(); i++){
            if(colorBlocks.get(i).getColor() != colors[colorToShow]){
                colorBlocks.get(i).setVisible(false);
            }
        }
        isVis = false;
    }
    
    public void visibleBlocks(){
        for(int i = 0; i < colorBlocks.size(); i++){
            colorBlocks.get(i).setVisible(true);
        }
        isVis = true;
        score += 10;
        if(changeSpeed >= 400){
            changeSpeed -= 100;
        }
        selectColor();
    }
    
    public void run(){
        selectColor();
        do{
            hideBlocksTimer(changeSpeed);
            checkMouseSafety();
            if(!isVis && !isMouseSafe){
                gameOver = true;
            }
            try{
                Thread.sleep(threadTime);
            }catch(InterruptedException ie){
                // do nothing with exception
            }
            repaint();
        }while(!gameOver);
    }
}
