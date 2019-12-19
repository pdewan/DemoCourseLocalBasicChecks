package gradingTools.comp123.assignment1.openmp.testcases;

import gradingTools.shared.testcases.ASubstringSequenceChecker;

public class ASequentialSumChecker extends ASubstringSequenceChecker{
	//make sure receives from both clients take place, need to ensure alternatibg, cannot with regular expressions
	public  final String[] MY_SUBSTRINGS = {
			toRegex("sum_sequential"),
			toRegex("499500"),
			toRegex("Took"),
			toRegex("thread"),

		
	};
	public ASequentialSumChecker() {
		init( MY_SUBSTRINGS);
	}
	

}
