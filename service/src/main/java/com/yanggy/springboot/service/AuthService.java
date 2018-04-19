package com.yanggy.springboot.service;

import com.yanggy.springboot.common.ResponseEntityDto;
import com.yanggy.springboot.entity.User;

/**
 * Created by yangguiyun on 2018/4/19.
 */
public interface AuthService {
    ResponseEntityDto<?> register(User userToAdd);
    ResponseEntityDto<?> login(String username, String password);
}
