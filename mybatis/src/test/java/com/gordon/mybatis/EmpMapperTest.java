package com.gordon.mybatis;

import com.gordon.mybatis.mapper.EmpMapper;
import com.gordon.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author dongchen
 * @Data 2022/9/3
 * @Time 16:40
 */
public class EmpMapperTest {

    @Test
    public void testgetEmpById(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        System.out.println(mapper.getEmpById(1));
    }

    @Test
    public void testgetEmpAndDeptById(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        System.out.println(mapper.getEmpAndDeptById(1));
        System.out.println(mapper.getEmpAndDeptById(1));
    }


    @Test
    public void testgetEmpAndDeptByStepById(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        System.out.println(mapper.getEmpAndDeptByStepById(1));
    }
}
