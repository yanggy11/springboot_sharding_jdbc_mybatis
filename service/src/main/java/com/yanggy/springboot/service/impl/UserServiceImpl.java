package com.yanggy.springboot.service.impl;

import com.yanggy.springboot.common.ResponseEntityBuilder;
import com.yanggy.springboot.common.ResponseEntityDto;
import com.yanggy.springboot.dto.in.UserParam;
import com.yanggy.springboot.entity.User;
import com.yanggy.springboot.mapper.UserMapper;
import com.yanggy.springboot.service.UserService;
import com.yanggy.springboot.utils.PageUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yangguiyun on 2017/9/26.
 */

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public ResponseEntityDto<?> getUsers(UserParam userParam) {
        List<User> users = userMapper.getUserList(userParam);

        Object lastId = null;
        if(null != users && users.size() > 0) {
            lastId = users.get(users.size() - 1).getId();
        }
        Integer usersCount = userMapper.getUserCount(userParam);
        return ResponseEntityBuilder.buildNormalResponse(PageUtils.buildPage(userParam.getPageNo(), userParam.getPageSize(), usersCount, users, lastId));
    }

    @Override
    public ResponseEntityDto<?> getUserById(UserParam userParam) {
        return ResponseEntityBuilder.buildNormalResponse(userMapper.getUserById(userParam));
    }
}