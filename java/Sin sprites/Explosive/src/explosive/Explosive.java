/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package explosive;

import java.awt.Frame;
import java.awt.Graphics;

public class Explosive extends Frame implements Runnable{
    Explosion explosion;
    
    public static void main(String[] args) {
        Explosive app = new Explosive();
    }
    
    public Explosive(){
        setup();
        pack();
        resize(600, 600);
        show();
    }
    
    public void setup(){
        explosion = new Explosion(200, 200, 30);
    }
    
    public void paint(Graphics g){
        explosion.draw(g);
    }
    
    public void run(){
        do{
            
            try{
                Thread.sleep(15);
            }catch(InterruptedException ie){
                // do nothing with exception
            }
            repaint();
        }while(true);
    }
    
}
