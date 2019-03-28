/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen2018_1;

import java.awt.Button;
import java.awt.Event;

public class MiBoton extends Button{
    MiChoice left;
    MiChoice right;
    String selectedList;
    
    public MiBoton(String n, MiChoice l, MiChoice r, String sL){
        super(n);
        left = l;
        right = r;
        //selectedList = sL;
    }
    
    public boolean action(Event e, Object o){
        selectedList = Examen2018_1.getSelectedList();
        if(selectedList.equals("left")){
            if(left.getItemCount() > 0){
                right.add(left.getSelectedItem());
                left.remove(left.getSelectedIndex());
            }
        }else if(selectedList.equals("right")){
            
            if(right.getItemCount() > 0){
                left.add(right.getSelectedItem());
                right.remove(right.getSelectedIndex());
            }
        }
        return true;
    }
}
