package com.yanggy.springboot.service;

import com.yanggy.springboot.common.ResponseEntityDto;
import com.yanggy.springboot.dto.in.UserParam;
import com.yanggy.springboot.entity.User;

/**
 * Created by yangguiyun on 2017/9/26.
 */
public interface UserService {
    ResponseEntityDto<?> getUsers(UserParam userParam);

    ResponseEntityDto<?> addUser(User user);

    ResponseEntityDto<?> getUserById(UserParam userParam);
}
