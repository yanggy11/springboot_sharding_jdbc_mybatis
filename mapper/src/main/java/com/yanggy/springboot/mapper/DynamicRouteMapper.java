package com.yanggy.springboot.mapper;

import com.sun.tools.javac.util.List;
import com.yanggy.springboot.dto.in.DynamicRouteParam;
import com.yanggy.springboot.entity.DynamicRoute;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by yangguiyun on 2018/4/18.
 */

@Mapper
public interface DynamicRouteMapper {
   List<DynamicRoute> getRoutesByPage(DynamicRouteParam dynamicRouteParam);

   List<DynamicRoute> getRoutes(DynamicRouteParam dynamicRouteParam);

    int addRoute(DynamicRoute dynamicRoute);

    int edit(DynamicRoute dynamicRoute);

    int countRoutes(DynamicRouteParam dynamicRouteParam);
}
