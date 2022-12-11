package com.gordon.pojo;

/**
 * @Author:dongchen
 * @Date: 2022/11/19 18:18
 */
public class Account {

	private String name;
	private int age;

	public Account(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Account{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}
