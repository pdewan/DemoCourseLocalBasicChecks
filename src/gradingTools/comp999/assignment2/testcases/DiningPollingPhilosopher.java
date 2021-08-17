package gradingTools.comp999.assignment2.testcases;

public class DiningPollingPhilosopher extends DiningExclusiveChopstick {
	public static final int MAX_SOURCE_MATCHES = Integer.MAX_VALUE;
	protected int minSourceExpectedMatches(int aNumPhilosophers, long aTimeToEat) {
		return DiningSequentialEating.MIN_SOURCE_MATCHES;
	}
	protected int maxSourceExpectedMatches(int aNumPhilosophers, long aTimeToEat) {
		return MAX_SOURCE_MATCHES;
	}
	@Override
	protected String[][] expectedThreadChanges() {
		return DiningSequentialEating.EXPECTED_THREAD_CHANGES;
	}
}
