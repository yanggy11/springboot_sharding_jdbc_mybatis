package com.yanggy.springboot.service;

import com.yanggy.springboot.common.ResponseEntityDto;
import com.yanggy.springboot.dto.in.DynamicRouteParam;

/**
 * Created by yangguiyun on 2018/4/18.
 */
public interface DynamicRouteService {

    ResponseEntityDto<?> getRoutesByPage(DynamicRouteParam dynamicRouteParam);

    ResponseEntityDto<?> getRoutes(DynamicRouteParam dynamicRouteParam);

    ResponseEntityDto<?> addRoute(DynamicRouteParam dynamicRouteParam);

    ResponseEntityDto<?> editRoute(DynamicRouteParam dynamicRouteParam);
}
