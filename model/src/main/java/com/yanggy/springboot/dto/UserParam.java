package com.yanggy.springboot.dto;

import lombok.Data;

/**
 * Created by yangguiyun on 2017/9/26.
 */

@Data
public class UserParam {

    private String name;
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
