package com.yanggy.springboot.mapper;


import com.yanggy.springboot.dto.in.UserParam;
import com.yanggy.springboot.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by yangguiyun on 2017/6/1.
 */

@Mapper
public interface UserMapper {

    int insertUser(User user);
    List<User> getUserList(UserParam userParam);

    User getUserById(UserParam userParam);

    Integer getUserCount(UserParam userParam);

    User findByName(@Param("name") String name);
}
