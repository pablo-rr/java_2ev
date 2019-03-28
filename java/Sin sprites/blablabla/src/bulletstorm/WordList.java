package bulletstorm;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.*;
import java.util.ArrayList;
        
public class WordList extends Frame implements Runnable{
    Thread gameThread;
    int resolutionX, resolutionY;
    int threadStopTime;
    int threadCounter;
    ArrayList<Word> words;
    int wordCounter;
    String quijote[] = {"En", "un", "lugar", "de", "la", "mancha", "de", "cuyo", "nombre", "no", "quiero", "acordarme", "no", "ha", "mucho", "tiempo", "que", "vivia", "un", "hidalgo", "de", "los", "de", "lanza", "en", "astillero", "adarga", "antigua", "rocin", "flaco", "y", "galgo", "corredor"};
    static boolean gameOver;
    String phrase;
    int wordsDeleted;
    String overMessage;
    
    public static void main(String[] args) {
        WordList app = new WordList();
    }
    
    public WordList(){
        super("Quijote");
        setup();
        pack();
        resize(resolutionX, resolutionY);
        show();
    }
    
    public void paint(Graphics g){
        if(!gameOver){
            for(int i = 0; i < words.size(); i++){
                words.get(i).draw(g);
            }
        }else{
            g.drawString(overMessage, 200, 200);
        }
        //g.drawString(phrase, 50, resolutionY-20);
    }
    
    public void setup(){
        setupFrame();
        setupGame();
        setupListeners();
    }
  
    public void setupFrame(){
        resolutionX = 800;
        resolutionY = 600;
        this.setResizable(false);
        this.setLocation(200, 200);
        this.setBackground(Color.BLUE);
    }
    
    public void setupGame(){
        threadStopTime = 10;
        gameThread = new Thread(this);
        gameThread.start();
        gameOver = false;
        wordCounter = 0;
        words = new ArrayList<>();
        overMessage = "GAME OVER";
    }

    public void setupListeners(){
        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent wE){
                System.exit(0);
            }
        });
        
        this.addMouseListener(new MouseListener(){
            @Override
            
            public void mouseClicked(MouseEvent e) {
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                for(int i = 0; i < words.size(); i++){
                    if(words.get(i).contains(e.getX(), e.getY())){
                        phrase += words.get(i).getText() + " ";
                        if(words.get(i).getColor() == Color.RED){
                            words.remove(i);
                        }else{
                            words.get(i).setColor(Color.RED);
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
    
    public void addWord(int between){
        if(threadCounter < between){
            threadCounter += threadStopTime;
        }else{
            if(wordCounter < quijote.length-1){
                words.add(new Word(resolutionX, resolutionY, quijote[wordCounter]));
                threadCounter = 0;
                wordCounter++;
            }
        }
    }

    public void run(){
        do{
            addWord(750);
            if(wordsDeleted == quijote.length -1){
                gameOver = true;
                overMessage = "HAS GANADO";
            }
            for(int i = 0; i < words.size(); i++){
                words.get(i).moveLeft();
            }
            repaint();
            try{
                Thread.sleep(threadStopTime);
            }catch(InterruptedException exc){
                // do nothing
            }
        }while(!gameOver);
    }

    private void addMouseAdapter(MouseAdapter mouseAdapter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

