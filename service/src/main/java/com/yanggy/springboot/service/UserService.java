package com.yanggy.springboot.service;

import com.yanggy.springboot.dto.UserParam;
import com.yanggy.springboot.entity.User;
import org.springframework.http.ResponseEntity;

/**
 * Created by yangguiyun on 2017/9/26.
 */
public interface UserService {
    ResponseEntity<?> getUsers(UserParam userParam);

    ResponseEntity<?> addUser(User user);

    ResponseEntity<?> getUserById(UserParam userParam);
}
