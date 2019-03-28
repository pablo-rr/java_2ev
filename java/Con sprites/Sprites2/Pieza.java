/**
 * @(#)Pieza.java
 *
 *
 * @author 
 * @version 1.00 2019/3/14
 */
import java.awt.Rectangle;
import java.util.Random;
import java.awt.Image;
import java.awt.Graphics;
import java.applet.Applet;

public class Pieza extends Rectangle{
	final static int DIMENSION = 60;
	Image sprite;
	Random random;
	boolean activa;
	
    public Pieza(Image sp) {
    	super(0, 0, DIMENSION, DIMENSION);
    	activa = true;
    	random = new Random();
    	x = random.nextInt(100) + 400;
    	y = random.nextInt(500);
    	sprite = sp;
    }
    
    public void dibujar(Graphics g, Applet applet){
    	g.drawImage(sprite, x, y, applet);
    }
    
}