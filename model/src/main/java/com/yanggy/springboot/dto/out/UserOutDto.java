package com.yanggy.springboot.dto.out;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: yangguiyun
 * @Date: 2018/4/19 13:44
 * @Description:
 */

@Data
@RequiredArgsConstructor
public class UserOutDto implements Serializable {
    private Long userId;
    private String name;
    private List<UserRoleDto> roles;
    private String phone;
    private String token;
}
