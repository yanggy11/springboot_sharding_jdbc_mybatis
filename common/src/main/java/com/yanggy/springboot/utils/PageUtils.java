package com.yanggy.springboot.utils;

/**
 * @Author: yangguiyun
 * @Date: 2018/3/30 11:52
 * @Description:
 */
public final class PageUtils {
    /**
     * 构造分页对象
     *
     * @param pageNo
     * @param pageSize
     * @param count
     * @param data
     * @return
     */
    public static Page buildPage(int pageNo, int pageSize, int count, Object data, Object lastId) {
        int totalPage = count / pageSize;
        int restPage = count % pageSize;
        totalPage = 0 == restPage ? totalPage : totalPage + 1;

        return new Page(pageNo, pageSize, count, totalPage, lastId, data);
    }
}
