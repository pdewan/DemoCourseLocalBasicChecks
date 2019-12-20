package gradingTools.addMultiply;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.config.BasicStaticConfigurationUtils;
import grader.basics.junit.BasicJUnitUtils;
import grader.basics.project.BasicProjectIntrospection;
import gradingTools.comp110.assignment1.addmultiply.testcases.CustomCommandIncrementalPromptTestCase;
import gradingTools.comp110.assignment1.addmultiply.testcases.CustomCommandPromptTestCase;
import gradingTools.comp110.assignment1.addmultiply.testcases.IncrementalInputPromptTestCase;
import gradingTools.comp110.assignment1.addmultiply.testcases.PledgeTestCase;
import gradingTools.comp110.assignment1.addmultiply.testcases.PrintAddAndMultiplyTestCase;
import gradingTools.comp110.assignment1.addmultiply.testcases.PromptTestCase;


@RunWith(Suite.class)
@Suite.SuiteClasses({
//	PromptTestCase.class,	
//	PrintAddAndMultiplyTestCase.class
	PromptTestCase.class,
	IncrementalInputPromptTestCase.class,
	CustomCommandPromptTestCase.class,
	CustomCommandIncrementalPromptTestCase.class,
	PledgeTestCase.class
	
})
	

//@MaxValue(50)
public class AddMultiplySuite {

	public static void main (String[] args) {
		try {
//			setProcessTimeOut(25);
//			BasicStaticConfigurationUtils.setUseProjectConfiguration(true);
			BasicStaticConfigurationUtils.setModule("SampleCourse");
			BasicStaticConfigurationUtils.setProblem("AssignmentAddMultiply");
//			BasicStaticConfigurationUtils.setModuleProblemAndTest(Assignment1Suite.class);
			BasicJUnitUtils.interactiveTest(AddMultiplySuite.class);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	static {
		BasicProjectIntrospection.setCheckAllSpecifiedTags(true);
		BasicStaticConfigurationUtils.setUseProjectConfiguration(true);



	}
}
