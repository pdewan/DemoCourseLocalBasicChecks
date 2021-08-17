package gradingTools.comp999.assignment2.testcases;

public class DiningNoDeadlock extends DiningPollingPhilosopher {
	protected int maxSourceExpectedMatches(int aNumPhilosophers, long aTimeToEat) {		 
		 return DiningSequentialEating.MAX_SOURCE_MATCHES;
	 }
}
