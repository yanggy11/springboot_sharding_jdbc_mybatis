package com.yanggy.springboot.mapper;

import com.yanggy.springboot.dto.out.UserRoleDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by yangguiyun on 2018/4/19.
 */

@Mapper
public interface UserRoleMapper {
    List<UserRoleDto> getUserRoles(@Param("userId") Long userId);
}
