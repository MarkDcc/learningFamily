package cn.bugstack.springframework.context.event;

import cn.bugstack.springframework.context.ApplicationEvent;

/**
 * @Author:dongchen
 * @Date: 2023/5/13 14:46
 */
public interface ApplicationEventMulticaster {
	/**
	 * Add a listener to be notified of all events.
	 * @param listener the listener to add
	 */
	void addApplicationListener(ApplicationListener<?> listener);

	/**
	 * Remove a listener from the notification list.
	 * @param listener the listener to remove
	 */
	void removeApplicationListener(ApplicationListener<?> listener);

	/**
	 * Multicast the given application event to appropriate listeners.
	 * @param event the event to multicast
	 */
	void multicastEvent(ApplicationEvent event);


}