package com.gordon.mybatis.mapper;

import com.gordon.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

/**
 * @author dongchen
 * @Data 2022/9/3
 * @Time 16:27
 */
public interface EmpMapper {

    Emp getEmpById(@Param("id") Integer id);

    Emp getEmpAndDeptById(@Param("id") Integer id);

    Emp getEmpAndDeptByStepById(@Param("id") Integer id);
}
