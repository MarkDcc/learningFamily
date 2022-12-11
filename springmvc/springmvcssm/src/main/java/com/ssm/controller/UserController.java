package com.ssm.controller;

import com.ssm.pojo.User;
import com.ssm.service.UserService;
import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author:dongchen
 * @Date: 2022/11/27 19:07
 */
@RestController
@RequestMapping("/user")
public class UserController {

	/**
	 * url	/user/selectUserPage?userName=z&userSex=男&page=null
	 */
	@Autowired
	UserService userService;

	@GetMapping ("/selectUserPage")
	public List<User> selectUserPage(String userName,
	                                 String userSex,
	                                Integer page) {
		int startRow = 0;
		if(page != null){
			startRow = (page-1)*5;
		}
		return userService.selectUserPage(userName,userSex,startRow);
	}


	@RequestMapping("/getRowCount")
	public int getRowCount(String userName,String userSex){
		return userService.getRowCount(userName,userSex);
	}
	///user/deleteUserById?userId= 15968162087363060
	@RequestMapping("/deleteUserById")

	public int deleteUserById(String userId){
		return userService.deleteUserById(userId);
	}

	///user/createUser(参数见下面)
	@RequestMapping("/createUser")
	public int createUser(User user){
		String userId = System.currentTimeMillis()+"";
		user.setUserId(userId);
		return userService.createUser(user);
	}
}
