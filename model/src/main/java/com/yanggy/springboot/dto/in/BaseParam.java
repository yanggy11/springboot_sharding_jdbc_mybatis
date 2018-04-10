package com.yanggy.springboot.dto.in;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: yangguiyun
 * @Date: 2018/4/9 10:25
 * @Description:
 */

@Data
public class BaseParam implements Serializable {
    private int pageNo = 1;
    private int pageSize = 20;
    private int offset;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 分页查询id条件，每页最后一条数据的id,根据id排序
     */
    private Long lastId;

    public int getOffset() {
        if(this.pageNo <1 || this.pageSize < 1) {
            return  -1;
        }

        return (this.pageNo - 1) * this.pageSize;
    }
}
