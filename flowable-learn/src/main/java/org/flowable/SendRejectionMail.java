package org.flowable;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

/**
 * @author dongchen
 * @Data 2022/10/20
 * @Time 18:12
 */
public class SendRejectionMail implements JavaDelegate {
	@Override
	public void execute(DelegateExecution execution) {
		System.out.println("发送拒绝邮件！");
	}
}
