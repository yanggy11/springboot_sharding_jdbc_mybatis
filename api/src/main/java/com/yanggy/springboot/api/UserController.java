package com.yanggy.springboot.api;

import com.yanggy.springboot.common.ResponseEntityDto;
import com.yanggy.springboot.dto.in.UserParam;
import com.yanggy.springboot.entity.User;
import com.yanggy.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yangguiyun on 2017/9/26.
 */

@RestController
@RequestMapping("/user/**")
public class UserController {
    @Autowired
    private UserService userService;

    @PreAuthorize("hasAnyRole('ROLE_USER_QUERY')")
    @RequestMapping(value = "userList", method = RequestMethod.POST)
    public ResponseEntityDto<?> getUsers(@RequestBody UserParam userParam) {
        return userService.getUsers(userParam);
    }
    @RequestMapping(value = "getUserById", method = RequestMethod.POST)
    public ResponseEntityDto<?> getUserById(@RequestBody UserParam userParam) {
        return userService.getUserById(userParam);
    }
}
