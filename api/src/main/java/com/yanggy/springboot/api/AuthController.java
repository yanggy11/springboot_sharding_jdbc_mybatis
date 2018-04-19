package com.yanggy.springboot.api;

import com.yanggy.springboot.common.ResponseEntityDto;
import com.yanggy.springboot.dto.in.UserParam;
import com.yanggy.springboot.entity.User;
import com.yanggy.springboot.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: yangguiyun
 * @Date: 2018/4/19 9:48
 * @Description:
 */
@RestController
@RequestMapping("/auth/**")
public class AuthController {
    @Resource
    private AuthService authService;

    @PostMapping(value = "login")
    public ResponseEntityDto<?> createAuthenticationToken(@RequestBody UserParam userParam)  {

        return authService.login(userParam.getName(), userParam.getPassword());
    }

    @PostMapping(value = "register")
    public ResponseEntityDto<?> register(@RequestBody User user) {
        return null;
    }
}
