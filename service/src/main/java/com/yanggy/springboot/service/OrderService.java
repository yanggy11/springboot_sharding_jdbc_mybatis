package com.yanggy.springboot.service;

import com.yanggy.springboot.dto.OrderParam;
import com.yanggy.springboot.entity.Orders;
import org.springframework.http.ResponseEntity;

/**
 * @author derrick.yang
 * @Date 3/22/18 22:26
 */
public interface OrderService {
    ResponseEntity<?> addOrder(Orders orders);
    ResponseEntity<?> getOrdersList(OrderParam order);
}
