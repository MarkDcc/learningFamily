package com.gordon.beanfactory.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:dongchen
 * @Date: 2023/3/19 10:26
 */
public class UseDao {
	private static Map<String,String> hashMap = new HashMap<>();

	static {
		hashMap.put("1001", "小一哥");
		hashMap.put("1002", "小二哥");
		hashMap.put("1003", "小三哥");
	}

	public String queryUser(String uid){
		return hashMap.get(uid);
	}
}
