/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sprites1;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class DibujoAnimado extends Rectangle{
    int posImg;
    Image animacionesSprite[];
    
    public DibujoAnimado(){
        //animacionesSprite = new Image[]{ImageIO.read(new File("g1.gif")), ImageIO.read(new File("g2.gif")), ImageIO.read(new File("g3.gif")), ImageIO.read(new File("g4.gif"))};
        super();
        posImg = 0;
    }
    
    public void actualizar(){
        posImg = (posImg + 1) % 4; //animacionesSprite.length;
        System.out.println(posImg);
    }
    
    public void dibujar(Graphics g){
        //g.drawImage(animacionesSprite[posImg], 0, 0, this);
    }
    
    public void goLeft(){
    	//x += 1;
    }
    
    public void goRight(){
    	//x += 1;
    }
}