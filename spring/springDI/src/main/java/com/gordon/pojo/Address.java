package com.gordon.pojo;

/**
 * @Author:dongchen
 * @Date: 2022/11/19 16:30
 */
public class Address {
	private String RoadPath;
	private int roomNum;

	public Address() {
	}

	public void setRoadPath(String roadPath) {
		RoadPath = roadPath;
	}

	@Override
	public String toString() {
		return "Address{" +
				"RoadPath='" + RoadPath + '\'' +
				", roomNum=" + roomNum +
				'}';
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}
}
