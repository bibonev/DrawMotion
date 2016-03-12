package gui;

import java.util.ArrayList;
import java.util.Observable;

public class DrawMotionModel extends Observable {
	
	private DrawMotion drawMotion;

	public DrawMotionModel(DrawMotion drawMotion){
		super();
		this.drawMotion = drawMotion;
	}
	
	public ArrayList<Spot> getArrayPoints(){
		return drawMotion.getArrayPoints();
	}
	
	public void addPoint(Spot point){
		drawMotion.addPoint(point);
		setChanged();
		notifyObservers();
	}
	
	public void clear(){
		drawMotion.clear();
		setChanged();
		notifyObservers();
	}
	
}
