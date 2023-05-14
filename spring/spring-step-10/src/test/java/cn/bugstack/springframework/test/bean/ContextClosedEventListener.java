package cn.bugstack.springframework.test.bean;

import cn.bugstack.springframework.context.event.ApplicationListener;
import cn.bugstack.springframework.context.event.ContextClosedEvent;

/**
 * @Author:dongchen
 * @Date: 2023/5/13 17:14
 */
public class ContextClosedEventListener implements ApplicationListener<ContextClosedEvent> {
	@Override
	public void onApplicationEvent(ContextClosedEvent event) {
		System.out.println("context 关闭了。");
	}
}
