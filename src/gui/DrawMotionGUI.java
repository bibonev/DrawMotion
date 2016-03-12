package gui;

import javax.swing.JFrame;

public class DrawMotionGUI extends JFrame {

	public static void main(String... args) {
		JFrame frame = new JFrame("Painting");

		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		DrawMotionView comp = new DrawMotionView(50, 50);
		frame.add(comp);

		frame.setVisible(true);
	}
}
