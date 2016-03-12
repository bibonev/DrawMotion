package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class DrawMotionComponent extends JPanel {
	private int count = 0;
	
	public DrawMotionComponent(DrawMotion dm) {
		super();
		DrawMotionModel model = new DrawMotionModel(dm);
		DrawMotionView view = new DrawMotionView(model);
		
		/*JButton button = new JButton("Click");
		
		button.addActionListener(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					model.addPoint(new Spot(50, 50, 10));
					//count++;
				}
			});*/
		
		model.addObserver(view);
		
		setLayout(new BorderLayout());
		add(view, BorderLayout.CENTER);
		//add(button, BorderLayout.SOUTH);
	}
}
