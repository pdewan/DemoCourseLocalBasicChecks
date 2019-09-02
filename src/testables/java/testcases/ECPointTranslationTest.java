package testables.java.testcases;

import grader.basics.junit.BasicJUnitUtils;
import testables.java.correct.TestablePoint;

import org.junit.Assert;
import org.junit.Test;

public class ECPointTranslationTest extends ECAbstractPointTest{

	@Override
	protected void checkComputations(double aComputedAngle,
			double aComputedRadius, double aCorrectAngle, double aCorrectRadius) {
		// TODO Auto-generated method stub
		
	}
	// all or nothing
	@Test
	public void test() {
		try {
			
			createPoint(5, 10);
			TestablePoint retVal = point.translate(5, 10);
			int actualX = retVal.getX();
			int actualY = retVal.getY();
			Assert.assertTrue(
					"X property " +  actualX +  " is not equal to 10 or " +						
					"Y property " + actualY + " is not equal to 20 ",					
					actualX == 10 && actualY == 20) ;
		} catch (Exception e) {
			BasicJUnitUtils.assertTrue(e, fractionComplete);
		}
	}

}
