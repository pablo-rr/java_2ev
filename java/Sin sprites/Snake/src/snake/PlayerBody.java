package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class PlayerBody extends Player{
    ArrayList<PlayerBody> playerBody;
    ArrayList<Integer> positionsX;
    ArrayList<Integer> positionsY;
    static Color color;
    public PlayerBody(){
        super();
        playerBody = Snake.getPlayerBody();
        color = Food.getColor();
        positionsX = new ArrayList<>();
        positionsY = new ArrayList<>();
    }
    
    public void draw(Graphics g){
        g.setColor(color);
        g.drawRect(x, y, width, height);
    }
    
    public void savePositions(){
        if(Snake.getPlayerBodySize() >= 2){
            for(int i = 0; i < Snake.getPlayerBodySize()-1; i++){
                positionsX.add(playerBody.get(i).x);
                positionsY.add(playerBody.get(i).y);
            }
        }
    }
    
    public void updatePosition(){
        savePositions();
        playerBody = Snake.getPlayerBody();
        playerBody.get(0).x = Snake.getLastPlayerPosX();
        playerBody.get(0).y = Snake.getLastPlayerPosY();
        for(int i = 1, j = 0; i < Snake.getPlayerBodySize(); i++, j++){
            playerBody.get(i).x = positionsX.get(i - 1);
            playerBody.get(i).y = positionsY.get(i - 1);
            System.out.println("bl" + i + " - x:" + playerBody.get(i).x);
            System.out.println("bl" + i + " - y:" + playerBody.get(i).y);
        }
        System.out.println("------------------------------------------");
    }
    
}
