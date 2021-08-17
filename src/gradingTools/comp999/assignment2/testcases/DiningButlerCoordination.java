package gradingTools.comp999.assignment2.testcases;
import gradingTools.comp999.assignment2.DiningTestUtil;
public class DiningButlerCoordination extends DiningNoDeadlock {
	protected void setWaitSelector(int aNumPhilosophers, long aTimeToEat) {
	}
	protected void waitForEvents(int aNumPhilosophers, long aTimeToEat) {
		long aMaxCourseEatingTime = DiningTestUtil.maximumCourseEatingTime(aNumPhilosophers, aTimeToEat);
		Object retVal = DiningTestUtil.waitForPhilosophersToFinish(aMaxCourseEatingTime);
	}
}
