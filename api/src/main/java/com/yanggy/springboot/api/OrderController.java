package com.yanggy.springboot.api;

import com.yanggy.springboot.common.ResponseEntityDto;
import com.yanggy.springboot.dto.OrderParam;
import com.yanggy.springboot.entity.Orders;
import com.yanggy.springboot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author derrick.yang
 * @Date 3/22/18 22:30
 */

@RestController
@RequestMapping("/order/**")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping(value = "addOrder")
    public ResponseEntityDto<?> addOrder(@RequestBody Orders orders) {
        return orderService.addOrder(orders);
    }

    @PostMapping(value = "/orderList")
    public ResponseEntityDto<?> getOrderList(@RequestBody OrderParam orderParam) {
        return orderService.getOrdersList(orderParam);
    }

    @PostMapping(value = "getOrderInfo")
    public ResponseEntityDto<?> getOrderInfo(@RequestBody OrderParam orderParam) {
        return orderService.getOrderInfo(orderParam);
    }
}
