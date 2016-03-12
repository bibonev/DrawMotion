package LeapMotion;
import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Finger;
import com.leapmotion.leap.Frame;
import com.leapmotion.leap.Gesture;
import com.leapmotion.leap.Hand;
import com.leapmotion.leap.InteractionBox;
import com.leapmotion.leap.Leap;
import com.leapmotion.leap.Listener;
import com.leapmotion.leap.Pointable;
import com.leapmotion.leap.Vector;

import gui.DrawMotionModel;
import gui.Spot;

class IndexFingerListener extends Listener {
	private boolean righthanded = true;
	private Hand hand;
	private DrawMotionModel model;
	
	public void setHand(boolean choice){
		righthanded=choice;
	}
	public void setModel(DrawMotionModel model){
		this.model=model;
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
		int appWidth = 1920;
		int appHeight = 1080;

		InteractionBox iBox = frame.interactionBox();
		Pointable pointable = frame.pointables().frontmost();

		Vector leapPoint = pointable.stabilizedTipPosition();
		Vector normalizedPoint = iBox.normalizePoint(leapPoint, false);

		

		if (!frame.hands().isEmpty()){
			if(righthanded=true)
				hand = frame.hands().rightmost();
			else
				hand=frame.hands().leftmost();
		Finger indexFinger = hand.fingers().fingerType(Finger.Type.TYPE_INDEX).get(0);
		System.out.println(" position:"+indexFinger.tipPosition());
		
		float appX = normalizedPoint.getX() * appWidth;
		float appY = (1 - normalizedPoint.getY()) * appHeight;
		model.setPoint(new Spot((double)appX,(double)appY,3.0));
		}
		if (!frame.hands().isEmpty())
			System.out.print("");
		}
	}

