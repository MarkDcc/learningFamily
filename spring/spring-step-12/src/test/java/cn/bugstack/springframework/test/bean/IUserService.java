package cn.bugstack.springframework.test.bean;

/**
 * @Author:dongchen
 * @Date: 2023/5/14 12:11
 */
public interface IUserService {
	String queryUserInfo();

	String register(String userName);
}
