package gradingTools.comp110.assignment1.addmultiply.testcases;

import java.util.regex.Pattern;

import grader.basics.execution.NotRunnableException;
import grader.basics.execution.RunningProject;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import grader.basics.testcase.PassFailJUnitTestCase;
import gradingTools.utils.RunningProjectUtils;

public class PrintAddAndMultiplyTestCase extends PassFailJUnitTestCase {

	public PrintAddAndMultiplyTestCase() {
//		super("Add and Multiply Test Case");
	}

	public String getOutput(Project project, String input1, String input2)
			throws NotRunnableException {

		// Get the output when we have integer input from the user
		RunningProject oneInputRunningProject = RunningProjectUtils.runProject(project, 1, input1);
		String oneInputOutput = oneInputRunningProject.await();

		// Get the output when we have double input from the user
		// chnaged the timeout as a test case failed in the distriuted case
		RunningProject twoInputsRunningProject = RunningProjectUtils.runProject(project, 6, input1,
				input2);
		String twoInputsOutput = twoInputsRunningProject.await();
		twoInputsOutput = twoInputsOutput.substring(oneInputOutput.length());

		if (twoInputsOutput.length() == 0
				&& (oneInputRunningProject.getErrorOutput().contains("InputMismatchException") || twoInputsRunningProject
						.getErrorOutput().contains("InputMismatchException"))) {
			return null;
		}
		return twoInputsOutput;
	}

	@Override
	public TestCaseResult test(Project project, boolean autoGrade) throws NotAutomatableException,
			NotGradableException {
		try {

			String integerInput = "4";
			String doubleInput = "5.213025";

			String integerAddResultREGEX = "[^\\d]9[^\\d.]";
			String doubleAddResultREGEX = "[^\\d]9.213025[^\\d.]";

			String integerMultiplyResultREGEX = "[^\\d]20[^\\d.]";
			String doubleMultiplyResultREGEX = "[^\\d]20.8521[^\\d.]";

			// Try getting the results with integer, then double
			String output = getOutput(project, integerInput, doubleInput);

			// If that is null, get reverse the order of the inputs
			if (output == null) {
				output = getOutput(project, doubleInput, integerInput);
			}

			if (output == null) {
				throw new NotAutomatableException();
			}

			// Check for the expected results
			boolean hasIntegerAdd = Pattern.compile(integerAddResultREGEX).matcher(output).find();
			boolean hasDoubleAdd = Pattern.compile(doubleAddResultREGEX).matcher(output).find();
			boolean hasIntegerMultiply = Pattern.compile(integerMultiplyResultREGEX)
					.matcher(output).find();
			boolean hasDoubleMultiply = Pattern.compile(doubleMultiplyResultREGEX).matcher(output)
					.find();

			if (hasIntegerAdd && hasDoubleAdd && hasIntegerMultiply && hasDoubleMultiply) {
				return pass();
			} else {
				String message = "";
				double score = 1.0;

				if (!hasIntegerAdd) {
					message += "Does not output the correct integer sum of the numbers\n";
					score -= 0.25;
				}
				if (!hasDoubleAdd) {
					message += "Does not output the correct double sum of the numbers\n";
					score -= 0.25;
				}
				if (!hasIntegerMultiply) {
					message += "Does not output the correct integer product of the numbers\n";
					score -= 0.25;
				}
				if (!hasDoubleMultiply) {
					message += "Does not output the correct double product of the numbers\n";
					score -= 0.25;
				}

				return partialPass(score, message);
			}

		} catch (NotRunnableException e) {
			throw new NotGradableException();
		}
	}
}
