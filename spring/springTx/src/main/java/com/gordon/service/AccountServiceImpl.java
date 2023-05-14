package com.gordon.service;

import com.gordon.mapper.AccountMapper;
import com.gordon.mapper.UserMapper;
import com.gordon.pojo.Account;
import com.gordon.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author:dongchen
 * @Date: 2022/11/20 09:47
 */
@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	AccountMapper accountMapper;

	@Transactional(propagation = Propagation.NEVER)
	@Override
	public int addAccount(Account account) {
		int result = accountMapper.addAccount(account);
//		userService.addUser(new User(200,"lisi",15));
		System.out.println(1/0);
		return result;
	}
}
