package testables.java.testcases;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//@RunWith(Suite.class)
@RunWith(Suite.class)
@Suite.SuiteClasses({
   ECPointAngleSuite.class,
//   APointAngleZeroDegreeTest.class,
//   APointAngleNinetyDegreeTest.class,
//   APointAngleFortyFiveDegreeTest.class,
//   APointAngleMinusNinetyDegreeTest.class,
   ECPointRadiusTest.class,
   ECPointMainTest.class,
   ECPointPrintTest.class
   
})
public class ECCartesianPointSuite {
//	public static final String ANGLE_TESTS = "Angle Tests";

	

}

