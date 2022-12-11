package com.gordon.pojo;

/**
 * @Author:dongchen
 * @Date: 2022/11/20 09:44
 */
public class Account {
	private int id;
	private String name;
	private int num;

	public Account() {
	}

	public Account(int id, String name, int num) {
		this.id = id;
		this.name = name;
		this.num = num;
	}

	@Override
	public String toString() {
		return "Account{" +
				"id=" + id +
				", name='" + name + '\'' +
				", num=" + num +
				'}';
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNum(int num) {
		this.num = num;
	}
}
