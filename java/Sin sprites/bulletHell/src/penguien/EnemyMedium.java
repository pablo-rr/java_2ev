/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penguien;

import java.awt.Color;
import java.util.Random;

/**
 *
 * @author 1h
 */
public class EnemyMedium extends Enemy{

    public EnemyMedium(int resX, int resY) {
        super(resX, resY);
        width = height = 50;
        //color = Color.YELLOW;
        random = new Random();
        y = random.nextInt(resY)-20;
        speed = 10;
    }
    
}