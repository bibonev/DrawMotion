package gui;

import java.awt.geom.Ellipse2D;

public class Spot extends Ellipse2D.Double {
	private double radius;
	public Spot(double x, double y, double r) {
		super(x-r, y-r, 2*r, 2*r);
		radius=r;
		
	}
	public double getRadius(){
		return radius;
	}
}