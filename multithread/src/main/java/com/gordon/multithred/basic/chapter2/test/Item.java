package com.gordon.multithred.basic.chapter2.test;

/**
 * @author dongchen
 * @Data 2022/10/17
 * @Time 16:00
 */
public class Item {
	private int id;
	public Item(int id){
		this.id = id;
	}

	@Override
	public String toString() {
		return "Item{" +
				"id=" + id +
				'}';
	}
}
