/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sprites1;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.event.MouseInputListener;

/**
 *
 * @author 1h
 */
public class Sprites1 extends Applet implements Runnable{
    Thread thread;
    DibujoAnimado dibujoAnimado;
    int posicionAnimado;
    Image spriteAnimado[][];
    int resX, resY;
    int posImg;
    int spriteMostrado;
    String directorios[];
    ArrayList<DibujoAnimado> dibujos;
    
    final int GUERRILLERO = 0;
    final int MAFIOSO = 1;
    final int VAQUERO = 2;

    public void init(){
        setupGame();
        setupListeners();
    }
    
    public void setupGame(){
        posicionAnimado = 0;
        dibujoAnimado = new DibujoAnimado();
        thread = new Thread(this);
        thread.start();
        spriteAnimado = new Image[3][4];
        posImg = 0;
        spriteMostrado = GUERRILLERO;
        directorios = new String[]{"S1/g", "S2/g", "S3/g"};
        dibujos = new ArrayList<>();
        
        for(int i = 0; i < spriteAnimado.length; i++){
        	for(int j = 0; j < spriteAnimado[0].length-1; j++){
            	spriteAnimado[i][j] = getImage(getCodeBase(), directorios[i] + j + ".gif");
        	}
        }
        
        for(int i = 0; i < 2; i++){
            dibujos.add(new DibujoAnimado());
        }
    }
    
    public void setupListeners(){
        this.addMouseListener(new MouseInputListener() {

            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {
                //System.out.println("clik");
                //if(dibujos.size() == 4){
                	dibujos.remove(1);
                //}
            }
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
            @Override
            public void mouseDragged(MouseEvent e) {}
            @Override
            public void mouseMoved(MouseEvent e) {}
        });
    }
    
    public void paint(Graphics g){
        //dibujoAnimado.dibujar(g);
        for(int i = 0; i < dibujos.size(); i++){
        	for(int j = 0; j < dibujos.size(); j++){
            	g.drawImage(spriteAnimado[spriteMostrado][posImg], i*500, j*500, this);
        	}
        }
    }
    
    public void actualizar(){
        posImg = (posImg + 1) % 4; //animacionesSprite.length;
        //System.out.println(posImg);
    }
    
    @Override
    public void run() {
        do{
            repaint();
            actualizar();
            try{
                Thread.sleep(50);
            }catch(InterruptedException exc){
                //nothing :D
            }
            
        }while(true);
    }

    @Override
    public boolean handleEvent(Event e) {
        if(e.id == Event.WINDOW_DESTROY){
            System.exit(0);
            return true;
        }else if(e.id == Event.TAB){
            if(spriteMostrado == GUERRILLERO){
                spriteMostrado++;
            }else if(spriteMostrado == MAFIOSO){
                spriteMostrado++;
            }else if(spriteMostrado == VAQUERO){
                spriteMostrado = 0;
            }
            return true;
        }
        return false;
    }

	public boolean mouseDown(Event e, int x, int y){
    	System.out.println("hi");
    	return true;
    }

    public boolean keyDown(Event e, int t){
    	
    	if(t == 103){
    		System.out.println("hi");
    	}else if(t == 118 || t == 86){
    		System.out.println("bye");
    	}else if(t == 104 || t == 72){
    		System.out.println("bye");
    	}
    	return true;
    }
}
