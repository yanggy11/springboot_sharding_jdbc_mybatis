package com.yanggy.springboot.enum_test;

/**
 * Created by yangguiyun on 2018/4/8.
 */
public enum WeekdayEnum {
    Mon("Monday"),
    Tue("Monday"),
    Wen("Monday"),
    Thu("Monday"),
    Fri("Friday"),
    Sat("Monday"),
    Sun("Monday");

    private String value;

    private WeekdayEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
