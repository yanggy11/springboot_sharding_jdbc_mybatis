/**
 * Copyright by mobanker and the original author or authors.
 * <p>
 * This document only allow internal use, Any of your behaviors using the file
 * not internal will pay legal responsibility.
 * <p>
 * You may learn more information about mobanker from
 * <p>
 * http://www.mobanker.com/
 */
package com.yanggy.springboot.common;

import com.yanggy.springboot.utils.Constants;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class ResponseEntityDto<T> implements Serializable {
    private static final long serialVersionUID = -6084986082723960292L;

    private String status = Constants.ReturnCode.OK;
    private String error;
    private String msg;
    private T data;

    public ResponseEntityDto() {
    }

    /**
     * @param status
     *            状态
     */
    public ResponseEntityDto(String status) {
        this.status = status;
    }

    /**
     * @param status
     *            状态
     * @param error
     *            错误码
     */
    public ResponseEntityDto(String status, String error) {
        this.status = status;
        this.error = error;
    }

    /**
     *
     * @param status
     *            状态
     * @param error
     *            错误码
     * @param msg
     *            错误信息
     */
    public ResponseEntityDto(String status, String error, String msg) {
        this.status = status;
        this.error = error;
        this.msg = msg;
    }

    /**
     *
     * @param status
     *            状态
     * @param error
     *            错误码
     * @param msg
     *            错误信息
     * @param data
     *            返回数据
     */
    public ResponseEntityDto(String status, String error, String msg, T data) {
        this.status = status;
        this.error = error;
        this.msg = msg;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public ResponseEntityDto<T> setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getError() {
        return error;
    }

    public ResponseEntityDto<T> setError(String error) {
        this.error = error;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ResponseEntityDto<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResponseEntityDto<T> setData(T data) {
        this.data = data;
        return this;
    }
}
