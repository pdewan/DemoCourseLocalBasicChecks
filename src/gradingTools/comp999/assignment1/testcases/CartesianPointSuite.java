package gradingTools.comp999.assignment1.testcases;

import grader.basics.junit.BasicJUnitUtils;
import grader.basics.junit.GradableJUnitSuite;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.BasicProject;
import grader.basics.project.CurrentProjectHolder;
import grader.basics.vetoers.AConsentFormVetoer;
import gradingTools.comp999.assignment1.testcases.testcases.TestsTestSuite;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;

import bus.uigen.ObjectEditor;

@RunWith(Suite.class)
@Suite.SuiteClasses({
   PointAngleSuite.class,
   PointRadiusTest.class,
   PointMainTest.class,
   PointPrintTest.class,
   PointTranslationTest.class,
   TestsTestSuite.class
   
})
public class CartesianPointSuite {
//	public static final String ANGLE_TESTS = "Angle Tests";

	public static void main (String[] args) {
		try {

//		BasicJUnitUtils.interactiveTestAll("wrongangle", CartesianPointSuite.class);
//		BasicJUnitUtils.interactiveTest("allcorrect", CartesianPointSuite.class);
		BasicJUnitUtils.interactiveTest("wrongangle", CartesianPointSuite.class);
//		BasicJUnitUtils.interactiveTest("aecredit", CartesianPointSuite.class);

//		BasicJUnitUtils.interactiveTest("nonexisting", CartesianPointSuite.class);



		} catch (Exception e) {
			e.printStackTrace();
		}
//		System.exit(0); // proxy makes the main hang around?
	}

}

