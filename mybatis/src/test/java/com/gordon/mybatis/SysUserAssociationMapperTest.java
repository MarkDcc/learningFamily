package com.gordon.mybatis;

import com.gordon.mybatis.mapper.DynamicSysUserMapper;
import com.gordon.mybatis.mapper.SysUserAssociationMapper;
import com.gordon.mybatis.pojo.SysUser;
import com.gordon.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @Author:dongchen
 * @Date: 2022/12/10 14:07
 */
public class SysUserAssociationMapperTest {
//	@Test
//	public void testgetUser() {
//		SqlSession sqlSession = SqlSessionUtils.getSqlSession();
//		SysUserAssociationMapper mapper = sqlSession.getMapper(SysUserAssociationMapper.class);
//		SysUser user = mapper.getUser(1001);
////		System.out.println(user);
//		Assert.assertNotNull(user);
//		//测试懒加载
//		System.out.println("调用getRole()");
//		System.out.println("user.getRole() = " + user.getRole());
//	}

	@Test
	public void testgetUserAndRoles() {
		SqlSession sqlSession = SqlSessionUtils.getSqlSession();
		SysUserAssociationMapper mapper = sqlSession.getMapper(SysUserAssociationMapper.class);
		List<SysUser> userAndRoles = mapper.getUserAndRoles();

		for (SysUser userAndRole : userAndRoles) {
			System.out.println(userAndRole);
		}
	}

}
