package cn.bugstack.springframework.test.bean;

import cn.bugstack.springframework.context.event.ApplicationListener;

/**
 * @Author:dongchen
 * @Date: 2023/5/13 17:18
 */
public class CustomerEventListener implements ApplicationListener<CustomerEvent> {
	@Override
	public void onApplicationEvent(CustomerEvent event) {
		System.out.println(event.getId()+":"+event.getMessage());
	}
}
