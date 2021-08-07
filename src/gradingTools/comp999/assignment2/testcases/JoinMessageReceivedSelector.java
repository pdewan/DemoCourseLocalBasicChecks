package gradingTools.comp999.assignment2.testcases;

import gradingTools.shared.testcases.concurrency.propertyChanges.ConcurrentEventUtility;
import gradingTools.shared.testcases.concurrency.propertyChanges.ConcurrentPropertyChange;
import gradingTools.shared.testcases.concurrency.propertyChanges.ConcurrentPropertyChangeSupport;
import gradingTools.shared.testcases.concurrency.propertyChanges.Selector;

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
