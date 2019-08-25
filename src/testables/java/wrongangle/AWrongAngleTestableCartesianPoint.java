package testables.java.wrongangle;

import testables.java.sharedCode.AnAbstractTestableCartesianPoint;
import util.annotations.Explanation;
@Explanation("Uses Cartesian representation.")
//@Tags({"cartesian", "point"})
public class AWrongAngleTestableCartesianPoint extends AnAbstractTestableCartesianPoint
	{	
//	protected int x, y;
	public AWrongAngleTestableCartesianPoint(int theX, int theY) {
		super(theX, theY);
	}
	
//	public int getX() { return x; }
//	public int getY() { return y; } 	
	public double getAngle() { 
//		return Math.atan2(y, x); 
		return 0;
	}
//	public double getRadius() { 
//		return Math.sqrt(x*x + y*y); 
////		return 0;
//	}	
//	@Override
//	public void print (WAPoint aPoint, String aString) {
//		System.out.println (aString + aPoint.getX() + " " + aPoint.getY());
//	}
//	public void print () {
//		System.out.println ("X: " + x + " Y:" + y);
//	}
	// cannot make argumenyt WAPoint!
	// changed the name from translate to move, changed the order of parameters
	public AWrongAngleTestableCartesianPoint move (int anXDelta, int aYDelta, AWrongAngleTestableCartesianPoint aPoint) {
		return new AWrongAngleTestableCartesianPoint(aPoint.getX() + anXDelta, aPoint.getY() + aYDelta);
	}
	
}
