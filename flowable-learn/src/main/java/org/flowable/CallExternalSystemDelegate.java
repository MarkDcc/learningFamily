package org.flowable;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

import java.util.HashMap;

/**
 * @author dongchen
 * @Data 2022/10/20
 * @Time 18:11
 */
public class CallExternalSystemDelegate implements JavaDelegate {
	@Override
	public void execute(DelegateExecution execution) {
		HashMap<String,String> variable = new HashMap<>();
		variable.put("CallExternalSystemDelegate", "zhangsan");

		execution.setVariable("CallExternalSystemDelegate",variable);

		System.out.println("发送approve邮件！");
	}
}
