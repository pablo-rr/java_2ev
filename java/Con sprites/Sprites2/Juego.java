/**
 * @(#)Juego.java
 *
 *
 * @author 
 * @version 1.00 2019/3/14
 */
import java.applet.Applet;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.event.MouseInputListener;

public class Juego extends Applet{
	Thread thread;
	static final int GRID = 5;
	static final int NUMERO_PIEZAS = GRID*GRID;
	Pieza piezaSeleccionada;
	Image spritesPiezas[];
	Pieza piezas[];
	
    public void init(){
        setupGame();
        setupListeners();
    }
    
    public void setupGame(){
        piezas = new Pieza[NUMERO_PIEZAS];
        spritesPiezas = new Image[NUMERO_PIEZAS];
        for(int i = 0; i < NUMERO_PIEZAS; i++){
        	spritesPiezas[i] = getImage(getCodeBase(), i + ".png");
        	piezas[i] = new Pieza(spritesPiezas[i]);
        }
    }
    
    public void setupListeners(){
        this.addMouseListener(new MouseInputListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {
            	if(piezaSeleccionada == null){
            		for(int i = 0; i < NUMERO_PIEZAS; i++){
        				if(piezas[i].contains(e.getX(), e.getY())){
        					piezaSeleccionada = piezas[i];
        					System.out.println(piezaSeleccionada);
        				}
        			}
            	}else{
            		piezaSeleccionada.
            	}
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
        for(int i = 0; i < NUMERO_PIEZAS; i++){
        	piezas[i].dibujar(g, this);
        }
    }
}