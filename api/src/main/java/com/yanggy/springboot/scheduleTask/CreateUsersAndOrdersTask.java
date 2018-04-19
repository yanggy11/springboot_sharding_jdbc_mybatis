package com.yanggy.springboot.scheduleTask;


import com.yanggy.springboot.dto.in.UserParam;
import com.yanggy.springboot.entity.Orders;
import com.yanggy.springboot.entity.User;
import com.yanggy.springboot.mapper.OrderMapper;
import com.yanggy.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

/**
 * @Author: yangguiyun
 * @Date: 2018/4/9 10:32
 * @Description:
 *
 * 线程池创建用户和订单数据
 */

@Component
public class CreateUsersAndOrdersTask {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private ExecutorService executorService;

    @Scheduled(fixedRate = 2000)
    public void createUsersAndOrders() {
        int count = userMapper.getUserCount(new UserParam());
        if(count > 2500000) {
            return;
        }
        executorService.submit(() -> {
            for(int i = 1000; i > 0; i--) {
                this.createUsersOrders();
            }
        });
    }

    private void createUsersOrders() {
        User user = new User();
        user.setName(ChineseNames.getNames());
        user.setPassword("123456");
        Random ageRandom = new Random();
        int age = ageRandom.nextInt(20) * 4;
        user.setAge(age);

        userMapper.insertUser(user);

        Long userId = user.getId();

        CompletableFuture.runAsync(() -> {
           Random random = new Random();

            int count = random.nextInt(50);
            Long id = userId;

            if(count < 10) {
                count += 20;
            }

            for(int i= 0; i < count; i++) {
                CompletableFuture.runAsync(() -> {
                    Orders orders = new Orders();
                    orders.setPrice(new Random().nextInt(100000));
                    orders.setAddress(ChineseNames.getNames());
                    orders.setUserId(userId);

                    orderMapper.addOrder(orders);
                });

            }
        });
    }
}
