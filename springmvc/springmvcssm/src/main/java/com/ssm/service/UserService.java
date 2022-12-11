package com.ssm.service;

import com.ssm.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:dongchen
 * @Date: 2022/11/27 19:04
 */
public interface UserService {

	List<User> selectUserPage(String userName,String userSex,int startRow);

	int createUser(User user);
	int deleteUserById(String id);
	int getRowCount(String userName,String userSex);
}
