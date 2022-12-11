package com.gordon.mybatis.xml;

import com.gordon.mybatis.mapper.SysUserMapper;
import com.gordon.mybatis.pojo.SysRole;
import com.gordon.mybatis.pojo.SysUser;
import com.gordon.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * @Author:dongchen
 * @Date: 2022/11/27 13:03
 */
public class SelectTest {

	@Test
	public void testSelectUserById(){
		SqlSession sqlSession = SqlSessionUtils.getSqlSession();
		SysUserMapper mapper = sqlSession.getMapper(SysUserMapper.class);
		SysUser sysUser = mapper.selectSysUserById(1L);
		System.out.println("sysUser = " + sysUser);
		sqlSession.close();
	}


	@Test
	public void testselectSysRoleBySysUserId(){
		SqlSession sqlSession = SqlSessionUtils.getSqlSession();
		SysUserMapper mapper = sqlSession.getMapper(SysUserMapper.class);
		List<SysRole> sysRoles = mapper.selectSysRoleBySysUserId(1L);
		for (SysRole sysRole : sysRoles) {
			System.out.println("sysRole = " + sysRole);
		}
	}

	@Test
	public void testInsert(){
		SqlSession sqlSession = SqlSessionUtils.getSqlSession();
		SysUserMapper mapper = sqlSession.getMapper(SysUserMapper.class);
		SysUser sysUser = new SysUser();
		sysUser.setUserName("lisi");
		sysUser.setUserInfo("lisi Info");
		sysUser.setUserPassword("123");
		sysUser.setHeadImg(new byte[]{1,2,3});
		sysUser.setCreateTime(new Date());
		int insert = mapper.insert(sysUser);
		System.out.println("insert = " + insert);
		System.out.println(sysUser.getId());

	}

	@Test
	public void testDelete(){
		Long id = 1038L;
		SysUserMapper mapper = SqlSessionUtils.getSqlSession().getMapper(SysUserMapper.class);
		int i = mapper.deleteUser(id);
		System.out.println(i);

	}

}
