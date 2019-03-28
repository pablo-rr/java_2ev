package tetris;
import java.awt.Rectangle;

public class Block extends Rectangle{
	private static int area;
	private static int mainBlockPosX;
	private static int mainBlockPosY;
	private static boolean canFall;
    
	public Block(boolean cF) {
		width = area;
		height = area;
		area = 40;
		mainBlockPosX = 60;
		mainBlockPosY = 0;
		canFall = cF;
    }

	public static int getArea() {
		return area;
    }

    public static int getMainBlockPosX() {
        return mainBlockPosX;
    }
    
    public static void setMainBlockPosX(int aMainBlockPosX) {
        mainBlockPosX = aMainBlockPosX;
    }
    
    public static int getMainBlockPosY() {
        return mainBlockPosY;
    }

    public static void setMainBlockPosY(int aMainBlockPosY) {
        mainBlockPosY = aMainBlockPosY;
    }

	public static boolean getCanFall() {
		return canFall;
	}

	public static void setCanFall(boolean aCanFall) {
		canFall = aCanFall;
	}
}
