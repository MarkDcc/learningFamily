package com.gordon.mybatis;

import com.gordon.mybatis.mapper.DynamicMapper;
import com.gordon.mybatis.pojo.User;
import com.gordon.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;

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
    public void testinsertByBatch(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicMapper mapper = sqlSession.getMapper(DynamicMapper.class);
        User user1 = new User(null,"11","12345",23,"男","12345@qq.com");
        User user2 = new User(null,"22","12345",23,"男","12345@qq.com");
        User user3 = new User(null,"333","12345",23,"男","12345@qq.com");
        System.out.println(mapper.addByBatch(Arrays.asList(user1,user2,user3)));

    }
}
