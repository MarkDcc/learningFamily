package com.gordon.mybatis;

import com.gordon.mybatis.mapper.SysRoleMapper;
import com.gordon.mybatis.mapper.SysUserAssociationMapper;
import com.gordon.mybatis.pojo.SysRole;
import com.gordon.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @Author:dongchen
 * @Date: 2022/12/10 14:37
 */
public class SysRoleMapperTest {
	@Test
	public void testgetSysRole(){
		SqlSession sqlSession = SqlSessionUtils.getSqlSession();
		SysRoleMapper mapper = sqlSession.getMapper(SysRoleMapper.class);
		SysRole role = mapper.getRole(1);
		System.out.println(role);
	}
}
