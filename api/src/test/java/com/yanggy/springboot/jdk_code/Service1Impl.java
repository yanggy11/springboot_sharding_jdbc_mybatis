package com.yanggy.springboot.jdk_code;

/**
 * @Author: yangguiyun
 * @Date: 2018/4/10 15:23
 * @Description:
 */
public class Service1Impl extends Service2 implements Service1 {
    @Override
    public void test() {
        System.out.println("Service1.test");
    }

    @Override
    void test2() {
        System.out.println("inherited from Service2");
    }
}
