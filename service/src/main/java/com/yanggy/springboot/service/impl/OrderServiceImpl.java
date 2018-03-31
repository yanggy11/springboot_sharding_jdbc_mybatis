package com.yanggy.springboot.service.impl;

import com.yanggy.springboot.common.ResponseEntityBuilder;
import com.yanggy.springboot.common.ResponseEntityDto;
import com.yanggy.springboot.dto.OrderParam;
import com.yanggy.springboot.entity.Orders;
import com.yanggy.springboot.mapper.OrderMapper;
import com.yanggy.springboot.service.OrderService;
import com.yanggy.springboot.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author derrick.yang
 * @Date 3/22/18 22:26
 */

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public ResponseEntityDto<?> addOrder(Orders orders) {
        return ResponseEntityBuilder.buildNormalResponse(orderMapper.addOrder(orders));
    }

    @Override
    public ResponseEntityDto<?> getOrdersList(OrderParam order) {
        List<Map> orders = orderMapper.getOrders(order);

        Object lastId = null;
        if(null != orders && orders.size() > 0) {
            lastId = orders.get(orders.size() - 1).get("id");
        }

        return ResponseEntityBuilder.buildNormalResponse(PageUtils.buildPage(order.getPageNo(), order.getPageSize(),
                orderMapper.countOrders(order), orders, lastId));
    }

    @Override
    public ResponseEntityDto<?> getOrderInfo(OrderParam orderParam) {
        return ResponseEntityBuilder.buildNormalResponse(orderMapper.getOrderInfo(orderParam));
    }
}
