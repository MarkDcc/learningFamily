package com.gordon.mybatis.mapper;

import com.gordon.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author dongchen
 * @Data 2022/9/3
 * @Time 15:34
 */
public interface SelectMapper {

    /*
    实现一个返回类型是map的例子
     */
    @MapKey("id")
    Map<String,Object> getAllUserToMap();

    List<User> getUserByLike(@Param("username") String username);

}
