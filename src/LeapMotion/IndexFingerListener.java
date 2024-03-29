package leapmotion;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import com.leapmotion.leap.CircleGesture;
import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Finger;
import com.leapmotion.leap.Frame;
import com.leapmotion.leap.Gesture;
import com.leapmotion.leap.Hand;
import com.leapmotion.leap.InteractionBox;
import com.leapmotion.leap.Listener;
import com.leapmotion.leap.Pointable;
import com.leapmotion.leap.SwipeGesture;
import com.leapmotion.leap.Vector;

import gui.DrawMotionModel;
import gui.Spot;

class IndexFingerListener extends Listener {
	private Hand hand;
	private DrawMotionModel model;
	private ArrayList<Color> colors = new ArrayList<Color>();
	private int i = 2;
	private Color currentColor = Color.BLACK;

	public IndexFingerListener(DrawMotionModel model) {
		this.model = model;
		colors.add(Color.WHITE);
		colors.add(Color.GRAY);
		colors.add(Color.BLACK);
		colors.add(Color.RED);
		colors.add(Color.ORANGE);
		colors.add(Color.YELLOW);
		colors.add(Color.GREEN);
		colors.add(Color.CYAN);
		colors.add(Color.BLUE);
		colors.add(Color.PINK);

	}

	public void onInit(Controller controller) {
		System.out.println("IndexFingerListener Initialized");
	}

	public void onConnect(Controller controller) {
		System.out.println("IndexFingerListener Connected");
		//controller.enableGesture(Gesture.Type.TYPE_CIRCLE);
		controller.enableGesture(Gesture.Type.TYPE_SWIPE);
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
		int appWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int appHeight = Toolkit.getDefaultToolkit().getScreenSize().height;

		InteractionBox iBox = frame.interactionBox();
		Pointable pointable = frame.pointables().frontmost();

		Vector leapPoint = pointable.stabilizedTipPosition();
		Vector normalizedPoint = iBox.normalizePoint(leapPoint, false);

		hand = frame.hands().rightmost();
		
		if (!frame.hands().isEmpty()) {
			Finger indexFinger = hand.fingers().fingerType(Finger.Type.TYPE_INDEX).get(0);
			Gesture gesture = frame.gestures().get(0);
			
			if (indexFinger.tipPosition().getZ() >= -70 && indexFinger.tipPosition().getZ() <= 70) {
				float appX = normalizedPoint.getX() * appWidth;
				float appY = (1 - normalizedPoint.getY()) * appHeight;
				model.setColor(currentColor);
				model.setPoint(new Spot((double) appX, (double) appY, 3.0));
			}else if(indexFinger.tipPosition().getZ() > 70) {
					if (gesture.type().equals(Gesture.Type.TYPE_SWIPE)) {
						SwipeGesture swipe = new SwipeGesture(gesture);
						boolean isHorizontal = Math.abs(swipe.direction().get(0)) > Math.abs(swipe.direction().get(1));
						// Classify as right-left or up-down
						if (isHorizontal) {
							if (swipe.direction().get(0) > 0) {
								if (i == 0)
									i = 9;
								else
									i--;
							} else {
								if (i == 9)
									i = 0;
								else
									i++;

							}
							currentColor = colors.get(i % 9);
							model.setColor(currentColor);
							// System.out.println(i+ "");
						} else { // vertical
							if (swipe.direction().get(1) > 0) {
								try {
									Robot robot = new Robot();
									Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
									BufferedImage capture = robot.createScreenCapture(screenRect);
									ImageIO.write(capture, "jpeg", new File("C:/Users/User/Desktop/Work/Workshop/Eclipse/MotionDraw/MotionDrawSaves/MotionDraw1.jpeg"));
								} catch (Exception exception) {

								}
							} else {
								System.exit(0);
							}
						}
					}
				}
			else if(indexFinger.tipPosition().getZ() < -70){
				float appX = normalizedPoint.getX() * appWidth;
				float appY = (1 - normalizedPoint.getY()) * appHeight;
				model.setColor(Color.WHITE);
				model.setPoint(new Spot((double) appX, (double) appY, 15.0));
			}
			}
		if(!frame.hands().isEmpty())System.out.print("");
}}