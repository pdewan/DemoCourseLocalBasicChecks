package gradingTools.comp999.assignment2.testcases;

import java.util.Arrays;

import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.BasicProjectIntrospection;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import grader.basics.testcase.PassFailJUnitTestCase;
import gradingTools.comp999.assignment2.DiningTestUtil;
import gradingTools.shared.testcases.concurrency.propertyChanges.BasicConcurrentPropertyChangeSupport;
import gradingTools.shared.testcases.concurrency.propertyChanges.ConcurrentEventUtility;
import gradingTools.shared.testcases.concurrency.propertyChanges.ConcurrentPropertyChange;
import gradingTools.shared.testcases.concurrency.propertyChanges.ConcurrentPropertyChangeSupport;
import gradingTools.shared.testcases.concurrency.propertyChanges.Selector;

public class DiningAtomicChopstick extends DiningExclusiveChopstick {
    
//    public static final int NUM_CHOPSTICKS_FOR_EATING = 2;
//	protected static final int[] NUM_PHILOSOPHERS_LIST = {2, 3, 5};;
//    protected static final long[] EAT_TIME_LIST =  {200, 300, 100};
////    protected static final int NUM_PHILOSOPHERS_2 = 3;
////    protected static final long TIME_TO_EAT_2 = 300;
////    protected static final int NUM_PHILOSOPHERS_3 = 5;
////    protected static final long TIME_TO_EAT_3 = 100;
//    public static final String[] TERMINATING_MATCH_PER_PHILOSOPHER = 
//		{"Thread.*Philosopher.*", "Philosopher.*", "With.*Chopstick", "true", "false"};

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
//    		{"Thread.*Philosopher.*", "Chopstick.*", "Used", "false", "true"},
//    		{"Thread.*Philosopher.*", "Philosopher.*", "With.*Chopstick", "false", "true"},
//    		
//    		{"Thread.*Philosopher.*", "Philosopher.*", "Fed", "false", "true"},
//    		
//    		{"Thread.*Philosopher.*", "Chopstick.*", "Used", "true", "false"},
//    		{"Thread.*Philosopher.*", "Philosopher.*", "With.*Chopstick", "true", "false"},
//    		{"Thread.*Philosopher.*", "Chopstick.*", "Used", "true", "false"},
//    		{"Thread.*Philosopher.*", "Philosopher.*", "With.*Chopstick", "true", "false"},
    };
//    protected static final long METHOD_INVOKE_TIME_OUT = 100;
//    protected static final long NUM_STEPS = 5;
//    protected static final long SYNCHRONIZATION_MULTIPLIER = 10;
//    protected ConcurrentPropertyChangeSupport concurrentPropertyChangeSupport = new BasicConcurrentPropertyChangeSupport();
//	protected boolean interleavingOccuredInSomeTest = false;
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
	
//	protected int[] numPhilosophersList() {
//		return NUM_PHILOSOPHERS_LIST;
//	}
//	protected long[] eatTimeList() {
//		return EAT_TIME_LIST;
//	}
//	
//	protected int minChopstickGrabs () {
//		return 2;
//	}
//	protected int maxChopstickGrabs () {
//		return 2;
//	}

//    @Override
//	public TestCaseResult test(Project project, boolean autoGrade)
//			throws NotAutomatableException, NotGradableException {
//    	boolean anEachRunWasSuccessful = testDifferentParameters();
//    	if (!anEachRunWasSuccessful) {
//			return fail("Please see console messages");
//    	}
//    	return doAggregateTest();
////    	int[] aNumPhilosophersList = numPhilosophersList();
////    	long[] anEatTimesList = eatTimeList();
////		for (int aTestIndex = 0; aTestIndex < aNumPhilosophersList.length; aTestIndex++) {
////			boolean aResult = testOnce(aNumPhilosophersList[aTestIndex], anEatTimesList[aTestIndex] );
////
////			if (!aResult) {
////				return fail("Please see console messages");
////			}
////		}
////		if (!interleavingOccuredInSomeTest) {
////			return fail("No intervealing occured in any test");
////		}
////		return pass();
//		
//	}
//    
//    protected TestCaseResult doAggregateTest() {
//    	if (!interleavingOccuredInSomeTest) {
//			return fail("No intervealing occured in any test");
//		}
//		return pass();
//    }
//	
//    protected boolean testDifferentParameters() {
//    	int[] aNumPhilosophersList = numPhilosophersList();
//    	long[] anEatTimesList = eatTimeList();
//		for (int aTestIndex = 0; aTestIndex < aNumPhilosophersList.length; aTestIndex++) {
//			boolean aResult = test(aNumPhilosophersList[aTestIndex], anEatTimesList[aTestIndex] );
//
//			if (!aResult) {
//				return false;
//			}
//		}
//		return true;
//    }
    
//    protected void waitForEvents(int aNumPhilosophers, long aTimeToEat) {
//    	long aMaxCourseEatingTime = DiningTestUtil.maximumCourseEatingTime(
//				aNumPhilosophers, aTimeToEat);
////		DiningTestUtil.waitForPhilosophersToFinish(aMaxCourseEatingTime);
//    	try {
//			Thread.sleep(aMaxCourseEatingTime);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//    }
    
//    protected void waitForEvents(int aNumPhilosophers, long aTimeToEat) {
//    	long aMaxCourseEatingTime = DiningTestUtil.maximumCourseEatingTime(
//				aNumPhilosophers, aTimeToEat);
//    	concurrentPropertyChangeSupport.selectorBasedWait(aMaxCourseEatingTime);
//    }
//    protected void startEvents(int aNumPhilosophers, long aTimeToEat) {
//    	concurrentPropertyChangeSupport.resetConcurrentEvents();
//		DiningTestUtil.setNewCourseTime(aTimeToEat);
//    }
//    protected void setWaitSelector(int aNumPhilosophers, long aTimeToEat) {
////    	ConcurrentEventUtility.setWaitSelector(concurrentPropertyChangeSupport, 
////    			TERMINATING_MATCH_PER_PHILOSOPHER, aNumPhilosophers*NUM_CHOPSTICKS_FOR_EATING);
//    	ConcurrentEventUtility.setWaitSelector(concurrentPropertyChangeSupport, 
//    			null);
//    }
    
   
//    protected void registerForEvents(int aNumPhilosophers, long aTimeToEat) {
//		DiningTestUtil.setNumberOfPhilosophers(aNumPhilosophers);
//		DiningTestUtil.registerObserverWithObervables(concurrentPropertyChangeSupport);
////		DiningTestUtil.setNewCourseTime(aTimeToEat);
//    }
//	ConcurrentPropertyChange[] concurrentPropertyChanges = concurrentPropertyChangeSupport.getConcurrentPropertyChanges();
//	 protected boolean checkThreads( int aNumPhilosophers, long aTimeToEat) {
//		 int aNumberOfActualThreads = concurrentPropertyChangeSupport.getThreads().length;
//			boolean aNumberOfThreadsResult = aNumberOfActualThreads == aNumPhilosophers;
//			if (!aNumberOfThreadsResult) {
//				System.err.println("Number of actual threads:" + aNumberOfActualThreads + " != number of expected threads " + aNumPhilosophers);
//				System.err.println("Found  threads:" + Arrays.toString(concurrentPropertyChangeSupport.getThreads()));
//				return false;
//			}
//			return true;
//	 }
//	 
//	 protected boolean checkExpectedSourceChanges( int aNumPhilosophers, long aTimeToEat) {
//			boolean aSourceMatchResult = ConcurrentEventUtility.matchesEachSource(concurrentPropertyChanges,  expectedSourceChanges(), 1, 2, "Chopstick.*");
//			if (!aSourceMatchResult) {
//				System.err.println("Events of some source did not match expected patterns");
//				return false;
//			}
//			return true;
//	 }
	 
//	 protected boolean checkExpectedThreadEvents( int aNumPhilosophers, long aTimeToEat) {
//			boolean aThreadMatchResult = ConcurrentEventUtility.matchesEachThread(concurrentPropertyChanges,  expectedThreadChanges(), 1, 1);
//			if (!aThreadMatchResult) {
//				System.err.println("Events of some thread did not match expected patterns");
//				return false;
//			}
//			return true;
//	 }
//	 
//	 protected boolean checkInterleaving ( int aNumPhilosophers, long aTimeToEat) {
//			return ConcurrentEventUtility.someInterleaving(concurrentPropertyChanges, concurrentPropertyChangeSupport.getThreads(), null);
//
//	 }
//
//	 protected boolean checkEvents( int aNumPhilosophers, long aTimeToEat) {
//	    	concurrentPropertyChanges = concurrentPropertyChangeSupport.getConcurrentPropertyChanges();
//	    	boolean aNumberOfThreadsResult = checkThreads(aNumPhilosophers, aTimeToEat);
////	    	int aNumberOfActualThreads = concurrentPropertyChangeSupport.getThreads().length;
////			boolean aNumberOfThreadsResult = aNumberOfActualThreads == aNumPhilosophers;
////			if (!aNumberOfThreadsResult) {
////				System.out.println("Number of actual threads:" + aNumberOfActualThreads + " != number of expected threads" + aNumPhilosophers);
////				return false;
////			}
//			boolean aThreadMatchResult = checkExpectedThreadEvents(aNumPhilosophers, aTimeToEat);
//			boolean aSourceMatchResult = checkExpectedSourceChanges(aNumPhilosophers, aTimeToEat);
//			boolean aSomeInterleavingResult = checkInterleaving(aNumPhilosophers, aTimeToEat);
//			if (aSomeInterleavingResult) {
//				interleavingOccuredInSomeTest = true;
//			} 	
//			return aNumberOfThreadsResult && aThreadMatchResult &&  aSourceMatchResult && aSomeInterleavingResult ;
//
//	    }
//	protected boolean test(int aNumPhilosophers, long aTimeToEat) {
//		registerForEvents(aNumPhilosophers, aTimeToEat);
//		setWaitSelector(aNumPhilosophers, aTimeToEat);
//		startEvents(aNumPhilosophers, aTimeToEat);		
//		waitForEvents(aNumPhilosophers, aTimeToEat);
//		return checkEvents(aNumPhilosophers, aTimeToEat);
////		concurrencySupport.resetConcurrentEvents();
////		DiningTestUtil.setNumberOfPhilosophers(aNumPhilosphers);
////		DiningTestUtil.registerObserverWithObervables(concurrencySupport);
////		DiningTestUtil.setNewCourseTime(aTimeToEat);
////		long aMaxCourseEatingTime = DiningTestUtil.maximumCourseEatingTime(
////				aNumPhilosphers, aTimeToEat);
////		waitForEvents(aMaxCourseEatingTime);
////		DiningTestUtil.waitForPhilosophersToFinish(aMaxCourseEatingTime);
////		ConcurrentPropertyChange[] aConcurrentPropertyChanges = concurrencySupport.getConcurrentPropertyChanges();
////		boolean aNumberOfThreadsResult = concurrencySupport.getThreads().length == aNumPhilosphers;
////		boolean aThreadMatchResult = ConcurrentEventUtility.matchesEachThread(aConcurrentPropertyChanges,  EXPECTED_THREAD_CHANGES);
////
////		boolean aSomeInterleavingResult = ConcurrentEventUtility.someInterleaving(aConcurrentPropertyChanges, concurrencySupport.getThreads(), null);
////		if (aSomeInterleavingResult) {
////			interleavingOccuredInSomeTest = true;
////		}
////		//		ConcurrentEventUtility.getConcurrentPropertyChangesByThread(aConcurrentPropertyChanges);
////		return aNumberOfThreadsResult && aThreadMatchResult && aSomeInterleavingResult ;
//		
//	}

}
