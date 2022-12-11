package com.ssm.service.impl;

import com.ssm.mapper.UserMapper;
import com.ssm.pojo.User;
import com.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author:dongchen
 * @Date: 2022/11/27 19:06
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserMapper userMapper;

	@Override
	public List<User> selectUserPage(String userName, String userSex, int startRow) {
		return userMapper.selectUserPage(userName,userSex,startRow);
	}

	@Override
	public int createUser(User user) {
		return userMapper.createUser(user);
	}

	@Override
	public int deleteUserById(String id) {
		return userMapper.deleteUserById(id);
	}

	@Override
	public int getRowCount(String userName, String userSex) {
		return userMapper.getRowCount(userName,userSex);
	}
}
