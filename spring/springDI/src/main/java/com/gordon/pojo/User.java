package com.gordon.pojo;

/**
 * @Author:dongchen
 * @Date: 2022/11/19 16:18
 */
public class User {
	private String name;
	private int age;
	private Address address;

	@Override
	public String toString() {
		return "User{" +
				"name='" + name + '\'' +
				", age=" + age +
				", address=" + address +
				'}';
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public User() {
		System.out.println("I'm user's no args constructor.");
	}

	public User(String name, int age, Address address) {
		System.out.println("User的有参构造器.");

		this.name = name;
		this.age = age;
		this.address = address;
	}

	/**
	 * DI使用对象的setter方法完成属性的注入
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
