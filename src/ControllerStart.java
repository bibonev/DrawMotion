import java.io.IOException;

import com.leapmotion.leap.*;

public class ControllerStart {
	public static void main(String[] args) {
		//controller - connection to leap motion
		IndexFingerListener indexListener = new IndexFingerListener();
        Controller controller = new Controller();

        // Have the sample listener receive events from the controller
        controller.addListener(indexListener);
        // Keep this process running until Enter is pressed
        System.out.println("Press Enter to quit...");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        controller.removeListener(indexListener);
    }
}
