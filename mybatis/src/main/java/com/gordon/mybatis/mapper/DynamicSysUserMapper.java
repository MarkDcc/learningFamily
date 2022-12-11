package com.gordon.mybatis.mapper;

import com.gordon.mybatis.pojo.SysUser;
import com.gordon.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author:dongchen
 * @Date: 2022/12/6 17:19
 */
public interface DynamicSysUserMapper {

	/*
	SysUser的所有字段都必须存在
	 */
	List<SysUser> getAllUser();

	Integer insertUser(@Param("user") SysUser user);

	Integer insertUserWithCondition(@Param("user") SysUser user);

	List<SysUser> getUser1(@Param("user") SysUser user);

	List<SysUser> getUser2(@Param("user") SysUser user);

	List<SysUser> getUser3(@Param("ids") List<Integer> ids);

	Integer addUsers(@Param("users") List<SysUser> users);
}
