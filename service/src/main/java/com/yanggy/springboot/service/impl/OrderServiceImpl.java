package com.yanggy.springboot.service.impl;

import com.yanggy.springboot.dto.OrderParam;
import com.yanggy.springboot.entity.Orders;
import com.yanggy.springboot.mapper.OrderMapper;
import com.yanggy.springboot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> addOrder(Orders orders) {
        return new ResponseEntity<Object>(orderMapper.addOrder(orders), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getOrdersList(OrderParam order) {
        return new ResponseEntity<Object>(orderMapper.getOrdersByUserId(order), HttpStatus.OK);
    }
}
