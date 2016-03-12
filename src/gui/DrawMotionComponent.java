package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class DrawMotionComponent extends JPanel {

	
	public DrawMotionComponent(DrawMotionModel dm) {
		super();
		DrawMotionView view = new DrawMotionView(dm);
		dm.addObserver(view);
		
		setLayout(new BorderLayout());
		add(view, BorderLayout.CENTER);
		//add(button, BorderLayout.SOUTH);
	}
}
