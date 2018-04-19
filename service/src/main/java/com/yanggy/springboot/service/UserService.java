package com.yanggy.springboot.service;

import com.yanggy.springboot.common.ResponseEntityDto;
import com.yanggy.springboot.dto.in.UserParam;

/**
 * Created by yangguiyun on 2017/9/26.
 */
public interface UserService {
    ResponseEntityDto<?> getUsers(UserParam userParam);

    ResponseEntityDto<?> getUserById(UserParam userParam);
}
