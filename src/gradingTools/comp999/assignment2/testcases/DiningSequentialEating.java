package gradingTools.comp999.assignment2.testcases;

import java.util.Arrays;

import grader.basics.concurrency.propertyChanges.BasicConcurrentPropertyChangeSupport;
import grader.basics.concurrency.propertyChanges.ConcurrentEventUtility;
import grader.basics.concurrency.propertyChanges.ConcurrentPropertyChange;
import grader.basics.concurrency.propertyChanges.ConcurrentPropertyChangeSupport;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import grader.basics.testcase.PassFailJUnitTestCase;
import gradingTools.comp999.assignment2.DiningTestUtil;

public class DiningSequentialEating extends PassFailJUnitTestCase {
    
    public static final int NUM_CHOPSTICKS_FOR_EATING = 2;
	protected static final int[] NUM_PHILOSOPHERS_LIST = {2, 3, 5};;
    protected static final long[] EAT_TIME_LIST =  {200, 300, 100};
    public static final int MAX_SOURCE_MATCHES = 2;
	public static final int MIN_SOURCE_MATCHES = 2;

    public static final String CHOPSTICK_PATTERN = "Chopstick.*";

    public static final String[][] EXPECTED_CHOPSTICK_CHANGES = {
    		{".*", CHOPSTICK_PATTERN, "Used", "false", "true"},
    		{".*", CHOPSTICK_PATTERN, "Used", "true", "false"},
    };    
    
    public static final String[][] EXPECTED_THREAD_CHANGES = {
    		{".*", "Philosopher.*", "Fed", ".*", "false"},
    		
    		{".*", "Chopstick.*", "Used", "false", "true"},
    		{".*", "Philosopher.*", "With.*Chopstick", "false", "true"},
    		{".*", "Chopstick.*", "Used", "false", "true"},
    		{".*", "Philosopher.*", "With.*Chopstick", "false", "true"},
    		    		
    		{".*", "Chopstick.*", "Used", "true", "false"},
    		{".*", "Philosopher.*", "With.*Chopstick", "true", "false"},
    		{".*", "Chopstick.*", "Used", "true", "false"},
    		{".*", "Philosopher.*", "With.*Chopstick", "true", "false"},
    		
    		{".*", "Philosopher.*", "Fed", "false", "true"},

    };
    protected ConcurrentPropertyChangeSupport concurrentPropertyChangeSupport = new BasicConcurrentPropertyChangeSupport();
	protected boolean interleavingOccuredInSomeTest = false;
	protected String[][] expectedThreadChanges() {
		return EXPECTED_THREAD_CHANGES;
	}
	protected String[][] expectedSourceChanges() {
		return EXPECTED_CHOPSTICK_CHANGES;
	}
	protected int[] numPhilosophersList() {
		return NUM_PHILOSOPHERS_LIST;
	}
	protected long[] eatTimeList() {
		return EAT_TIME_LIST;
	}
    @Override
	public TestCaseResult test(Project project, boolean autoGrade)
			throws NotAutomatableException, NotGradableException {
    	boolean anEachRunWasSuccessful = testDifferentParameters();
    	if (!anEachRunWasSuccessful) {
			return fail("Please see console messages");
    	}
    	return pass();
	}        
    protected boolean testDifferentParameters() {
    	int[] aNumPhilosophersList = numPhilosophersList();
    	long[] anEatTimesList = eatTimeList();
		for (int aTestIndex = 0; aTestIndex < aNumPhilosophersList.length; aTestIndex++) {
			boolean aResult = test(aNumPhilosophersList[aTestIndex], anEatTimesList[aTestIndex] );

			if (!aResult) {
				return false;
			}
		}
		return true;
    }
    protected void waitForEvents(int aNumPhilosophers, long aTimeToEat) {

    }
    protected long newCourseInvocationTime(int aNumPhilosophers, long aTimeToEat) {
    	return  DiningTestUtil.maximumCourseEatingTime(
				aNumPhilosophers, aTimeToEat);
    }
    protected void startEvents(int aNumPhilosophers, long aTimeToEat) {
    	concurrentPropertyChangeSupport.resetConcurrentEvents();
    	long aMaxCourseEatingTime = DiningTestUtil.maximumCourseEatingTime(
				aNumPhilosophers, aTimeToEat);
		DiningTestUtil.setNewCourseTime(aTimeToEat, newCourseInvocationTime(aNumPhilosophers, aTimeToEat) );
    }
    protected void setWaitSelector(int aNumPhilosophers, long aTimeToEat) {
    }
       
    protected void registerForEvents(int aNumPhilosophers, long aTimeToEat) {
		DiningTestUtil.setNumberOfPhilosophers(aNumPhilosophers);
		DiningTestUtil.registerObserverWithObervables(concurrentPropertyChangeSupport);
    }
    protected int numExpectedThreads(int aNumPhilosophers, long aTimeToEat) {
    	return 1;
    }
	ConcurrentPropertyChange[] concurrentPropertyChanges = concurrentPropertyChangeSupport.getConcurrentPropertyChanges();
	 protected boolean checkNumThreads( int aNumPhilosophers, long aTimeToEat) {
		 int aNumberOfActualThreads = concurrentPropertyChangeSupport.getNotifyingThreads().length;
		 int aNumberOfExpectedThreads = numExpectedThreads(aNumPhilosophers, aTimeToEat);
			boolean aNumberOfThreadsResult = aNumberOfActualThreads == aNumberOfExpectedThreads;
			if (!aNumberOfThreadsResult) {
				System.err.println("Number of actual threads:" + aNumberOfActualThreads + " != number of expected threads " + aNumberOfExpectedThreads);
				System.err.println("Found  threads:" + Arrays.toString(concurrentPropertyChangeSupport.getNotifyingThreads()));
				return false;
			}
			return true;
	 }
	 protected int minSourceExpectedMatches(int aNumPhilosophers, long aTimeToEat) {
		 return MIN_SOURCE_MATCHES;
	 }
	 protected int maxSourceExpectedMatches(int aNumPhilosophers, long aTimeToEat) {
		 return MAX_SOURCE_MATCHES;
	 }
	 protected boolean checkExpectedSourceChanges( int aNumPhilosophers, long aTimeToEat) {
			boolean aSourceMatchResult = ConcurrentEventUtility.matchesEachSource(concurrentPropertyChanges,  expectedSourceChanges(), 
					minSourceExpectedMatches(aNumPhilosophers, aTimeToEat), 
					maxSourceExpectedMatches(aNumPhilosophers, aTimeToEat), 
					CHOPSTICK_PATTERN);
			if (!aSourceMatchResult) {
				System.err.println("Events of some source did not match expected patterns");
				return false;
			}
			return true;
	 }	 
	 protected int minThreadExpectedMatches( int aNumPhilosophers, long aTimeToEat) {
		 return aNumPhilosophers;
	 }	 
	 protected int maxThreadExpectedMatches( int aNumPhilosophers, long aTimeToEat) {
		 return aNumPhilosophers;
	 }	 
	 protected boolean checkExpectedThreadEvents( int aNumPhilosophers, long aTimeToEat) {
			boolean aThreadMatchResult = ConcurrentEventUtility.matchesEachThread(concurrentPropertyChanges,  expectedThreadChanges(), 
						minThreadExpectedMatches(aNumPhilosophers, aTimeToEat), 
						maxThreadExpectedMatches(aNumPhilosophers, aTimeToEat));
			if (!aThreadMatchResult) {
				System.err.println("Events of some thread did not match expected patterns");
				return false;
			}
			return true;
	 }	 
	 protected boolean checkEvents( int aNumPhilosophers, long aTimeToEat) {
	    	concurrentPropertyChanges = concurrentPropertyChangeSupport.getConcurrentPropertyChanges();
	    	ConcurrentEventUtility.traceAll(concurrentPropertyChanges);
	    	boolean aNumberOfThreadsResult = checkNumThreads(aNumPhilosophers, aTimeToEat);
			boolean aThreadMatchResult = checkExpectedThreadEvents(aNumPhilosophers, aTimeToEat);
			boolean aSourceMatchResult = checkExpectedSourceChanges(aNumPhilosophers, aTimeToEat);	
			return aNumberOfThreadsResult && aThreadMatchResult &&  aSourceMatchResult  ;
	    }
	protected boolean test(int aNumPhilosophers, long aTimeToEat) {
		registerForEvents(aNumPhilosophers, aTimeToEat);
		setWaitSelector(aNumPhilosophers, aTimeToEat);
		startEvents(aNumPhilosophers, aTimeToEat);		
		waitForEvents(aNumPhilosophers, aTimeToEat);
		return checkEvents(aNumPhilosophers, aTimeToEat);		
	}
}
