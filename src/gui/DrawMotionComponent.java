package gui;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class DrawMotionComponent extends JPanel {

	
	public DrawMotionComponent(DrawMotionModel dm) {
		super();
		DrawMotionView view = new DrawMotionView(dm);

		dm.addObserver(view);
		
		setLayout(new BorderLayout());
//		Button button = new Button("Save image");
//        button.addActionListener(e -> {
//           view.screenshot();
//        });
		add(view, BorderLayout.CENTER);
	//	add(button, BorderLayout.SOUTH);
	}
}
