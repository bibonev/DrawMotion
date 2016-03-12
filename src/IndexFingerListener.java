import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Finger;
import com.leapmotion.leap.Frame;
import com.leapmotion.leap.Gesture;
import com.leapmotion.leap.Hand;
import com.leapmotion.leap.Listener;

class IndexFingerListener extends Listener {
	private boolean righthanded = true;
	private Hand hand;
	
	public void setHand(boolean choice){
		righthanded=choice;
	}
	public void onInit(Controller controller) {
		System.out.println("IndexFingerListener Initialized");
	}

	public void onConnect(Controller controller) {
		System.out.println("IndexFingerListener Connected");
		controller.enableGesture(Gesture.Type.TYPE_SWIPE);
		controller.enableGesture(Gesture.Type.TYPE_CIRCLE);
	}

	public void onDisconnect(Controller controller) {
		// Note: not dispatched when running in a debugger.
		System.out.println("IndexFingerListener Disconnected");
	}

	public void onExit(Controller controller) {
		System.out.println("IndexFingerListener Exited");
	}

	public void onFrame(Controller controller) {

		Frame frame = controller.frame();

		if (!frame.hands().isEmpty()){
			if(righthanded=true)
				hand = frame.hands().rightmost();
			else
				hand=frame.hands().leftmost();
		Finger indexFinger = hand.fingers().fingerType(Finger.Type.TYPE_INDEX).get(0);
		System.out.println("    " + indexFinger.type() + ", id: " + indexFinger.id() + ", tip position: "
				+ indexFinger.tipPosition());
		}
		if (!frame.hands().isEmpty())
			System.out.print("");
		}
	}

