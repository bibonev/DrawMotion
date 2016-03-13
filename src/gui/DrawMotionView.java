package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DrawMotionView extends JPanel implements Observer{
	
	private DrawMotionModel model;
	private Color c;
	public DrawMotionView(DrawMotionModel model) {
		super();
		this.model = model;
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		Color c = model.getColor();
		
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
