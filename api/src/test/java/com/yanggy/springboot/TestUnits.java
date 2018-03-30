package com.yanggy.springboot;

import com.yanggy.springboot.dto.UserParam;
import com.yanggy.springboot.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

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
    @Test
    public void test() {
        System.out.println("test");
    }

    @Test
    public void testUser() {
        UserParam userParam = new UserParam();
        userParam.setUserId(185769720832589824L);
        System.out.println(userMapper.getUserById(userParam));
    }
}
