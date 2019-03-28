package tetris;

import java.awt.Color;
import java.awt.Graphics;

public class Figure extends Block {
	private static int mainBlockPosX;
	private static int mainBlockPosY;
	private static int area;
	private static boolean canFall;
	private static String figureType;
	private static String figures[] = { "O", "L", "J", "K", "Z", "S", "I" };

	public Figure(boolean cF, String fT) {
		super(cF);
        mainBlockPosX = Block.getMainBlockPosX();
        mainBlockPosY = Block.getMainBlockPosY();
		area = Block.getArea();
		canFall = cF;
		figureType = fT;
    }

	public void drawFigure(Graphics g) {
		if (figureType == figures[0]) {
			g.setColor(Color.YELLOW);
			g.fillRect(mainBlockPosX, mainBlockPosY, area, area); // main block, from which the rest builds
			g.fillRect(mainBlockPosX, mainBlockPosY + area, area, area);
			g.fillRect(mainBlockPosX + area, mainBlockPosY, area, area);
			g.fillRect(mainBlockPosX + area, mainBlockPosY + area, area, area);
		} else if (figureType == figures[1]) {
			g.setColor(Color.ORANGE);
			g.fillRect(mainBlockPosX, mainBlockPosY, area, area); // main block, from which the rest builds
			g.fillRect(mainBlockPosX, mainBlockPosY + area, area, area);
			g.fillRect(mainBlockPosX, mainBlockPosY + area * 2, area, area);
			g.fillRect(mainBlockPosX + area, mainBlockPosY + area * 2, area, area);
		} else if (figureType == figures[2]) {
			g.setColor(Color.MAGENTA);
			g.fillRect(mainBlockPosX, mainBlockPosY, area, area); // main block, from which the rest builds
			g.fillRect(mainBlockPosX, mainBlockPosY + area, area, area);
			g.fillRect(mainBlockPosX, mainBlockPosY + area * 2, area, area);
			g.fillRect(mainBlockPosX - area, mainBlockPosY + area * 2, area, area);
		} else if (figureType == figures[3]) {
			g.setColor(Color.RED);
			g.fillRect(mainBlockPosX, mainBlockPosY, area, area); // main block, from which the rest builds
			g.fillRect(mainBlockPosX + area, mainBlockPosY, area, area);
			g.fillRect(mainBlockPosX + area, mainBlockPosY + area, area, area);
			g.fillRect(mainBlockPosX + area * 2, mainBlockPosY + area, area, area);
		} else if (figureType == figures[4]) {
			g.setColor(Color.GREEN);
			g.fillRect(mainBlockPosX, mainBlockPosY, area, area); // main block, from which the rest builds
			g.fillRect(mainBlockPosX + area, mainBlockPosY, area, area);
			g.fillRect(mainBlockPosX, mainBlockPosY + area, area, area);
			g.fillRect(mainBlockPosX - area, mainBlockPosY + area, area, area);
		} else if (figureType == figures[5]) {
			g.setColor(Color.PINK);
			g.fillRect(mainBlockPosX, mainBlockPosY, area, area); // main block, from which the rest builds
			g.fillRect(mainBlockPosX, mainBlockPosY + area, area, area);
			g.fillRect(mainBlockPosX + area, mainBlockPosY + area, area, area);
			g.fillRect(mainBlockPosX - area, mainBlockPosY + area, area, area);
		} else if (figureType == figures[6]) {
			g.setColor(Color.BLUE);
			g.fillRect(mainBlockPosX, mainBlockPosY, area, area); // main block, from which the rest builds
			g.fillRect(mainBlockPosX, mainBlockPosY + area, area, area);
			g.fillRect(mainBlockPosX, mainBlockPosY + area * 2, area, area);
			g.fillRect(mainBlockPosX, mainBlockPosY + area * 3, area, area);
		}
	}

	public void updateFigure() {
		if (canFall) {
			mainBlockPosY += area;
		}
	}

	public String[] getFigures() {
		return figures;
	}
}
