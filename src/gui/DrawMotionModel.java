package gui;

import java.awt.Color;
import java.util.Observable;

public class DrawMotionModel extends Observable {
	
	//private DrawMotion drawMotion;
	private Spot point;
	private Color color = Color.BLACK;
	private boolean clearValue = false;
	
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
	public void setColor(Color c){
		color=c;
		setChanged();
		notifyObservers();
	}
	public Color getColor(){
		return color;
	}

	public boolean isClearValue() {
		return clearValue;
	}

	public void setClearValue(boolean clearValue) {
		this.clearValue = clearValue;
	}
}
