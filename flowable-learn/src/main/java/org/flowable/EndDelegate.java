package org.flowable;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

import java.util.HashMap;

/**
 * @Author:dongchen
 * @Date: 2022/11/5 19:29
 */
public class EndDelegate implements JavaDelegate
{
    @Override
    public void execute(DelegateExecution delegateExecution) {

        HashMap<String,String> variable = new HashMap<>();
        variable.put("EndDelegate", "zhangsan");

        delegateExecution.setVariable("EndDelegate",variable);
        System.out.println("任务结束.");
    }
}
