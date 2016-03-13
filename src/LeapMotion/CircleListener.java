package leapmotion;

import java.awt.Color;
import java.awt.Toolkit;

import com.leapmotion.leap.CircleGesture;
import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Finger;
import com.leapmotion.leap.Frame;
import com.leapmotion.leap.Gesture;
import com.leapmotion.leap.Hand;
import com.leapmotion.leap.InteractionBox;
import com.leapmotion.leap.Listener;
import com.leapmotion.leap.Pointable;
import com.leapmotion.leap.Vector;

import gui.DrawMotionModel;
import gui.Spot;

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
		
		int appWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int appHeight = Toolkit.getDefaultToolkit().getScreenSize().height;

		InteractionBox iBox = frame.interactionBox();
		Pointable pointable = frame.pointables().frontmost();

		Vector leapPoint = pointable.stabilizedTipPosition();
		Vector normalizedPoint = iBox.normalizePoint(leapPoint, false);
		
		Finger thumbFinger = hand.fingers().fingerType(Finger.Type.TYPE_THUMB).get(0);
		if (thumbFinger.tipPosition().getZ() < -80) {
			if (gesture.type().equals(Gesture.Type.TYPE_CIRCLE)) {
				CircleGesture circle = new CircleGesture(gesture);
				if (circle.pointable().direction().angleTo(circle.normal()) <= Math.PI / 2) {
					model.setClearValue(true);
				} 
			}
		}
//		else if(thumbFinger.tipPosition().getZ() > 80){
//			float appX = normalizedPoint.getX() * appWidth;
//			float appY = (1 - normalizedPoint.getY()) * appHeight;
//			model.setColor(Color.WHITE);
//			model.setPoint(new Spot((double) appX, (double) appY, 15.0));
//		}
	}
}
