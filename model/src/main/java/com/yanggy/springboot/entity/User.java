package com.yanggy.springboot.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by yangguiyun on 2017/6/1.
 */

@Data
public class User implements Serializable {
    private long id;
    private long userId;
    private String password;
    private String name;
    private int age;
    private int deleteFlag;
    private Date addTime;
    private Date updateTime;
}
