package com.yanggy.springboot.utils;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

/**
 * @Author: yangguiyun
 * @Date: 2018/3/30 11:46
 * @Description:
 */

@Data
public class Page<T> implements Serializable {
    private int pageNo = 1;
    private int pageSize = 20;
    private int totalRecords;
    private int totalPage;
    private int offset;

    private T data;

    public int getOffset() {
        return (this.pageNo - 1) * this.pageSize;
    }

    public Page(int pageNo, int pageSize, int totalRecords, int totalPage, T data) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalRecords = totalRecords;
        this.totalPage = totalPage;
        this.data = data;
    }

    public Page() {
    }
}
