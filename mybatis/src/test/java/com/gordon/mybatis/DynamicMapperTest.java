package com.gordon.mybatis;

import com.gordon.mybatis.mapper.DynamicMapper;
import com.gordon.mybatis.mapper.DynamicSysUserMapper;
import com.gordon.mybatis.mapper.SysUserMapper;
import com.gordon.mybatis.pojo.SysUser;
import com.gordon.mybatis.pojo.User;
import com.gordon.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.javassist.expr.NewArray;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author dongchen
 * @Data 2022/9/4
 * @Time 12:55
 */
public class DynamicMapperTest {
    @Test
    public void testGetUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicMapper mapper = sqlSession.getMapper(DynamicMapper.class);
        User user = new User(null," ","12345",23,"男","12345@qq.com");
        System.out.println(mapper.getUser(user));

    }

    @Test
    public void testDeleteByBatch(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicMapper mapper = sqlSession.getMapper(DynamicMapper.class);
        //User user = new User(null," ","12345",23,"男","12345@qq.com");
        System.out.println(mapper.deleteByBatch(new Integer[]{3,4,7,8}));

    }

    @Test
    public void testinsertByBatch() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicMapper mapper = sqlSession.getMapper(DynamicMapper.class);
        User user1 = new User(null, "11", "12345", 23, "男", "12345@qq.com");
        User user2 = new User(null, "22", "12345", 23, "男", "12345@qq.com");
        User user3 = new User(null, "333", "12345", 23, "男", "12345@qq.com");
        System.out.println(mapper.addByBatch(Arrays.asList(user1, user2, user3)));

    }

    @Test
    public void testGetAllUser() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSysUserMapper mapper = sqlSession.getMapper(DynamicSysUserMapper.class);
        List<SysUser> users = mapper.getAllUser();
        for (SysUser user : users) {
            System.out.println("user = " + user);
        }
    }

    @Test
    public void testInsertUser() {
        SysUser sysUser = new SysUser();
        sysUser.setUserName("zhangsan");
        sysUser.setUserPassword(null);
        sysUser.setCreateTime(null);
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSysUserMapper mapper = sqlSession.getMapper(DynamicSysUserMapper.class);
        System.out.println("mapper.insertUser(sysUser) = " + mapper.insertUser(sysUser));

    }

    @Test
    public void testinsertUserWithCondition() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSysUserMapper mapper = sqlSession.getMapper(DynamicSysUserMapper.class);
        SysUser sysUser = new SysUser();
        sysUser.setUserPassword("123");
        sysUser.setUserName("wangwu");
        mapper.insertUserWithCondition(sysUser);
    }

    @Test
    public void testgetUser1() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSysUserMapper mapper = sqlSession.getMapper(DynamicSysUserMapper.class);
        SysUser sysUser = new SysUser();
//        sysUser.setUserName("wangwu");
//        sysUser.setUserPassword("123");
        List<SysUser> user1 = mapper.getUser1(sysUser);
        for (SysUser user : user1) {
            System.out.println("user = " + user);
        }
    }

    @Test
    public void testgetUser2() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSysUserMapper mapper = sqlSession.getMapper(DynamicSysUserMapper.class);
        SysUser sysUser = new SysUser();
        sysUser.setUserName("wangwu");
        sysUser.setUserPassword("123");
        List<SysUser> user2 = mapper.getUser2(sysUser);
        for (SysUser user : user2) {
            System.out.println("user = " + user);
        }
    }

    @Test
    public void testgetUser3() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSysUserMapper mapper = sqlSession.getMapper(DynamicSysUserMapper.class);
        List<Integer> ids = new ArrayList<>();
        ids.add(1036);
        ids.add(1035);
        List<SysUser> user3 = mapper.getUser3(ids);
        for (SysUser user : user3) {
            System.out.println("user = " + user);
        }
    }

    @Test
    public void testaddUsers(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSysUserMapper mapper = sqlSession.getMapper(DynamicSysUserMapper.class);
        List<SysUser> users = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            SysUser sysUser = new SysUser();
            sysUser.setUserName("zhangsan"+i);
            sysUser.setUserPassword("ppp"+i);
            sysUser.setCreateTime(new Date());
            users.add(sysUser);
        }
        mapper.addUsers(users);
    }
}
