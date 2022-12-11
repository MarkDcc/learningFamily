package com.gordon.service;

import com.gordon.pojo.Account;
import com.gordon.repository.AccountRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author:dongchen
 * @Date: 2022/11/19 18:19
 */

public class AccountServiceImpl implements Service {


	private AccountRepositoryService repositoryService =new AccountRepositoryService();

	@Override
	public Account getAccount() {
		return repositoryService.getAccount();

	}
}
