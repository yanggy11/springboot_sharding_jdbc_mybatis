package com.yanggy.springboot.service.impl;

import com.yanggy.springboot.common.ResponseEntityBuilder;
import com.yanggy.springboot.common.ResponseEntityDto;
import com.yanggy.springboot.dto.UserParam;
import com.yanggy.springboot.entity.User;
import com.yanggy.springboot.mapper.UserMapper;
import com.yanggy.springboot.service.UserService;
import com.yanggy.springboot.utils.PageUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.CompletableFuture;

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
        List<User> users = userMapper.getUserList(userParam);
        Integer usersCount = userMapper.getUserCount(userParam);
        return ResponseEntityBuilder.buildNormalResponse(PageUtils.buildPage(userParam.getPageNo(), userParam.getPageSize(), usersCount, users));
    }

    @Override
    public ResponseEntityDto<?> addUser(User user) {

        userMapper.insertUser(user);
        return ResponseEntityBuilder.buildNormalResponse(user);
    }

    @Override
    public ResponseEntityDto<?> getUserById(UserParam userParam) {
        return ResponseEntityBuilder.buildNormalResponse(userMapper.getUserById(userParam));
    }
}