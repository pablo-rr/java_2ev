/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen2018_1;

import java.awt.Choice;
import java.awt.Event;

public class MiChoice extends Choice{
    String selectedList;
    
    public MiChoice(String n, String sL){
        super();
        setName(n);
        selectedList = sL;
    }

    public boolean action(Event e, Object o){
        selectedList = getName();
        Examen2018_1.setSelectedList(selectedList);
        System.out.println(selectedList);
        return true;
    }
}
