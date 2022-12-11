package com.gordon.mybatis.mapper;

import com.gordon.mybatis.pojo.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author:dongchen
 * @Date: 2022/12/10 13:49
 */
public interface SysUserAssociationMapper {

	/**
	 * 单个sysRole
	 * @param id
	 * @return
	 */
	SysUser getUser(@Param("id") Integer id);

	List<SysUser>  getUserAndRoles();


}
