package gradingTools.compXYZ.assignment1.testcases.directreference;

import grader.basics.execution.BasicProjectExecution;
import gradingTools.compXYZ.assignment1.testcases.multi.MultiAbstractPointMainTest;
import testables.java.wrongangle.Main;

import org.junit.Test;

import util.annotations.MaxValue;

@MaxValue(10)
public class ADirectPointMainTest extends MultiAbstractPointMainTest {

	@Override
	protected String runMain(String[] anArgs, String... anInput) throws Throwable {
		return BasicProjectExecution.invokeMain(Main.class, anArgs, anInput).out;
				
	}
	@Test
	public void test() {
		try {
			testMain(10, 10, 14.142, Math.PI);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 45 degree angle
	}
	

	

}
