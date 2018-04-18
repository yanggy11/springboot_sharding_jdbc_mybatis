package com.yanggy.springboot.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: yangguiyun
 * @Date: 2018/4/18 14:58
 * @Description:
 */

@Data
public abstract class BaseEntity implements Serializable {
    private Date addTime;
    private Date updateTime;
    private short deleteFlag;
}
