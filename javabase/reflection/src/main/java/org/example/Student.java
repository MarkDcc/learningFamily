package org.example;

/**
 * @Author:dongchen
 * @Date: 2023/4/10 16:36
 */
public class Student extends Person{
	private String classRoom;
	public Integer number;

	public Student(String classRoom, Integer number) {
		this.classRoom = classRoom;
		this.number = number;
	}

	public Student() {
	}

	public void print(){
		System.out.println("classRoom = " + classRoom);
		System.out.println("number = " + number);
	}

	public void getNumber(Integer number){
		this.number = number;
		System.out.println("number:"+number);
	}

	public void getNumber(Integer number,String classRoom){
		this.number = number;
		System.out.println("number:"+number+"classRoom:"+classRoom);
	}

	private void getClassRoom(String classRoom){
//		this.number = number;
		System.out.println("number:"+classRoom);
	}
}
