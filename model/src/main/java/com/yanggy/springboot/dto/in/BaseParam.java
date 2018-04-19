package com.yanggy.springboot.dto.in;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: yangguiyun
 * @Date: 2018/4/9 10:25
 * @Description:
 */

@Data
public abstract class BaseParam implements Serializable {
    protected int pageNo = 1;
    protected int pageSize = 20;
    protected int offset;
    protected Long timeBegin;
    protected Long timeEnd;
    /**
     * 用户id
     */
    protected Long userId;
    /**
     * 分页查询id条件，每页最后一条数据的id,根据id排序
     */
    protected Long lastId;

    public int getOffset() {
        if(this.pageNo <1 || this.pageSize < 1) {
            return  -1;
        }

        return (this.pageNo - 1) * this.pageSize;
    }
}
