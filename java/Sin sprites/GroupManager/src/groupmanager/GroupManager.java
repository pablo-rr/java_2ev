package groupmanager;

import java.awt.Button;
import java.awt.Color;
import java.awt.Event;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BoxLayout;

public class GroupManager extends Frame{
    int resX, resY;
    Panel pan_group;
    Panel pan_memberContainer;
    
    public static void main(String[] args) {
        GroupManager app = new GroupManager();
    }

    public GroupManager(){
        super("Group Manager");
        setup();
        pack();
        setSize(resX, resY);
        setVisible(true);
    }
    
    public void setup(){
        setupFrame();
        setupPanels();
    }
    
    public void setupFrame(){
        resX = resY = 300;
        setResizable(false);
        setBackground(Color.WHITE);
    }
    
    public void setupPanels(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        pan_group = new Panel();
        pan_memberContainer = new Panel();
        
        pan_group.add(new Button("hi"));
        pan_memberContainer.add(new Button("bye"));
        
        add(pan_group);
        add(pan_memberContainer);
    }
    
    public void setupListeners(){
        addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                //
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    @Override
    public boolean handleEvent(Event e) {
        if(e.id == Event.WINDOW_DESTROY){
            System.exit(0);
            return true;
        }else if(e.id == Event.MOUSE_DOWN){
            System.out.println(e.target);
            if(e.target instanceof Button){
                System.out.println("hiiiiiiiiiiiiii");
                return true;
            }
        }
        return false;
    }
    
    public boolean actionPerformed(ActionEvent e){
        System.out.println(e.getSource());
        if(e.getSource() instanceof Button){
            System.out.println("hiiii");
            return true;
        }
        return false;
    }

}
