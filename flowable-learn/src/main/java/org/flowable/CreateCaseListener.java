package org.flowable;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.flowable.engine.delegate.TaskListener;
import org.flowable.task.service.delegate.DelegateTask;

/**
 * @Author:dongchen
 * @Date: 2023/4/5 11:27
 */
public class CreateCaseListener implements TaskListener {


	@Override
	public void notify(DelegateTask delegateTask) {
		System.out.println("到了employee");
	}
}
