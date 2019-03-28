package infiniterunner;

import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

public class Block extends Rectangle{
    private Color color;
    private boolean kills; // if it doesn't kill, it awards points
    private static boolean visible;
    private static int speed;
    private boolean canGoDown;
    private Random random;
    private int pos1, pos2, pos3;
    private int level;
    private int difficulty;
    private int levelsToIncreaseDifficulty;
    private int upgradedSpeed;
    
    public Block(int x, int w, int h, Color c){
        super(x, -10, w, h);
        this.color = c;
        this.visible = true;
        this.speed = 3;
        this.random = new Random();
        pos1 = InfiniteRunner.getPos1();
        pos2 = InfiniteRunner.getPos2();
        pos3 = InfiniteRunner.getPos3();
        levelsToIncreaseDifficulty = 3;
        level = 0;
        difficulty = 1;
        upgradedSpeed = 1;
    }
    
    public void drawBlock(Graphics g){
        if(visible){
            g.setColor(color);
            g.fillRect(x, y, width, height);
        }
    }
    
    public void moreSpeed(){
        this.setSpeed(speed + 1);
    }
    
    public void goDown(Player plr){
        if(y <= 300){
            this.y += this.speed;
        }else{
            setLevel(getLevel() + 1);
            this.y = -10;
            this.newPosition();
            if(getLevel() == levelsToIncreaseDifficulty){
                setLevel(0);
                speed += upgradedSpeed;
                setDifficulty(getDifficulty() + 1);
            }
            InfiniteRunner.increaseScore();
        }
        
        if(this.intersects(plr)){
            InfiniteRunner.setGameOver(true);
        }
    }
    
    public void newPosition(){
        int whereTo = random.nextInt(3)+1;
        if(whereTo == 1){
            this.x = pos1;
        }else if(whereTo == 2){
            this.x = pos2;
        }else if(whereTo == 3){
            this.x = pos3;
        }
    }

    public static boolean isVisible() {
        return visible;
    }

    public static void setVisible(boolean aVisible) {
        visible = aVisible;
    }
    
    public void setSpeed(int aSpeed) {
        speed = aSpeed;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getDifficulty() {
        return difficulty;
    }
    
    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
    
    public void resetBlock(){
        level = 0;
        difficulty = 1;
        upgradedSpeed = 1;
        y = -10;
        speed = 3;
        visible = true;
    }
}
