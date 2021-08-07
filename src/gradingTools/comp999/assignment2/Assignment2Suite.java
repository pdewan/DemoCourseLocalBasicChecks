package gradingTools.comp999.assignment2;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.BasicLanguageDependencyManager;
import grader.basics.config.BasicExecutionSpecificationSelector;
import grader.basics.config.BasicStaticConfigurationUtils;
import grader.basics.junit.BasicJUnitUtils;
import grader.basics.project.BasicProjectIntrospection;
import gradingTools.comp110.assignment1.addmultiply.testcases.PrintAddAndMultiplyTestCase;
import gradingTools.comp110.assignment1.addmultiply.testcases.PromptTestCase;
import gradingTools.comp4760.assignment1.openmp.testcases.SequentialSumTestCase;
import gradingTools.comp999.assignment2.testcases.DiningButlerCoordination;
import gradingTools.comp999.assignment2.testcases.DiningNoDeadlock;
import trace.grader.basics.GraderBasicsTraceUtility;
import util.trace.Tracer;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	DiningNoDeadlock.class,
	DiningButlerCoordination.class,	
	
})
	

//@MaxValue(50)
public class Assignment2Suite {

	public static void main (String[] args) {
		try {
//		  Tracer.showInfo(true);
//			GraderBasicsTraceUtility.setBufferTracedMessages(false);
//			BasicExecutionSpecificationSelector.getBasicExecutionSpecification().
//			setStudentGradableProjectLocation("D:\\dewan_backup\\C\\OpenMPTraining");
//			BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setLanguage(BasicLanguageDependencyManager.CPlusPlus_LANGUAGE);
			BasicJUnitUtils.interactiveTest(Assignment2Suite.class);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//	static {
//		BasicProjectIntrospection.setCheckAllSpecifiedTags(true);
//		BasicStaticConfigurationUtils.setUseProjectConfiguration(true);
//
//
//
//	}
}
