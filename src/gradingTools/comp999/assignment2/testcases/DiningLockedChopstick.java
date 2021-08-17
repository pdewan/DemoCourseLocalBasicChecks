package gradingTools.comp999.assignment2.testcases;

import gradingTools.shared.testcases.concurrency.propertyChanges.ConcurrentEventUtility;

public class DiningLockedChopstick extends DiningExclusiveChopstick {   

    public static final String[][] EXPECTED_CHOPSTICK_CHANGES = {
    		{".*", "Chopstick.*", "Used", "false", "true"},
    		{".*", "Chopstick.*", "Used", "true", "false"},
    };
    public static final String[][] UNEXPECTED_CHOPSTICK_CHANGES = {
    		{".*Philosopher.*", "Chopstick.*", "Used", "true", "true"},
    }; 
    public static final String[][] EXPECTED_THREAD_CHANGES = {
    		{".*", "Philosopher.*", "Fed", ".*", "false"},
    		
    		{".*", "Chopstick.*", "Used", "false", "true"},
    		{".*", "Philosopher.*", "With.*Chopstick", "false", "true"},
    };
	protected String[][] expectedThreadChanges() {
		return EXPECTED_THREAD_CHANGES;
	}
	protected String[][] expectedSourceChanges() {
		return EXPECTED_CHOPSTICK_CHANGES;
	}
	protected String[][] unexpectedSourceChanges() {
		return UNEXPECTED_CHOPSTICK_CHANGES;
	}
	protected boolean checkUnexpectedSourceChanges(int aNumPhilosophers, long aTimeToEat) {
		boolean aMatchOccurred = ConcurrentEventUtility.matchesEachSource(concurrentPropertyChanges, unexpectedSourceChanges(),  1, aNumPhilosophers, CHOPSTICK_PATTERN);
	    if (aMatchOccurred) {
	    	System.err.println("Unexpected source pattern occured for one or more sources");
	    }
	    return !aMatchOccurred;	
	}
	 protected boolean checkEvents( int aNumPhilosophers, long aTimeToEat) {

			boolean aSuperResult = super.checkEvents(aNumPhilosophers, aTimeToEat);
			boolean anUnexpectedSourceChanges = checkUnexpectedSourceChanges(aNumPhilosophers, aTimeToEat);
		 	 	
			return aSuperResult && anUnexpectedSourceChanges;
	 }
}
