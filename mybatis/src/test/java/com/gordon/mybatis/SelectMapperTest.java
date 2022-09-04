package com.gordon.mybatis;

import com.gordon.mybatis.mapper.SelectMapper;
import com.gordon.mybatis.utils.SqlSessionUtils;
import com.mysql.cj.x.protobuf.MysqlxSql;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author dongchen
 * @Data 2022/9/3
 * @Time 15:57
 */
public class SelectMapperTest {
    @Test
    public void testgetAllUserToMap(){

        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getAllUserToMap());
    }

    @Test
    public void testgetUserByLike(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getUserByLike("a"));
    }
}
