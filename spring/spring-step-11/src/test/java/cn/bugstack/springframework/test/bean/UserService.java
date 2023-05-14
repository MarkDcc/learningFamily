package cn.bugstack.springframework.test.bean;

import java.util.Random;

/**
 * @Author:dongchen
 * @Date: 2023/5/14 12:11
 */
public class UserService implements IUserService {

	public String queryUserInfo() {
		try {
			Thread.sleep(new Random(1).nextInt(100));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "小傅哥，100001，深圳";
	}

	public String register(String userName) {
		try {
			Thread.sleep(new Random(1).nextInt(100));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "注册用户：" + userName + " success！";
	}

}
