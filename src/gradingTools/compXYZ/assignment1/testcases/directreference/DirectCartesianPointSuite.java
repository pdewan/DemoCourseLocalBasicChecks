package gradingTools.compXYZ.assignment1.testcases.directreference;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;

import gradingTools.compXYZ.assignment1.testcases.multi.MultiPointAngleSuite;
import gradingTools.compXYZ.assignment1.testcases.multi.MultiPointProxyFactory;
import gradingTools.compXYZ.assignment1.testcases.multi.MultiPointRadiusTest;

//@RunWith(Suite.class)
@RunWith(Suite.class)
@Suite.SuiteClasses({
   ADirectPointMainTest.class,
   ADirectPointProxy.class,
   MultiPointAngleSuite.class,
//   APointAngleZeroDegreeTest.class,
//   APointAngleNinetyDegreeTest.class,
//   APointAngleFortyFiveDegreeTest.class,
//   APointAngleMinusNinetyDegreeTest.class,
   MultiPointRadiusTest.class,
   
})
public class DirectCartesianPointSuite {
//	public static final String ANGLE_TESTS = "Angle Tests";

	public static void main (String[] args) {
		MultiPointProxyFactory.setPointProxy(new ADirectPointProxy());
		Result aResult = JUnitCore.runClasses(DirectCartesianPointSuite.class);
		
		for (Failure failure : aResult.getFailures()) {
	         System.err.println("Failed Test:" + failure.toString());
	    }
	    System.out.println(aResult.wasSuccessful());
	    System.exit(0);
	}
	

}

