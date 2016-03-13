package leapmotion;
import java.io.IOException;

import com.leapmotion.leap.*;

import gui.DrawMotionGUI;

public class ControllerStart {
	public static void main(String[] args) {
		//controller - connection to leap motion
		Controller controller = new Controller();
	    DrawMotionGUI gui = new DrawMotionGUI();
		IndexFingerListener indexListener = new IndexFingerListener(gui.getModel());
		CircleListener circleListener = new CircleListener(gui.getModel());
        // Have the listener receive events from the controller
        controller.addListener(indexListener);
        controller.addListener(circleListener);
        // Keep this process running until Enter is pressed
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        controller.removeListener(indexListener);
    }
}
