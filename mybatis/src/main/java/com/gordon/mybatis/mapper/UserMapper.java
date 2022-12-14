package com.gordon.mybatis.mapper;

import com.gordon.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author dongchen
 * @Data 2022/9/1
 * @Time 22:27
 */
public interface UserMapper {
    /**
     * 映射文件的namespace要和mapper接口名一致
     * id要和方法名一致
     * @return
     */
    int insertUser();

    void updateUser();

    int deleteUser();

    User getUserById();

    List<User> getAllUsers(@Param("id") Integer id);

}
