package gui;

import java.util.ArrayList;

public class DrawMotion {

	private ArrayList<Spot> drawnPoints;
	
	public DrawMotion(){
		drawnPoints = new ArrayList<Spot>();
	}
	
	public ArrayList<Spot> getArrayPoints(){
		return drawnPoints;
	}
	
	public void addPoint(Spot point){
		drawnPoints.add(point);
	}
	
	public void clear(){
		drawnPoints.clear();
	}
	
}
