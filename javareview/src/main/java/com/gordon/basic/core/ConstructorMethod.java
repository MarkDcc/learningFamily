package com.gordon.basic.core;

/**
 * @Author:dongchen
 * @Date: 2023/1/14 14:44
 */
public class ConstructorMethod {
	private String name;

	public ConstructorMethod(){
		this("name");
		System.out.println("Method1");
	}

	public ConstructorMethod(String name) {
		//this();
		this.name = name;
		System.out.println("Method 2");

	}
}
