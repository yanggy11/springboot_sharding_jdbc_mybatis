package com.yanggy.springboot.datasource;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: yangguiyun
 * @Date: 2018/3/22 10:44
 * @Description:
 */

@Configuration
@Data
public class ShardingProperties {
    @Value("${master.driver-class-name}")
    private String driverClassName;
    @Value("${master.url}")
    private String url;
    @Value("${slave.url}")
    private String url2;
    @Value("${slave2.url}")
    private String url3;
    @Value("${master.username}")
    private String username;
    @Value("${master.password}")
    private String password;
    @Value("${master.initialSize}")
    private String initialSize;
    @Value("${master.minIdle}")
    private String minIdle;
    @Value("${master.maxActive}")
    private String maxActive;
    @Value("${master.maxWait}")
    private String maxWait;
}
