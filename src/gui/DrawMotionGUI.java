package gui;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JRootPane;

public class DrawMotionGUI {
		private JFrame frame;
		private DrawMotionModel model;
		
		public DrawMotionGUI(){
			model = new DrawMotionModel();
			
			DrawMotionComponent comp = new DrawMotionComponent(model);
			
			frame = new JFrame("MotionDraw");
			frame.setBackground(Color.WHITE);
			frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.add(comp);
			frame.setUndecorated(true);
			frame.setVisible(true);
			frame.setResizable(false);
		}
		public DrawMotionModel getModel(){
			return model;
		}	
}
