package com.yanggy.springboot.mapper;

import com.yanggy.springboot.dto.OrderParam;
import com.yanggy.springboot.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author derrick.yang
 * @Date 3/22/18 22:18
 */

@Mapper
public interface OrderMapper {
    int addOrder(Orders orders);

    List<Orders> getOrdersByUserId(OrderParam orders);

    int countOrders(OrderParam orderParam);
}
