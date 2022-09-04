package com.gordon.mybatis.mapper;

import com.gordon.mybatis.pojo.User;

import java.util.List;

/**
 * @author dongchen
 * @Data 2022/9/3
 * @Time 11:01
 */
public interface ParameterMapper {
    List<User> getAllUser();

    User getUserByUsername(String username);

    User checkLogin(String username,String password);
}
