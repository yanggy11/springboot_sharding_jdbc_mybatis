package com.yanggy.springboot.service.jwt;

import com.yanggy.springboot.dto.out.UserOutDto;
import com.yanggy.springboot.dto.out.UserRoleDto;
import com.yanggy.springboot.entity.User;
import com.yanggy.springboot.jwt.JwtUserFactory;
import com.yanggy.springboot.mapper.UserMapper;
import com.yanggy.springboot.mapper.UserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by yangguiyun on 2017/9/26.
 */

@Service("userDetailsService")
public class JwtUserDetailsService implements UserDetailsService {
    @Resource
    private UserMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = new User();
        try {
            user = userMapper.findByName(name);
        }catch (Exception e) {
            e.printStackTrace();
        }
        if(null == user) {
            throw  new UsernameNotFoundException(String.format("No user found with username '%s'.", name));
        }
        List<UserRoleDto> userRoles = userRoleMapper.getUserRoles(user.getId());
        List<String> authorities = userRoles.stream().map(userRole -> userRole.getRole()).collect(Collectors.toList());

        return JwtUserFactory.create(user, authorities);
    }
}
