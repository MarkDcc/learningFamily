package cn.bugstack.springframework.context.event;

import cn.bugstack.springframework.context.ApplicationContext;
import cn.bugstack.springframework.context.ApplicationEvent;

/**
 * @Author:dongchen
 * @Date: 2023/5/13 14:40
 */
public class ApplicationContextEvent extends ApplicationEvent {
	/**
	 * Constructs a prototypical Event.
	 *
	 * @param source The object on which the Event initially occurred.
	 * @throws IllegalArgumentException if source is null.
	 */
	public ApplicationContextEvent(Object source) {
		super(source);
	}

	public final ApplicationContext getApplicationContext(){
		return (ApplicationContext) getSource();
	}
}
