package com.yanggy.springboot.service.impl;

import com.yanggy.springboot.common.ResponseEntityBuilder;
import com.yanggy.springboot.common.ResponseEntityDto;
import com.yanggy.springboot.dto.in.OrderParam;
import com.yanggy.springboot.dto.in.UserParam;
import com.yanggy.springboot.dto.out.OderDto;
import com.yanggy.springboot.entity.Orders;
import com.yanggy.springboot.entity.User;
import com.yanggy.springboot.mapper.OrderMapper;
import com.yanggy.springboot.mapper.UserMapper;
import com.yanggy.springboot.service.OrderService;
import com.yanggy.springboot.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author derrick.yang
 * @Date 3/22/18 22:26
 */

@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public ResponseEntityDto<?> addOrder(Orders orders) {
        return ResponseEntityBuilder.buildNormalResponse(orderMapper.addOrder(orders));
    }

    @Override
    public ResponseEntityDto<?> getOrdersList(OrderParam order) {
        List<OderDto> orders = orderMapper.getOrders(order);

        Object lastId = null;
        if(null != orders && orders.size() > 0) {
            lastId = orders.get(orders.size() - 1).getOrderId();
        }

        orders.forEach((orderDto -> {
            UserParam userParam = new UserParam();
            userParam.setUserId(orderDto.getUserId());
            User user = userMapper.getUserById(userParam);
            orderDto.setName(user.getName());
            orderDto.setPassword(user.getPassword());
        }));

        int count = orderMapper.countOrders(order);

        return ResponseEntityBuilder.buildNormalResponse(PageUtils.buildPage(order.getPageNo(), order.getPageSize(),
                count, orders, lastId));
    }

    @Override
    public ResponseEntityDto<?> getOrdersListByLimit(OrderParam order) {
        List<OderDto> orders = orderMapper.getOrdersByLimit(order);

        Object lastId = null;
        if(null != orders && orders.size() > 0) {
            lastId = orders.get(orders.size() - 1).getOrderId();
        }

        return ResponseEntityBuilder.buildNormalResponse(PageUtils.buildPage(order.getPageNo(), order.getPageSize(),
                orderMapper.countOrders(order), orders, lastId));
    }

    @Override
    public ResponseEntityDto<?> getOrderInfo(OrderParam orderParam) {
        return ResponseEntityBuilder.buildNormalResponse(orderMapper.getOrderInfo(orderParam));
    }
}
