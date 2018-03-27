/*
 * Copyright by mobanker and the original author or authors.
 * 
 * This document only allow internal use ,Any of your behaviors using the file
 * not internal will pay legal responsibility.
 *
 * You may learn more information about mobanker from
 *
 *      http://www.mobanker.com/
 *
 */
package com.yanggy.springboot.template;

import com.yanggy.springboot.common.ResponseEntityDto;

/**
 * 回调接口，参照spring jdbctemplate ConnectionCallback
 * 
 * @author chenjian
 * @since 2016年12月20日 上午10:22:04
 */
public interface Callback<T> {

    /**
     * 回调执行方法
     *
     * @author chenjian
     * @since 2017年9月5日 下午2:58:39
     * @param res
     * @see
     */
    void doExecute(ResponseEntityDto<T> res);
}
