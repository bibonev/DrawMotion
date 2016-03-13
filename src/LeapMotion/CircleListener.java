package leapmotion;

import com.leapmotion.leap.CircleGesture;
import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Finger;
import com.leapmotion.leap.Frame;
import com.leapmotion.leap.Gesture;
import com.leapmotion.leap.Hand;
import com.leapmotion.leap.Listener;

import gui.DrawMotionModel;

public class CircleListener extends Listener {
	private DrawMotionModel model;
	private Hand hand;

	public CircleListener(DrawMotionModel model) {
		this.model = model;
	}

	public void onConnect(Controller controller) {
		System.out.println("MenuGestureListener Connected");
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
		hand = frame.hands().rightmost();
		Gesture gesture = frame.gestures().get(0);
		
		Finger thumbFinger = hand.fingers().fingerType(Finger.Type.TYPE_INDEX).get(0);
		if (thumbFinger.tipPosition().getZ() < -70) {
			if (gesture.type().equals(Gesture.Type.TYPE_CIRCLE)) {
				CircleGesture circle = new CircleGesture(gesture);
				if (circle.pointable().direction().angleTo(circle.normal()) > Math.PI / 2) {
					model.setClearValue(true);
				} 
			}
		}
	}
}
