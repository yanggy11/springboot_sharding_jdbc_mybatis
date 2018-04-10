package com.yanggy.springboot.jdk_code;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: yangguiyun
 * @Date: 2018/4/8 14:04
 * @Description:
 */

@Data
public class Student implements Serializable {
    private int id;
    private String stuName;
    private String stuNo;
    private int stuAge;
    private Integer Fee;
    private String sex;
}
