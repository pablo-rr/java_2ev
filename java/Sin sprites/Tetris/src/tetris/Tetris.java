package tetris;

import java.applet.Applet;
import java.awt.Graphics;
import java.util.Random;

public class Tetris extends Applet implements Runnable{
    Thread game;
	Figure figures[];
	Figure figure;
	Random randomGenerator;
    
	public void init() {
		figures = new Figure[7];
		for (int i = 0; i < figures.length; i++) {

		}
		figure = new Figure(true, "Z");
		randomGenerator = new Random();
	}

    public void start(){
        game = new Thread(this);
        game.start();
    }
    
	public void paint(Graphics g) {
		figure.drawFigure(g);
	}

    public void run(){
        do{
            try{
				Thread.sleep(1000);
			} catch (InterruptedException IE) {
                // do nothing when exception happens
            }
			figure.updateFigure();
			// System.out.println(randomGenerator.nextInt());
			repaint();
        }while(true);
    }
}
