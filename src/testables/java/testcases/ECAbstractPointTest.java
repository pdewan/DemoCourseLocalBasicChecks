package testables.java.testcases;

import grader.basics.junit.BasicJUnitUtils;
import grader.basics.junit.NotesAndScore;
import grader.basics.project.BasicProjectIntrospection;
import testables.java.correct.TestablePoint;

import org.junit.Assert;

public abstract class ECAbstractPointTest {

	public static final String ANGLE_TESTS = "Angle Tests";
	boolean checkStructure;

	TestablePoint point;
	double fractionComplete = 0.0;

	protected void assertAngle(double aComputed, double aCorrect) {
		Assert.assertTrue("computedAngle " + aComputed + " != correctAngle " + aCorrect + NotesAndScore.PERCENTAGE_MARKER + fractionComplete, Math.abs(aComputed - aCorrect) < 0.1);

	}
	protected void assertRadius(double aComputed, double aCorrect) {
		Assert.assertTrue("computedRadius " + aComputed + " != correctRadius " + aCorrect + NotesAndScore.PERCENTAGE_MARKER + fractionComplete, Math.abs(aComputed - aCorrect) < 0.1);
	}
	protected abstract void checkComputations (double aComputedAngle, double aComputedRadius, double aCorrectAngle, double aCorrectRadius) ;
	public void createPoint(int theX, int theY) {
		point = (TestablePoint) BasicProjectIntrospection.createInstance(
				TestablePoint.class, new Object[] { theX, theY});
	}
	public void test(int theX, int theY, double aCorrectRadius,
			double aCorrectAngle) {
		try {
//			point = (ACreditPoint) BasicProjectIntrospection.createInstance(
//					ECreditPoint.class, new Object[] { theX, theY});
			createPoint(theX, theY);
			double aComputedRadius =  point.getRadius();
			double aComputedAngle = point.getAngle();
			checkComputations(aComputedAngle, aComputedRadius, aCorrectAngle, aCorrectRadius);		

		} catch (Exception e) {
			BasicJUnitUtils.assertTrue(e, fractionComplete);
		}
	}
}
