package com.yanggy.springboot.api;

import com.yanggy.springboot.service.DynamicRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yangguiyun
 * @Date: 2018/4/18 15:44
 * @Description:
 */

@RestController
@RequestMapping("/dynamic/route/**")
public class DynamicRouteController {
    @Autowired
    private DynamicRouteService dynamicRouteService;
}
