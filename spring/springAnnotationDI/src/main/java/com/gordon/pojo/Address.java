package com.gordon.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author:dongchen
 * @Date: 2022/11/19 16:30
 */
@Component
public class Address {

	@Value(value = "pudong")
	private String RoadPath;

	@Value("123")
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
