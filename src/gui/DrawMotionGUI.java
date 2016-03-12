package gui;

import javax.swing.JFrame;

public class DrawMotionGUI {

		private DrawMotionModel model;
		public DrawMotionGUI(){
			
			model= new DrawMotionModel();
			
			DrawMotionComponent comp = new DrawMotionComponent(model);
			
			JFrame frame = new JFrame("MotionDraw");

			frame.setSize(1920, 1080);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.add(comp);
			frame.setVisible(true);
		}
		public DrawMotionModel getModel(){
			return model;
		}
		
	
}
