package com.gordon.basic.proxy;

import javax.print.DocFlavor;

/**
 * @author dongchen
 * @Data 2022/10/25
 * @Time 22:04
 */
public interface SmsService {
	String send(String message);

	String receive();
}
