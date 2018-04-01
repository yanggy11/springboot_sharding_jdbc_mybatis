package com.yanggy.springboot.mapper;

import com.yanggy.springboot.dto.in.OrderParam;
import com.yanggy.springboot.dto.out.OderDto;
import com.yanggy.springboot.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author derrick.yang
 * @Date 3/22/18 22:18
 */

@Mapper
public interface OrderMapper {
    int addOrder(Orders orders);

    List<Orders> getOrdersByUserId(OrderParam orders);

    int countOrders(OrderParam orderParam);

    List<OderDto> getOrders(OrderParam orderParam);

    List<OderDto> getOrdersByLimit(OrderParam orderParam);

    Map getOrderInfo(OrderParam orderParam);
}
