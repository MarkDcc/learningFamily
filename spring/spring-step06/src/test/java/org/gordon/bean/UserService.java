package org.gordon.bean;

/**
 * @Author:dongchen
 * @Date: 2023/3/11 13:46
 */
public class UserService {
//	private String name;
	private String uid;
	private UseDao useDao;
	private String company;
	private String location;

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
//	public UserService(String name) {
//		this.name = name;
//	}


	public void setUid(String uid) {
		this.uid = uid;
	}

	public void setUseDao(UseDao useDao) {
		this.useDao = useDao;
	}

//	public void queryUser(){
//		System.out.println("查询获得User信息."+name);
//	}

	public void queryUser(){
		System.out.println(useDao.queryUser(uid));
	}
}
