package gradingTools.comp110.assignment1.addmultiply.testcases;

import util.pipe.InputGenerator;

public interface OutputBasedMixedArithmeticInputGenerator extends InputGenerator{
	 boolean foundIntPrompt();
	 boolean foundDoublePrompt();
	boolean foundOutput();

}
