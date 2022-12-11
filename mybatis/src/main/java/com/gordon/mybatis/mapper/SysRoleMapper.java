package com.gordon.mybatis.mapper;

import com.gordon.mybatis.pojo.SysRole;
import org.apache.ibatis.annotations.Param;

/**
 * @Author:dongchen
 * @Date: 2022/12/10 14:26
 */
public interface SysRoleMapper {
	SysRole getRole(@Param("id") Integer id);
}
