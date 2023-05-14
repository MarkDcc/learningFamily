package cn.bugstack.springframework.test.bean;

import cn.bugstack.springframework.context.event.ApplicationListener;
import cn.bugstack.springframework.context.event.ContextRefreshedEvent;

/**
 * @Author:dongchen
 * @Date: 2023/5/13 17:15
 */
public class ContextRefreshedListener implements ApplicationListener<ContextRefreshedEvent> {
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		System.out.println("Context Refreshed.");
	}
}
