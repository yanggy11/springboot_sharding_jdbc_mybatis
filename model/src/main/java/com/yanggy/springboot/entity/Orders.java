package com.yanggy.springboot.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author derrick.yang
 * @Date 3/22/18 21:49
 */

@Data
public class Orders implements Serializable {
    private Long id;
    private Long userId;
    private int price;
    private String address;
    private Date addTime;
    private Date updateTime;
}
