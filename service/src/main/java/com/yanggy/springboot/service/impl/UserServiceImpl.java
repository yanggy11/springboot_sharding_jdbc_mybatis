package com.yanggy.springboot.service.impl;

import com.yanggy.springboot.dto.UserParam;
import com.yanggy.springboot.entity.User;
import com.yanggy.springboot.mapper.UserMapper;
import com.yanggy.springboot.service.UserService;
import io.shardingjdbc.core.keygen.DefaultKeyGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> getUsers(UserParam userParam) {
        return new ResponseEntity<Object>(userMapper.getUserList(userParam),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> addUser(User user) {
        userMapper.insertUser(user);
        return new ResponseEntity<Object>(user,HttpStatus.OK);
    }
}