package com.gordon.mapper;

import com.gordon.pojo.Account;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author:dongchen
 * @Date: 2022/11/20 09:45
 */

public interface AccountMapper {
	int addAccount(Account account);
}
