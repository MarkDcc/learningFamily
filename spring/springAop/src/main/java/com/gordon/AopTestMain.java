package com.gordon;

import com.gordon.aop.LogAop;
import com.gordon.aop.ProxyObject;
import com.gordon.controller.AccountController;
import com.gordon.pojo.Account;
import com.gordon.service.AccountServiceImpl;
import com.gordon.service.Service;

/**
 * @Author:dongchen
 * @Date: 2022/11/19 18:31
 */
public class AopTestMain {
	public static void main(String[] args) {
		AccountController controller = new AccountController();
		Account account = controller.getAccount();
		System.out.println("account = " + account);

		Service service = (Service) ProxyObject.getObject(new AccountServiceImpl(), new LogAop());
service.getAccount();
	}
}
