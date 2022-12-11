package com.gordon.service;

import com.gordon.mapper.UserMapper;
import com.gordon.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author:dongchen
 * @Date: 2022/11/20 09:53
 */
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserMapper userMapper;

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public int addUser(User user) {
		//User user = new User(100, "zhangsan", 10);
		int result = userMapper.addUser(user);
		System.out.println(1/0);
		return result;

	}
}
