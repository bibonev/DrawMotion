package gui;

import java.util.Observable;

public class DrawMotionModel extends Observable {
	
	//private DrawMotion drawMotion;
	private Spot point;
	public DrawMotionModel(){
		super();
	}
	
	public Spot getPoint(){
		return point;
	}
	
	public void setPoint(Spot point){
		this.point = point;
		setChanged();
		notifyObservers();
	}
	
}
