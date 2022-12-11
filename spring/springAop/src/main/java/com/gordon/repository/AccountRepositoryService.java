package com.gordon.repository;

import com.gordon.pojo.Account;

/**
 * @Author:dongchen
 * @Date: 2022/11/19 18:20
 */

public class AccountRepositoryService {

	public Account getAccount() {
		return new Account("zhangsan", 123);
	}
}
