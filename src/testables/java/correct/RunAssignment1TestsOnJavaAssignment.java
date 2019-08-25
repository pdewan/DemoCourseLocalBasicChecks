package testables.java.correct;

import gradingTools.compXYZ.assignment1.testcases.CartesianPointSuite;
import gradingTools.interpreter.AnInterpretingGradableJUnitTest;
import gradingTools.interpreter.AnInterpretingGradableJUnitTopLevelSuite;
import util.trace.Tracer;

public class RunAssignment1TestsOnJavaAssignment {
	public static void main(String[] args) {
		Tracer.showInfo(true);
//		CartesianPointSuite.main(args);
		AnInterpretingGradableJUnitTopLevelSuite.main(args);
	}

}
