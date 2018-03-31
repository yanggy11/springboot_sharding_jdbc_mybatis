package com.yanggy.springboot;

import com.yanggy.springboot.entity.User;
import com.yanggy.springboot.mapper.OrderMapper;
import com.yanggy.springboot.mapper.UserMapper;
import com.yanggy.springboot.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Random;

/**
 * @Author: yangguiyun
 * @Date: 2018/3/30 10:08
 * @Description:
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootConfiguration
@SpringBootTest(classes = Application.class)
public class TestUnits {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderMapper orderMapper;
    @Test
    public void test() {
        for(int i = 0; i < 200000; i++) {
            User user = new User();
            user.setAge(new Random().nextInt(100));
            user.setName(Thread.currentThread().getName() + "_" + i +"_mac");
            user.setPassword("kjldaljkjl");

            userMapper.insertUser(user);
        }
    }

}
