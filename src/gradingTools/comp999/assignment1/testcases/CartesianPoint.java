package gradingTools.comp999.assignment1.testcases;

import util.annotations.Explanation;
import util.annotations.Tags;
import bus.uigen.ObjectEditor;
@Explanation("Uses Cartesian representation.")
@Tags({"cartesian", "point"})
public class CartesianPoint implements Point {	
	protected int x, y;
	public CartesianPoint(int theX, int theY) {
		x = theX;
		y = theY;
	}
	public CartesianPoint(double theRadius, double theAngle) {
		x =  (int) (theRadius*Math.cos(theAngle));
		y = (int) (theRadius*Math.sin(theAngle));
	}
	public int getX() { return x; }
	public int getY() { return y; } 	
	public double getAngle() { 
		return Math.atan2(y, x); 
//		return 0;
	}
	@Tags({"radius", "getter"})	
	public double getRadius() { 
		return Math.sqrt(x*x + y*y); 
//		return 0;
	}
//	@Override
//	public void print (String aString, ECPoint aPoint) {
//		System.out.println (aString + aPoint.getX() + " " + aPoint.getY());
//	}
	@Override
	public void print () {
		System.out.println ("(" + x + "," + y + ")");
	}
	public Point translate (int anXDelta, int aYDelta) {
		return new CartesianPoint (getX() + anXDelta, getY() + aYDelta);
	}
	public static void main(String args[]) {
		Point point =  new CartesianPoint (50, 100);
		ObjectEditor.edit(point);
		point = new CartesianPoint(100, Math.PI/4);
		ObjectEditor.edit(point);
//		
	}
}
