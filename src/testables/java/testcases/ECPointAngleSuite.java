package testables.java.testcases;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import util.annotations.Tags;
@Tags({"AngleTest"})
@RunWith(Suite.class)
@Suite.SuiteClasses({

   ECPointAngleZeroDegreeTest.class,
   ECPointAngleNinetyDegreeTest.class,
   ECPointAngleFortyFiveDegreeTest.class,
   ECPointAngleMinusNinetyDegreeTest.class,

   
})
public class ECPointAngleSuite {


}

