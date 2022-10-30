package com.gordon.springboot.mybatis.mapper;

import com.gordon.springboot.mybatis.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author dongchen
 * @Data 2022/9/8
 * @Time 22:00
 */
@Mapper
public interface UserMapper {

    User getUserById(@Param("id") Integer id);
}
