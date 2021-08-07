package gradingTools.comp999.assignment2;

import java.beans.PropertyChangeListener;

import org.junit.Assert;

import grader.basics.execution.BasicProjectExecution;

public class DiningTestUtil {
	public static final String UTIL_CLASS_NAME = "diningPhilosopher.main.DiningUtil";
    public static final String SETTER_NUMBER_OF_PHILOSOPHERS = "setNumberOfPhilosophers";
    public static final String WAIT_FOR_PHILOSPHERS_TO_FINISH = "waitForPhilosophersToFinish";

    public static final String SETTER_NEW_COURSE_TIME = "setNewCourseTime";
    public static final String ADD_OBSERVER = "registerObserverWithObservables";

	public static final String ALL_THREADS_FINISHED = "All Threads Finished";
	protected static final long NUMBER_OF_BLOCKING_STEPS = 3; // think, left and right chopsticks
	protected static final long SYNCHRONIZATION_MULTIPLIER = 5;
    protected static final long METHOD_INVOKE_TIME_OUT = 100;


//    public static final long TIME_OUT = 200;
    
    public static long maximumCourseEatingTime (int aNumberPhilosopher, long aPauseTime) {
    	
    	return aPauseTime*NUMBER_OF_BLOCKING_STEPS*SYNCHRONIZATION_MULTIPLIER;
    }
    
       
    public static Object registerObserverWithObervables(PropertyChangeListener aListener) {
    	Class[] anArgTypes = {PropertyChangeListener.class};
    	Object[] anArgs = {aListener};
    	try {
			return BasicProjectExecution.timedInvokeClassMethod(
					UTIL_CLASS_NAME, ADD_OBSERVER, anArgTypes, 
					anArgs, METHOD_INVOKE_TIME_OUT);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e;
		}
    }
    public static Object setNumberOfPhilosophers(int aNumberPhilosopher) {
    	Class[] anArgTypes = {Integer.TYPE};
    	Object[] anArgs = {aNumberPhilosopher};
    	try {
			return BasicProjectExecution.timedInvokeClassMethod(
					UTIL_CLASS_NAME, SETTER_NUMBER_OF_PHILOSOPHERS, anArgTypes, 
					anArgs, METHOD_INVOKE_TIME_OUT);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e;
		}
    }
    public static Object setNewCourseTime(long aNumberPhilosopher) {
    	Class[] anArgTypes = {Long.TYPE};
    	Object[] anArgs = {aNumberPhilosopher};
    	try {
			return BasicProjectExecution.timedInvokeClassMethod(UTIL_CLASS_NAME, SETTER_NEW_COURSE_TIME, anArgTypes, anArgs, METHOD_INVOKE_TIME_OUT);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e;
		}
    }
    public static Object waitForPhilosophersToFinish(long aTimeOut) {
    	Class[] anArgTypes = {};
    	Object[] anArgs = {};
    	try {
			return BasicProjectExecution.timedInvokeClassMethod(UTIL_CLASS_NAME, WAIT_FOR_PHILOSPHERS_TO_FINISH, anArgTypes, anArgs, aTimeOut);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.assertTrue("Wait call timed out", false);
			return e;
//			return e;
		}
    }
    
    
}
