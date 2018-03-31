package com.yanggy.springboot.dto.out;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author derrick.yang
 * @Date 3/31/18 21:02
 */

@Data
public class OderDto implements Serializable {
    private Long orderId;
    private Long userId;
    private String name;
    private int price;
    private String address;
    private Date addTime;
    private Date updateTime;
}
