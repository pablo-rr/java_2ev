/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panelchanger;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Event;
import java.awt.Panel;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

/**
 *
 * @author Lolmatyc
 */
public class PanelChanger extends Frame{
    Panel panel1;
    Panel panel2;
    CardLayout cardLayout;
    
    public static void main(String[] args) {
        PanelChanger app = new PanelChanger();
    }
    
    public PanelChanger(){
        super("Panel changer");
        setup();
        pack();
        setSize(300,300);
        setVisible(true);
    }
    
    public void setup(){
        panel1 = new Panel();
        panel2 = new Panel();
        cardLayout = (CardLayout) this.getLayout();
        
        setLayout(cardLayout);
        
        panel1.setBackground(Color.RED);
        panel1.add(new Label("panel 1"));
        add(panel1, "panel1");
        //panel1.setVisible(false);
        
        panel2.setBackground(Color.BLUE);
        panel2.add(new Label("panel 2"));
        add(panel2, "panel2");
        //panel2.setVisible(false);
        
        System.out.println(panel1.isVisible());
        System.out.println(panel2.isVisible());
        
        System.out.println("COMPLETED");
        setVisible(true);
    }
    
    public boolean handleEvent(Event e){
        if(e.id == Event.MOUSE_DOWN){
            cardLayout.first(panel1);
            System.out.println(panel1.isVisible());
            System.out.println(panel2.isVisible());
            return true;
        }else if(e.id == Event.WINDOW_DESTROY){
            System.exit(0);
            return true;
        }
        return false;
    }
}
