package com.yanggy.springboot.jdk_code;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: yangguiyun
 * @Date: 2018/4/8 14:04
 * @Description:
 */

@Data
public class StudentDto implements Serializable{
    private int stuId;
    private String stuName;
    private String stuNo;
    private int stuAge;
}
