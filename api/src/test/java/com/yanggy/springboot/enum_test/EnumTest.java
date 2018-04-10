package com.yanggy.springboot.enum_test;

/**
 * @Author: yangguiyun
 * @Date: 2018/4/8 10:00
 * @Description:
 */
public class EnumTest {
    public static void main(String[] args) {
        WeekdayEnum weekday = WeekdayEnum.Fri;

        switch (weekday) {
            case Mon: {
                System.out.println("Monday");
                break;
            }
            case Tue: {
                System.out.println("Tuesday");
                break;
            }
            case Fri: {
                System.out.println(WeekdayEnum.valueOf("Fri").name());
                break;
            }
        }
    }
}
