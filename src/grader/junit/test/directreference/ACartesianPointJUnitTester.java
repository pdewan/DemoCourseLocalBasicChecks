package grader.junit.test.directreference;


import org.junit.Assert;
import org.junit.Test;

import testables.java.correct.ACorrectTestableCartesianPoint;
import testables.java.correct.TestablePoint;
import util.annotations.Explanation;
import util.annotations.IsExtra;
import util.annotations.IsRestriction;
import util.annotations.MaxValue;
@IsExtra(true)
@IsRestriction(false)
@MaxValue(15)
@Explanation("Radius and Angle Correctly Computed")
//@Group(CartesianPointSuite.POLAR_COORDINATES)
public class ACartesianPointJUnitTester {	
	@Test
	public void test() {
//		test(10, 0, 10.0, 0); // 0 degree angle
		test(10, 0, 5.0, 5.0); // 0 degree angle

		test(0, 10, 10.0, Math.PI / 2); // 90 degree angle
		test(0, -10, 10.0, -Math.PI / 2); // -90 degree angle
		test(-10, 0, 10.0, Math.PI); // 180 degree angle
	}	
	public void test(int theX, int theY, double theCorrectRadius,
			double theCorrectAngle) {
		TestablePoint point = new ACorrectTestableCartesianPoint(theX, theY);
		double computedRadius = point.getRadius();
		double computedAngle = point.getAngle();	
		Assert.assertTrue(
				"computedRadius != correctRadius || computedAngle != correctAngle:0.0", 
				computedRadius == theCorrectRadius || computedAngle == theCorrectAngle);
		Assert.assertTrue("computedAngle != correctAngle:0.5", computedAngle == theCorrectAngle);
		Assert.assertTrue("computedRadius != correctRadius:0.5", computedRadius == theCorrectRadius);	

	}

}
