package com.yanggy.springboot.dto.in;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by yangguiyun on 2017/9/26.
 */

@Data
public class UserParam extends BaseParam implements Serializable{
    private String name;
    private String password;
}
