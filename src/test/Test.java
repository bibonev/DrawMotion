package test;

import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Frame;

public class Test {

	public static void main(String[] args) {
		
		Controller controller = new Controller();
		while (true) {
			if(controller.isConnected()) //controller is a Controller object
			{
			    Frame frame = controller.frame(); //The latest frame
			    Frame previous = controller.frame(1); //The previous frame
			}
			
			System.out.println();
		}

	}

}
