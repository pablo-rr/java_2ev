/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen2018_1;

import java.awt.Event;
import java.awt.Frame;
import java.awt.List;

public class Examen2018_1 extends Frame{
    int resX, resY;
    String sports[];
    List listSports;
    MiChoice choiceSportsLeft;
    MiChoice choiceSportsRight;
    MiBoton buttonChangeSports;
    String intermediate;
    private static String selectedList;
    
    public static void main(String[] args) {
        Examen2018_1 app = new Examen2018_1();
    }

    public Examen2018_1(){
        super("hi");
        setup();
        pack();
        setSize(resX, resY);
        setVisible(true);
    }
    
    public void setup(){
        setupFrame();
        setupApp();
    }
    
    public void setupFrame(){
        resX = resY = 300;
        //setResizable(false);
        setLocation(450, 300);
    }
    
    public void setupApp(){
        selectedList = "left";
        sports = new String[]{"Karate", "Futbol", "Baloncesto", "Tenis", "Judo"};
        listSports = new List();
        choiceSportsLeft = new MiChoice("left", selectedList);
        choiceSportsRight = new MiChoice("right", selectedList);
        buttonChangeSports = new MiBoton("Change", choiceSportsLeft, choiceSportsRight, selectedList);
        
        for(int i = 0; i < sports.length; i++){
            choiceSportsLeft.add(sports[i]);
            //choiceSportsRight.add(sports[i]);
        }
        
        add("West", choiceSportsLeft);
        add("East", choiceSportsRight);
        add("Center", buttonChangeSports);
    }
    
    public boolean handleEvent(Event e){
        if(e.id == Event.WINDOW_DESTROY){
            System.exit(0);
            return true;
        }else if(e.id == Event.WINDOW_MOVED){
            System.out.println(selectedList);
            return true;
        }
        return false;
    }
    
    public static String getSelectedList(){
        return selectedList;
    }
    
    public static void setSelectedList(String newSelectedList){
        selectedList = newSelectedList;
    }
    
}
