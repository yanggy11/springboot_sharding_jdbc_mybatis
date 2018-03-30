package com.yanggy.springboot.service.impl;

import com.yanggy.springboot.common.ResponseEntityBuilder;
import com.yanggy.springboot.common.ResponseEntityDto;
import com.yanggy.springboot.dto.UserParam;
import com.yanggy.springboot.entity.User;
import com.yanggy.springboot.mapper.UserMapper;
import com.yanggy.springboot.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by yangguiyun on 2017/9/26.
 */

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public ResponseEntityDto<?> getUsers(UserParam userParam) {
        return ResponseEntityBuilder.buildNormalResponse(userMapper.getUserList(userParam));
    }

    @Override
    public ResponseEntityDto<?> addUser(User user) {
        userMapper.insertUser(user);
        UserParam userParam = new UserParam();
        userParam.setUserId(user.getId());
        return ResponseEntityBuilder.buildNormalResponse(userMapper.getUserById(userParam));
    }

    @Override
    public ResponseEntityDto<?> getUserById(UserParam userParam) {
        return ResponseEntityBuilder.buildNormalResponse(userMapper.getUserById(userParam));
    }
}