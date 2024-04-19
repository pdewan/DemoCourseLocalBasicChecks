package gradingTools.comp999.assignment2.testcases;

import grader.basics.concurrency.propertyChanges.ConcurrentEventUtility;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import gradingTools.comp999.assignment2.DiningTestUtil;

public class DiningSharedChopstick extends DiningSequentialEating {

	public static final String[] TERMINATING_MATCH_PER_THREAD = { "Thread.*Philosopher.*", "Philosopher.*", "Fed",
			"false", "true" };

	public static final String[][] EXPECTED_CHOPSTICK_CHANGES = { { ".*", "Chopstick.*", "Used", ".*", ".*" },
			{ ".*", "Chopstick.*", "Used", ".*", ".*" }, };

	protected String[][] expectedSourceChanges() {
		return EXPECTED_CHOPSTICK_CHANGES;
	}

	protected long newCourseInvocationTime(int aNumPhilosophers, long aTimeToEat) {
		return DiningTestUtil.METHOD_INVOKE_TIME_OUT;
	}

	protected TestCaseResult doAggregateTest() {
		if (!interleavingOccuredInSomeTest) {
			return fail("No intervealing occured in any test");
		}
		return pass();
	}
	protected void waitForEvents(int aNumPhilosophers, long aTimeToEat) {
		long aMaxCourseEatingTime = DiningTestUtil.maximumCourseEatingTime(aNumPhilosophers, aTimeToEat);
		concurrentPropertyChangeSupport.selectorBasedWait(aMaxCourseEatingTime);
	}
	protected String[] terminatingMatchPerThread() {
		return TERMINATING_MATCH_PER_THREAD;
	}
	protected void setWaitSelector(int aNumPhilosophers, long aTimeToEat) {
		ConcurrentEventUtility.setMatchEveryThreadWaitSelector(concurrentPropertyChangeSupport,
				terminatingMatchPerThread(), aNumPhilosophers, 1, null);
	}
	protected int numExpectedThreads(int aNumPhilosophers, long aTimeToEat) {
		return aNumPhilosophers;
	}
	protected boolean checkInterleaving(int aNumPhilosophers, long aTimeToEat) {
		return ConcurrentEventUtility.someInterleaving(concurrentPropertyChanges,
				concurrentPropertyChangeSupport.getNotifyingThreads(), null);
	}
	@Override
	protected int minThreadExpectedMatches(int aNumPhilosophers, long aTimeToEat) {
		return 1;
	}
	@Override
	protected int maxThreadExpectedMatches(int aNumPhilosophers, long aTimeToEat) {
		return 1;
	}
	protected boolean checkEvents(int aNumPhilosophers, long aTimeToEat) {
		boolean aSuperResult = super.checkEvents(aNumPhilosophers, aTimeToEat);
		boolean aSomeInterleavingResult = checkInterleaving(aNumPhilosophers, aTimeToEat);
		if (aSomeInterleavingResult) {
			interleavingOccuredInSomeTest = true;
		}
		return aSuperResult && aSomeInterleavingResult;
	}
	@Override
	public TestCaseResult test(Project project, boolean autoGrade)
			throws NotAutomatableException, NotGradableException {
		super.test(project, autoGrade);
		return doAggregateTest();
	}
}
