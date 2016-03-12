package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DrawMotionView extends JPanel implements Observer{
	private int xCoord;
	private int yCoord;
	
	private Spot point;

	public DrawMotionView(int x, int y) {
		this.setxCoord(x);
		this.setyCoord(y);
		
		this.point = new Spot(x, y, 20);
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		Color c = new Color(255, 0, 0);
		
		g2.setColor(c);
		g2.fill(point);
	}

	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}

	public int getxCoord() {
		return xCoord;
	}

	public void setxCoord(int xCoord) {
		this.xCoord = xCoord;
	}

	public int getyCoord() {
		return yCoord;
	}

	public void setyCoord(int yCoord) {
		this.yCoord = yCoord;
	}
	
}
