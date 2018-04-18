package com.yanggy.springboot.service.impl;

import com.yanggy.springboot.common.ResponseEntityDto;
import com.yanggy.springboot.dto.in.DynamicRouteParam;
import com.yanggy.springboot.mapper.DynamicRouteMapper;
import com.yanggy.springboot.service.DynamicRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return null;
    }

    @Override
    public ResponseEntityDto<?> getRoutes(DynamicRouteParam dynamicRouteParam) {
        return null;
    }

    @Override
    public ResponseEntityDto<?> addRoute(DynamicRouteParam dynamicRouteParam) {
        return null;
    }

    @Override
    public ResponseEntityDto<?> editRoute(DynamicRouteParam dynamicRouteParam) {
        return null;
    }
}
