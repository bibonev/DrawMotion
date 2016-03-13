package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.util.Observable;
import java.util.Observer;

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
		
		if (!model.isClearValue()) {
			g2.setColor(c);
			Spot spot = model.getPoint();
			if(spot!=null)
			g2.fill(spot);
		} else {
			g2.clearRect(0, 0, Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
			model.setClearValue(false);
			model.setPoint(null);
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}	
}
