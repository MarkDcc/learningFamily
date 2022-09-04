package com.gordon.mybatis.mapper;

import com.gordon.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

/**
 * @author dongchen
 * @Data 2022/9/3
 * @Time 16:26
 */
public interface DeptMapper {
  Dept getDeptById(@Param("did") Integer did);
}
