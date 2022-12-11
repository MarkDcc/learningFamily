package com.gordon.pojo;

/**
 * @Author:dongchen
 * @Date: 2022/11/19 19:47
 */
public class User {
	private String name;

	@Override
	public String toString() {
		return "User{" +
				"name='" + name + '\'' +
				'}';
	}

	public User() {
	}

	public void setName(String name) {
		this.name = name;
	}
}
