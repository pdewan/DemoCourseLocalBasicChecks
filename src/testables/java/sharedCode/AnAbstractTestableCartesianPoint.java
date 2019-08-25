package testables.java.sharedCode;

import util.annotations.Explanation;
import util.annotations.Tags;

import java.util.Scanner;

import bus.uigen.ObjectEditor;
import testables.java.correct.TestablePoint;
public abstract class AnAbstractTestableCartesianPoint {	
	static Scanner scanner = new Scanner(System.in);
	protected int x, y;
	public AnAbstractTestableCartesianPoint(int theX, int theY) {
		x = theX;
		y = theY;
	}
	public AnAbstractTestableCartesianPoint(double theRadius, double theAngle) {
		x =  (int) (theRadius*Math.cos(theAngle));
		y = (int) (theRadius*Math.sin(theAngle));
	}
	public int getX() { return x; }
	public int getY() { return y; } 	
	public double getAngle() { 
		return Math.atan2(y, x); 
	}
	@Tags({"radius", "getter"})	
	public double getRadius() { 
		return Math.sqrt(x*x + y*y); 
	}
	public void print () {
		System.out.println ("X: " + x + " Y:" + y);
	}
	public static int inputX() {
		System.out.println("Please enter the X coordinate:");
		return 0;
		
	}
}
