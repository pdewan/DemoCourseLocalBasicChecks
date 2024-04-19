package gradingTools.comp999.assignment2.testcases;

import grader.basics.concurrency.propertyChanges.ConcurrentEventUtility;
import grader.basics.concurrency.propertyChanges.ConcurrentPropertyChange;
import grader.basics.concurrency.propertyChanges.ConcurrentPropertyChangeSupport;
import grader.basics.concurrency.propertyChanges.Selector;

public class JoinMessageReceivedSelector implements Selector<ConcurrentPropertyChangeSupport> {
	public static Object[] parameters = {
			null,
			null,
			null,
			null,
			null,
			".*join.*"
	};
	@Override
	public boolean selects(ConcurrentPropertyChangeSupport aSupport) {
		ConcurrentPropertyChange aConcurrentPropertyChange = aSupport.getLastConcurrentPropertyChange();
		return ConcurrentEventUtility.matches(aConcurrentPropertyChange, parameters);
	}

}
