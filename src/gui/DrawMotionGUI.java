package gui;

import javax.swing.JFrame;

public class DrawMotionGUI extends JFrame {

	public static void main(String[] args) {
		
		DrawMotion dm = new DrawMotion();
		for(int i = 0; i < 10; i++) {
			dm.addPoint(new Spot(i+10, i+11, 10));
		}
		DrawMotionComponent comp = new DrawMotionComponent(dm);
		
		JFrame frame = new JFrame("Painting");

		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(comp);
		frame.setVisible(true);
	}
}
