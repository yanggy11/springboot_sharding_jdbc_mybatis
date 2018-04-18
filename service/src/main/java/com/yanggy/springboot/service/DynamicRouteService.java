package com.yanggy.springboot.service;

import com.yanggy.springboot.common.ResponseEntityDto;
import com.yanggy.springboot.dto.in.DynamicRouteParam;
import com.yanggy.springboot.entity.DynamicRoute;

/**
 * Created by yangguiyun on 2018/4/18.
 */
public interface DynamicRouteService {

    ResponseEntityDto<?> getRoutesByPage(DynamicRouteParam dynamicRouteParam);

    ResponseEntityDto<?> getRoutes(DynamicRouteParam dynamicRouteParam);

    ResponseEntityDto<?> addRoute(DynamicRoute dynamicRoute);

    ResponseEntityDto<?> editRoute(DynamicRoute dynamicRoute);
}
