package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class DrawMotionComponent extends JComponent {
	

	public DrawMotionComponent() {
		super();

		
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		
		Color c = new Color(0, 255, 0);
		g2.setColor(c);
		
		//g2.drawLine(xClicked, yClicked, xDragged, yDragged);
		g2.dispose();
		
		repaint();
	}
}
