package cn.bugstack.springframework.context;

import java.util.EventObject;

/**
 * @Author:dongchen
 * @Date: 2023/5/13 14:40
 */
public class ApplicationEvent extends EventObject {
	/**
	 * Constructs a prototypical Event.
	 *
	 * @param source The object on which the Event initially occurred.
	 * @throws IllegalArgumentException if source is null.
	 */
	public ApplicationEvent(Object source) {
		super(source);
	}
}
