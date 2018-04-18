package com.yanggy.springboot.api;

import com.yanggy.springboot.common.ResponseEntityDto;
import com.yanggy.springboot.dto.in.DynamicRouteParam;
import com.yanggy.springboot.entity.DynamicRoute;
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

    ResponseEntityDto<?> getRoutesByPage(DynamicRouteParam dynamicRouteParam) {
        return dynamicRouteService.getRoutesByPage(dynamicRouteParam);
    }

    ResponseEntityDto<?> getRoutes(DynamicRouteParam dynamicRouteParam) {
        return dynamicRouteService.getRoutes(dynamicRouteParam);
    }

    ResponseEntityDto<?> addRoute(DynamicRoute dynamicRoute) {
        return dynamicRouteService.addRoute(dynamicRoute);
    }

    ResponseEntityDto<?> editRoute(DynamicRoute dynamicRoute) {
        return dynamicRouteService.editRoute(dynamicRoute);
    }
}
