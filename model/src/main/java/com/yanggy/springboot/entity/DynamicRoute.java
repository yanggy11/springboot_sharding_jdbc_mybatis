package com.yanggy.springboot.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: yangguiyun
 * @Date: 2018/4/18 15:01
 * @Description:
 */

@Data
public class DynamicRoute extends BaseEntity implements Serializable {
    private Long dynamicId;
    private String id;
    private String path;
    private String serviceId;
    private String url;
    private boolean stripPrefix;
    private boolean retryable;
    private boolean enabled;
}
