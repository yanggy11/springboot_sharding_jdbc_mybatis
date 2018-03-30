package com.yanggy.springboot.service;

import com.yanggy.springboot.common.ResponseEntityDto;
import com.yanggy.springboot.dto.OrderParam;
import com.yanggy.springboot.entity.Orders;

/**
 * @author derrick.yang
 * @Date 3/22/18 22:26
 */
public interface OrderService {
    ResponseEntityDto<?> addOrder(Orders orders);
    ResponseEntityDto<?> getOrdersList(OrderParam order);
}
