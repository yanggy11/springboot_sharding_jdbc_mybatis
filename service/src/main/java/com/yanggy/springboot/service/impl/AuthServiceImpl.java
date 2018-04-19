package com.yanggy.springboot.service.impl;

import com.yanggy.springboot.common.ResponseEntityBuilder;
import com.yanggy.springboot.common.ResponseEntityDto;
import com.yanggy.springboot.dto.out.UserOutDto;
import com.yanggy.springboot.dto.out.UserRoleDto;
import com.yanggy.springboot.entity.User;
import com.yanggy.springboot.jwt.JWTUser;
import com.yanggy.springboot.jwt.JwtTokenUtil;
import com.yanggy.springboot.mapper.UserMapper;
import com.yanggy.springboot.mapper.UserRoleMapper;
import com.yanggy.springboot.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: yangguiyun
 * @Date: 2018/4/19 9:51
 * @Description:
 */

@Service
@Transactional
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Override
    public ResponseEntityDto<?> register(User userToAdd) {
        userMapper.insertUser(userToAdd);

        return ResponseEntityBuilder.buildNormalResponse();
    }

    @Override
    public ResponseEntityDto<?> login(String username, String password) {
        Authentication authentication = null;
        UserOutDto userOutDto = null;

        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);
        authentication = authenticationManager.authenticate(upToken);
        StringBuilder token = new StringBuilder(this.tokenHead);

        if(authentication.isAuthenticated()) {
            JWTUser jwtUser = (JWTUser) authentication.getPrincipal();
            token.append(jwtTokenUtil.generateToken(jwtUser));

            List<UserRoleDto> roles = userRoleMapper.getUserRoles(jwtUser.getUserId());
            userOutDto = this.buildUserOutDto(jwtUser, token.toString(), roles);
        } else {
            throw new BadCredentialsException("授权认证错误，用户名或密码错误");
        }

        return ResponseEntityBuilder.buildNormalResponse(userOutDto);
    }

    private UserOutDto buildUserOutDto(JWTUser user, String token, List<UserRoleDto> roles) {
        UserOutDto userOutDto = new UserOutDto();
        userOutDto.setUserId(user.getUserId());
        userOutDto.setName(user.getUsername());
        userOutDto.setRoles(roles);
        userOutDto.setToken(token);
        userOutDto.setPhone(user.getPhone());

        return userOutDto;
    }
}
