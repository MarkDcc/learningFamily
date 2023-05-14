package cn.bugstack.springframework.test.bean;

import cn.bugstack.springframework.context.ApplicationEvent;

/**
 * @Author:dongchen
 * @Date: 2023/5/13 17:16
 */
public class CustomerEvent extends ApplicationEvent {
	private String id;
	private String message;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Constructs a prototypical Event.
	 *
	 * @param source The object on which the Event initially occurred.
	 * @throws IllegalArgumentException if source is null.
	 */
	public CustomerEvent(Object source,String id,String message) {
		super(source);
		this.id = id;
		this.message = message;
	}
}
