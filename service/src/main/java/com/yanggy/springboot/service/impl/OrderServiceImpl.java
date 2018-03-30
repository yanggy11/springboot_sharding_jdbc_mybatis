package com.yanggy.springboot.service.impl;

import com.yanggy.springboot.common.ResponseEntityBuilder;
import com.yanggy.springboot.common.ResponseEntityDto;
import com.yanggy.springboot.dto.OrderParam;
import com.yanggy.springboot.entity.Orders;
import com.yanggy.springboot.mapper.OrderMapper;
import com.yanggy.springboot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return ResponseEntityBuilder.buildNormalResponse(orderMapper.getOrdersByUserId(order));
    }
}
