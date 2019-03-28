package calculadore;

import java.awt.Button;
import java.awt.Event;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;

public class Calculadore extends Frame{
    int resX, resY;
    Panel appPanel;
    Panel resultPanel;
    TextArea resultArea;
    Panel numberPanel;
    Panel[][] numberButtons;
    Panel operatorPanel;
    Panel[] operatorButtons;
    String operation;
    int result;
    
    public static void main(String[] args) {
        Calculadore app = new Calculadore();
    }

    public Calculadore() {
        super("Calculadore");
        setup();
        pack();
        resize(resX, resY);
        show();
    }
    
    public void setupOperatorButtons(){
        for(int i = 0; i < operatorButtons.length; i++){
            operatorButtons[i] = new Panel();
        }
        
        operatorButtons[0].add(new Button("+"));
        operatorButtons[1].add(new Button("-"));
        operatorButtons[2].add(new Button("*"));
        operatorButtons[3].add(new Button("/"));
        operatorButtons[4].add(new Button("="));
        
        for(int i = 0; i < operatorButtons.length; i++){
            operatorPanel.add(operatorButtons[i]);
        }
    }
    
    public void setupNumberButtons(){
        for(int i = 0; i < numberButtons.length; i++){
            for(int j = 0; j < numberButtons[i].length; j++){
                numberButtons[i][j] = new Panel();
            }
        }
        
        for(int i = 0, c = 9; i < numberButtons.length-1; i++){
            for(int j = numberButtons[i].length-1; j >= 0; j--, c--){
                numberButtons[i][j].add(new Button(Integer.toString(c)));
            }
        }
        
        numberButtons[3][0].add(new Button("C"));
        numberButtons[3][1].add(new Button("0"));
        numberButtons[3][2].add(new Button(" , "));
                
        for(int i = 0; i < numberButtons.length; i++){
            for(int j = 0; j < numberButtons[i].length; j++){
                numberPanel.add(numberButtons[i][j]);
            }
        }  
    }
    
    public void setupLayouts(){
        appPanel.setLayout(new GridLayout(3, 1));
        numberPanel.setLayout(new GridLayout(4, 3));
        operatorPanel.setLayout(new GridLayout(1, 5));
    }
    
    public void setupPanels(){
        appPanel = new Panel();
        resultPanel = new Panel();
        numberPanel = new Panel();
        numberButtons = new Panel[4][3];
        operatorPanel = new Panel();
        operatorButtons = new Panel[5];
    }
    
    public void setupApp(){
        resultArea = new TextArea(1, resX/10);
        setupPanels();
        setupLayouts();
        resultPanel.add(resultArea);
        setupNumberButtons();
        setupOperatorButtons();
        
        this.add(appPanel);
        appPanel.add("North", resultPanel);
        appPanel.add("Center", numberPanel);
        appPanel.add("South", operatorPanel);
    }
    
    public void setupFrame(){
        resX = 200;
        resY = 350;
        this.setResizable(false);
        this.setLocation(800, 400);
    }
    
    public void setup(){
        setupFrame();
        setupApp();
    }
    
    public boolean handleEvent(Event e){
        if(e.id == Event.WINDOW_DESTROY){
            System.exit(0);
            return true;
        /*
        }else if(e.target instanceof Button){
            if(e.arg != "="){
                operation += e.arg;
                resultArea.setText(operation);
            }
            return true;
        */
        }
        
        return false;
    }
    
    public void actionPerfomed(ActionEvent e){
            operation += 1;
            resultArea.setText(operation);
    }
}
