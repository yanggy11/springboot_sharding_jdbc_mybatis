package com.yanggy.springboot;

import com.yanggy.springboot.entity.User;
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
    @Test
    public void test() {


        for(int i = 0; i < 1000; i++) {
            new Thread(() -> {
                Random random = new Random(100);
                User user = new User("123456", Thread.currentThread().getName() + "_h_", random.nextInt(100));
                userMapper.insertUser(user);
                System.out.println(user);
            }).start();
        }
    }

    @Test
    public void testUser() {
        Random random = new Random(100);




                    for(int i = 0; i < 50000; i++) {
                        User user = new User("123456", Thread.currentThread().getName() + "_jj_" + i, random.nextInt(100));
                        userMapper.insertUser(user);
                        System.out.println(user);
                    }
                }

}
