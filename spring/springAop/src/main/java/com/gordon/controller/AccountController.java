package com.gordon.controller;

import com.gordon.pojo.Account;
import com.gordon.service.AccountServiceImpl;
import com.gordon.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @Author:dongchen
 * @Date: 2022/11/19 18:18
 */
public class AccountController {


	private Service service = new AccountServiceImpl();

	public Account getAccount(){
		return service.getAccount();
	}
}
