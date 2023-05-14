package cn.bugstack.springframework.context.event;

/**
 * @Author:dongchen
 * @Date: 2023/5/13 14:44
 */
public class ContextClosedEvent extends ApplicationContextEvent{
	/**
	 * Constructs a prototypical Event.
	 *
	 * @param source The object on which the Event initially occurred.
	 * @throws IllegalArgumentException if source is null.
	 */
	public ContextClosedEvent(Object source) {
		super(source);
	}
}
