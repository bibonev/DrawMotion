import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Frame;
import com.leapmotion.leap.Gesture;
import com.leapmotion.leap.Hand;
import com.leapmotion.leap.Listener;

public class MenuGestureListener extends Listener {
	private boolean righthanded = true;
	private Hand hand;
	
	public void setHand(boolean choice){
		righthanded=choice;
	}
	public void onConnect(Controller controller) {
		System.out.println("MenuGestureListener Connected");
		controller.enableGesture(Gesture.Type.TYPE_SWIPE);
		controller.enableGesture(Gesture.Type.TYPE_CIRCLE);
	}

	public void onDisconnect(Controller controller) {
		// Note: not dispatched when running in a debugger.
		System.out.println("MenuGestureListener Disconnected");
	}

	public void onExit(Controller controller) {
		System.out.println("MenuGestureListener Exited");
	}
	public void onFrame(Controller controller){
		Frame frame = controller.frame();
		
		if (!frame.hands().isEmpty()){
			if(righthanded=true)
				hand = frame.hands().rightmost();
			else
				hand=frame.hands().leftmost();
			
		}
		
	}
}
