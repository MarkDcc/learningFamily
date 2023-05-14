package com.gordon.iterator;

/**
 * @Author:dongchen
 * @Date: 2023/1/3 21:09
 */
public class Book {
	private String name;

	public Book(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Book{" +
				"name='" + name + '\'' +
				'}';
	}
}
