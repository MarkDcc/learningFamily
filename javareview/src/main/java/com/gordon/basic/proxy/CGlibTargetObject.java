package com.gordon.basic.proxy;

/**
 * @author dongchen
 * @Data 2022/10/25
 * @Time 22:22
 */
public class CGlibTargetObject {

	public void sendMessage(String message){
		System.out.println("Native sendMessage invoke: "+ message);

	}
}
