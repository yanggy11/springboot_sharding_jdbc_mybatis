package com.yanggy.springboot.service.impl;

import com.yanggy.springboot.common.ResponseEntityBuilder;
import com.yanggy.springboot.common.ResponseEntityDto;
import com.yanggy.springboot.dto.in.DynamicRouteParam;
import com.yanggy.springboot.entity.DynamicRoute;
import com.yanggy.springboot.mapper.DynamicRouteMapper;
import com.yanggy.springboot.service.DynamicRouteService;
import com.yanggy.springboot.utils.Page;
import com.yanggy.springboot.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: yangguiyun
 * @Date: 2018/4/18 15:46
 * @Description:
 */

@Service
public class DynamicRouteServiceImpl implements DynamicRouteService{

    @Autowired
    private DynamicRouteMapper dynamicRouteMapper;

    @Override
    public ResponseEntityDto<?> getRoutesByPage(DynamicRouteParam dynamicRouteParam) {
        List<DynamicRoute> routes = dynamicRouteMapper.getRoutesByPage(dynamicRouteParam);
        int routesCount = dynamicRouteMapper.countRoutes(dynamicRouteParam);
        Page<?> page = PageUtils.buildPage(dynamicRouteParam.getPageNo(), dynamicRouteParam.getPageSize(),routesCount, routes, null);

        return ResponseEntityBuilder.buildNormalResponse(page);
    }

    @Override
    public ResponseEntityDto<?> getRoutes(DynamicRouteParam dynamicRouteParam) {
        List<DynamicRoute> routes = dynamicRouteMapper.getRoutes(dynamicRouteParam);

        return ResponseEntityBuilder.buildNormalResponse(routes);
    }

    @Override
    public ResponseEntityDto<?> addRoute(DynamicRoute dynamicRoute) {
        dynamicRouteMapper.addRoute(dynamicRoute);

        return ResponseEntityBuilder.buildNormalResponse();
    }

    @Override
    public ResponseEntityDto<?> editRoute(DynamicRoute dynamicRoute) {
        dynamicRouteMapper.edit(dynamicRoute);

        return ResponseEntityBuilder.buildNormalResponse();
    }
}
