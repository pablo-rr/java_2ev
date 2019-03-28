/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penguien;

import java.util.Random;
import java.awt.Color;

public class EnemyEasy extends Enemy{
    
    public EnemyEasy(int resX, int resY){
        super(resX, 0);
        //color = Color.GREEN;
        random = new Random();
        y = random.nextInt(resY)-20;
        speed = 5;
    }
    
}
