package org.gordon.beans;

/**
 * @Author:dongchen
 * @Date: 2023/3/19 18:37
 */
public class BeansException extends RuntimeException{
	public BeansException(String msg) {
		super(msg);
	}

	public BeansException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
