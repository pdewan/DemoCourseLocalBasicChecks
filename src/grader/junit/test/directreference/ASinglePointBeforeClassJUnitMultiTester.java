package grader.junit.test.directreference;


import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import testables.java.correct.ACorrectTestableCartesianPoint;
import testables.java.correct.TestablePoint;

public class ASinglePointBeforeClassJUnitMultiTester {	
	static TestablePoint point;
	@BeforeClass
	public static void createPoint() {
		System.out.println("Testing 10, 10");
		point = new ACorrectTestableCartesianPoint(10, 10);
	}
	
	@Test
	public void testAngle() {
		double computedAngle = point.getAngle();	
		Assert.assertTrue(computedAngle == Math.PI/4);

	}
	@Test
	public void testRadius() {
		double computedRadius = point.getRadius();
		Assert.assertTrue(computedRadius == Math.sqrt(200));
		
	}
	

}
