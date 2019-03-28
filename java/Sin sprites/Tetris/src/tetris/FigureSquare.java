package tetris;
import java.awt.Color;
import java.awt.Graphics;

public class FigureSquare extends Block{
    private static int mainBlockPosX;
    private static int mainBlockPosY;
    private static int area;
    private static Color figureSquareColor;
	private static boolean canFall;
    
	public FigureSquare(boolean cF) {
		super(cF);
        mainBlockPosX = Block.getMainBlockPosX();
        mainBlockPosY = Block.getMainBlockPosY();
		area = Block.getArea();
		figureSquareColor = Color.ORANGE;
		canFall = cF;
    }
    
	public void drawSquare(Graphics g) {
        g.setColor(figureSquareColor);
        g.fillRect(mainBlockPosX, mainBlockPosY, area, area); // this is the main block, from which the rest may calculate their positions
		g.fillRect(mainBlockPosX, mainBlockPosY + area, area, area);
		g.fillRect(mainBlockPosX + area, mainBlockPosY, area, area);
		g.fillRect(mainBlockPosX + area, mainBlockPosY + area, area, area);
	}

	public void updateSquareFigure() {
		if (canFall) {
			mainBlockPosY += area;
		}
	}
}
