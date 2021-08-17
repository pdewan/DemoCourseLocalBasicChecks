package gradingTools.comp999.assignment2.testcases;

public class DiningExclusiveChopstick extends DiningSharedChopstick {
    public static final int MIN_SOURCE_MATCHES = 1;
    public static final String[][] EXPECTED_THREAD_CHANGES = {
    		{".*", "Philosopher.*", "Fed", ".*", "false"},
    		
    		{".*", "Chopstick.*", "Used", ".*", "true"},
    		{".*", "Philosopher.*", "With.*Chopstick", "false", "true"},
    };
	protected String[][] expectedThreadChanges() {
		return EXPECTED_THREAD_CHANGES;
	}
	 protected int minSourceExpectedMatches(int aNumPhilosophers, long aTimeToEat) {
		 return MIN_SOURCE_MATCHES;
	 }
}
