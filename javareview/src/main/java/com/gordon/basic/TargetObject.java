package com.gordon.basic;

/**
 * @author dongchen
 * @Data 2022/10/24
 * @Time 21:35
 */
public class TargetObject {
	private String value;

	public TargetObject() {
		value = "JavaGuide";
	}

	public void publicMethod(String s) {
		System.out.println("I love " + s);
	}

	public static void staticMethod(String s){
		System.out.println("Static method "+ s +" invoke.");
	}

	private void privateMethod() {
		System.out.println("value is " + value);
	}

	@Override
	public String toString() {
		return "TargetObject{" +
				"value='" + value + '\'' +
				'}';
	}
}
