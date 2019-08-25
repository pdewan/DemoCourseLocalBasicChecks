package testables.java.correct;

import util.annotations.Explanation;
import util.annotations.Tags;
import bus.uigen.ObjectEditor;
import testables.java.sharedCode.AnAbstractTestableCartesianPoint;
@Explanation("Uses Cartesian representation.")
@Tags({"cartesian", "point"})
public class ACorrectTestableCartesianPoint extends AnAbstractTestableCartesianPoint implements TestablePoint {	
	public ACorrectTestableCartesianPoint(int theX, int theY) {
		super(theX, theY);
	}
	public ACorrectTestableCartesianPoint(double theRadius, double theAngle) {
		super(theRadius, theAngle);
	}
	@Override
	public TestablePoint translate (TestablePoint aPoint, int anXDelta, int aYDelta) {
		return new ACorrectTestableCartesianPoint (aPoint.getX() + anXDelta, aPoint.getY() + aYDelta);
	}
	public static void main(String args[]) {
		TestablePoint point =  new ACorrectTestableCartesianPoint (50, 100);
		point = new ACorrectTestableCartesianPoint(100, Math.PI/4);	
	}
}
