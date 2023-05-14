package cn.bugstack.springframework.context.event;

import cn.bugstack.springframework.context.ApplicationEvent;

import java.util.EventListener;

/**
 * @Author:dongchen
 * @Date: 2023/5/13 14:47
 */
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {
	/**
	 * Handle an application event.
	 * @param event the event to respond to
	 */
	void onApplicationEvent(E event);
}
