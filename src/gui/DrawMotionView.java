package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DrawMotionView extends JPanel implements Observer{
	
	private DrawMotionModel model;
	
	public DrawMotionView(DrawMotionModel model) {
		super();
		this.model = model;
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		Color c = new Color(255, 0, 0);
		
		g2.setColor(c);
		Spot spot = model.getPoint();
		if(spot!=null)
		g2.fill(spot);
	}

	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}	
}
