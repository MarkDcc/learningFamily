package com.gordon.basic.proxy;

/**
 * @author dongchen
 * @Data 2022/10/25
 * @Time 22:04
 */
public class SmsServiceImpl implements SmsService{
	@Override
	public String send(String message) {
		System.out.println("Native method send message:" + message);
		return message;
	}

	@Override
	public String receive() {
		System.out.println("Receive native invoke.");
		return "receive";
	}
}
