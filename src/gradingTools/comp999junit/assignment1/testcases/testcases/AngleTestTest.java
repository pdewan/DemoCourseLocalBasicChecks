package gradingTools.comp999junit.assignment1.testcases.testcases;
import grader.basics.junit.BasicJUnitUtils;
import grader.basics.junit.GradableJUnitTest;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.BasicProject;
import grader.basics.project.CurrentProjectHolder;
import grader.basics.project.Project;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;
public class AngleTestTest {
	@Test()
	public void Test() {
		Project aGradedProject = CurrentProjectHolder.getOrCreateCurrentProject(); // there should be something assigned
		double aFractionComplete = 0.0;
		try {
		String aKey = "AngleTest";
		GradableJUnitTest aTest = BasicJUnitUtils.createGradable("AngleTest");
//		GradableJUnitTest aCorrectAngleTest = BasicJUnitUtils.createGradable("AngleTest");
//		GradableJUnitTest aWrongAngleTest = BasicJUnitUtils.createGradable("AngleTest");
		Assert.assertTrue("Could not find class matching " + aKey, aTest != null);
		aFractionComplete += 0.1; // they had a test class at least
//		Project aWrongAngleProject = new BasicProject("wrongangle");
//		Project aCorrectAngleProject = new BasicProject("allcorrect");
		CurrentProjectHolder.setProject("allcorrect");
		TestCaseResult aCorrectAngleResult = aTest.test();
//		TestCaseResult aCorrectAngleResult = aCorrectAngleTest.test();
		CurrentProjectHolder.setProject("wrongangle");

		TestCaseResult aWrongAngleResult = aTest.test();
//		TestCaseResult aWrongAngleResult = aWrongAngleTest.test();

		Assert.assertTrue("Correct angle failed and wrong angle passed:" + aFractionComplete, aCorrectAngleResult.isPass() || aWrongAngleResult.isFail());
		aFractionComplete = 0.4;
		Assert.assertTrue("Correct angle failed and wrong angle failed:" + aFractionComplete, aCorrectAngleResult.isPass());
		Assert.assertTrue("Wrong angle passed:" + aFractionComplete, !aWrongAngleResult.isPass());
		aFractionComplete = 1.0;

		} catch (Exception e) {
			BasicJUnitUtils.assertTrue(e, aFractionComplete);
		} finally {
			CurrentProjectHolder.setProject(aGradedProject);

		}
		
	}

}
