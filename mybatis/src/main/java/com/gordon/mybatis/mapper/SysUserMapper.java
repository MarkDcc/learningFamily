package com.gordon.mybatis.mapper;

import com.gordon.mybatis.pojo.SysRole;
import com.gordon.mybatis.pojo.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author:dongchen
 * @Date: 2022/11/27 13:08
 */
public interface SysUserMapper {

	SysUser selectSysUserById(@Param("id") Long id);

	List<SysRole> selectSysRoleBySysUserId(@Param("id") Long id);

	int insert(@Param("user") SysUser user);

	int deleteUser(@Param("id") Long id);
}
