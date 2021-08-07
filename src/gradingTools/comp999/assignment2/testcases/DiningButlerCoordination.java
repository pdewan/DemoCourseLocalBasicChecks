package gradingTools.comp999.assignment2.testcases;

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

public class DiningButlerCoordination extends DiningNoDeadlock {
//  public static final String[][] EXPECTED_BUTLER_COORDINATION_CHANGES = {
//	{"Thread.*Philosopher.*", ".*", "All Threads Finished", "false", "true"},
//  };
//    protected static final int[] NUM_PHILOSOPHERS_LIST = {2, 3, 5};;
//    protected static final long[] EAT_TIME_LIST =  {200, 300, 100};
////    protected static final int NUM_PHILOSOPHERS_2 = 3;
////    protected static final long TIME_TO_EAT_2 = 300;
////    protected static final int NUM_PHILOSOPHERS_3 = 5;
////    protected static final long TIME_TO_EAT_3 = 100;
//    public static final String[][] EXPECTED_THREAD_CHANGES = {
//    		{"Thread.*Philosopher.*", "Philosopher.*", "Fed", ".*", "false"},
//    		
//    		{"Thread.*Philosopher.*", "Chopstick.*", "Used", "false", "true"},
//    		{"Thread.*Philosopher.*", "Philosopher.*", "With.*Chopstick", "false", "true"},
//    		{"Thread.*Philosopher.*", "Chopstick.*", "Used", "false", "true"},
//    		{"Thread.*Philosopher.*", "Philosopher.*", "With.*Chopstick", "false", "true"},
//    		
//    		{"Thread.*Philosopher.*", "Philosopher.*", "Fed", "false", "true"},
//    		
//    		{"Thread.*Philosopher.*", "Chopstick.*", "Used", "true", "false"},
//    		{"Thread.*Philosopher.*", "Philosopher.*", "With.*Chopstick", "true", "false"},
//    		{"Thread.*Philosopher.*", "Chopstick.*", "Used", "true", "false"},
//    		{"Thread.*Philosopher.*", "Philosopher.*", "With.*Chopstick", "true", "false"},
//    };
////    protected static final long METHOD_INVOKE_TIME_OUT = 100;
////    protected static final long NUM_STEPS = 5;
////    protected static final long SYNCHRONIZATION_MULTIPLIER = 10;
//    protected ConcurrentPropertyChangeSupport concurrencySupport = new BasicConcurrentPropertyChangeSupport();
//	protected boolean interleavingOccuredInSomeTest = false;
//	protected String[][] expectedThreadChanges() {
//		return EXPECTED_THREAD_CHANGES;
//	}
//	protected int[] numPhilosophersList() {
//		return NUM_PHILOSOPHERS_LIST;
//	}
//	protected long[] eatTimeList() {
//		return EAT_TIME_LIST;
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
//    
    protected void waitForEvents(int aNumPhilosophers, long aTimeToEat) {
    	long aMaxCourseEatingTime = DiningTestUtil.maximumCourseEatingTime(
				aNumPhilosophers, aTimeToEat);
		Object retVal = DiningTestUtil.waitForPhilosophersToFinish(aMaxCourseEatingTime);
		if (retVal instanceof Exception) {
			
		}
    }
    
//    protected void preEventsSetup(int aNumPhilosophers, long aTimeToEat) {
//    	concurrencySupport.resetConcurrentEvents();
//		DiningTestUtil.setNumberOfPhilosophers(aNumPhilosophers);
//		DiningTestUtil.registerObserverWithObervables(concurrencySupport);
//		DiningTestUtil.setNewCourseTime(aTimeToEat);
//    }
//    
//    protected boolean checkEvents( int aNumPhilosophers, long aTimeToEat) {
//    	boolean aNoDeadlock = super.checkEvents(aNumPhilosophers, aTimeToEat);
//    	if (!aNoDeadlock) {
//    		return aNoDeadlock;
//    	}
//    	boolean aButlerCoordination = ConcurrentEventUtility.matches(concurrentPropertyChanges, EXPECTED_BUTLER_COORDINATION_CHANGES);
//    	if (aButlerCoordination) {
//    	System.err.println("All Threads Finished Property did not become true");
//    	}
//    	return aButlerCoordination;
//
//    }
//	
//	protected boolean test(int aNumPhilosophers, long aTimeToEat) {
//		preEventsSetup(aNumPhilosophers, aTimeToEat);
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
