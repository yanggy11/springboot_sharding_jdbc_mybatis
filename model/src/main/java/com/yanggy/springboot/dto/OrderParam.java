package com.yanggy.springboot.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author derrick.yang
 * @Date 3/22/18 22:27
 */

@Data
public class OrderParam implements Serializable {
    private Long userId;
    private Long orderId;
    private int pageNo = 1;
    private int pageSize = 20;
    private int offset;

    public int getOffset() {
        if(this.pageNo <1 || this.pageSize < 1) {
            return  -1;
        }

        return (this.pageNo - 1) * this.pageSize;
    }
}
