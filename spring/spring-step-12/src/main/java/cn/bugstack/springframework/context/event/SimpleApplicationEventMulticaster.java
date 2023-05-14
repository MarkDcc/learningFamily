package cn.bugstack.springframework.context.event;

import cn.bugstack.springframework.beans.factory.BeanFactory;
import cn.bugstack.springframework.context.ApplicationEvent;

import java.util.Collection;

/**
 * @Author:dongchen
 * @Date: 2023/5/13 15:24
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster{

	public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
		setBeanFactory(beanFactory);
	}

	@Override
	public void multicastEvent(ApplicationEvent event) {
		Collection<? extends ApplicationListener> applicationListener = getApplicationListener(event);
		for (ApplicationListener listener : applicationListener) {
			listener.onApplicationEvent(event);
		}
	}
}
