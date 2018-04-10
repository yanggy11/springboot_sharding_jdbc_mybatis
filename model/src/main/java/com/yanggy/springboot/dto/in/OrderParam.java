package com.yanggy.springboot.dto.in;

import lombok.Data;

import java.io.Serializable;

/**
 * @author derrick.yang
 * @Date 3/22/18 22:27
 */

@Data
public class OrderParam extends BaseParam implements Serializable {
    private Long orderId;
}
