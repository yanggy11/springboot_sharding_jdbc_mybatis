package com.yanggy.springboot.dto.out;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: yangguiyun
 * @Date: 2018/4/19 11:29
 * @Description:
 */

@Data
public class UserRoleDto implements Serializable {
    private Long userId;
    private Long roleId;
    private String role;
    private String roleName;
}
