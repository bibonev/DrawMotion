package LeapMotion;
import java.io.IOException;

import com.leapmotion.leap.*;

import gui.DrawMotionGUI;

public class ControllerStart {
	public static void main(String[] args) {
		//controller - connection to leap motion
		IndexFingerListener indexListener = new IndexFingerListener();
        Controller controller = new Controller();
        DrawMotionGUI gui = new DrawMotionGUI();
        indexListener.setModel(gui.getModel());
        // Have the sample listener receive events from the controller
        controller.addListener(indexListener);
        // Keep this process running until Enter is pressed
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        controller.removeListener(indexListener);
    }
}
