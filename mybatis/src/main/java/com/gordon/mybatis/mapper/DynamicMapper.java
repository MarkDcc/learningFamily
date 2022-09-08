package com.gordon.mybatis.mapper;

/**
 * @author dongchen
 * @Data 2022/9/3
 * @Time 21:35
 */

import com.gordon.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 动态sql
 */
public interface DynamicMapper {

   User getUser(@Param("user") User user);

   int deleteByBatch(@Param("ids") Integer[] ids);

   int addByBatch(@Param("users")List<User> users);
}
