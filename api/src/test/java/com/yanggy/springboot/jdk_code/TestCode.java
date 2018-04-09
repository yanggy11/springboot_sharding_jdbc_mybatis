package com.yanggy.springboot.jdk_code;

import javafx.print.Collation;
import org.springframework.beans.BeanUtils;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: yangguiyun
 * @Date: 2018/4/8 11:11
 * @Description:
 */
public class TestCode {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1,5,7,8,12,34,6,17,20));
//        System.out.println(numbers);

        /**
         * 判断数字是否大于10
         */
        Predicate<Integer> predicate = (e) -> {
            return e > 15;
        };
//        predicate = predicate.or((e) -> {
//            return e < 10;
//        });

//        predicate = predicate.negate();

//        Predicate<Integer> predicate = Predicate.isEqual(12);
//        System.out.println(predicate.test(12));
//        numbers.removeIf(predicate);
//
//        System.out.println(numbers);

//        List<String> strs = new LinkedList<>(Arrays.asList("hello","derrick","name"));
//        Predicate<String> predicate = Predicate.isEqual("name");
//        strs.removeIf(predicate);

//        System.out.println(strs);

//        BiPredicate<Integer, Integer> biPredicate = (x,y) -> {
//            return x > y;
//        };
//
//        System.out.println(biPredicate.test(5,7));

        Function<Student, StudentDto> function = (stu -> {
            StudentDto studentDto = new StudentDto();
            BeanUtils.copyProperties(stu, studentDto);

            studentDto.setStuId(stu.getId());
            return studentDto;
        });

        Student student = new Student();
        student.setId(1);
        student.setStuAge(14);
        student.setStuNo("No.0001");
        student.setStuName("derricl");
        Student student1 = new Student();
        student1.setId(2);
        student1.setStuAge(30);
        student1.setStuNo("No.0002");
        student1.setStuName("derrick2");
        Student student2 = new Student();
        student2.setId(2);
        student2.setStuAge(24);
        student2.setStuNo("No.0002");
        student2.setStuName("derrick2");
        Student student3 = new Student();
        student3.setId(2);
        student3.setStuAge(70);
        student3.setStuNo("No.0002");
        student3.setStuName("derrick2");

        System.out.println(function.apply(student));

        Consumer<Student> consumer = (stu -> {
            if(predicate.test(stu.getStuAge())) {
                stu.setFee(100);
            }else {
                stu.setFee(50);
            }
        });

        consumer.accept(student);

        System.out.println(student);

        Supplier<Integer> supplier = () -> {
            return 20;
        };

        System.out.println(supplier.get());
        List<Integer> nums = new ArrayList<>();
        numbers.stream().collect(Collectors.toCollection(() -> {
            return nums;
        }));

        System.out.println(nums);

        List<Student> students = new ArrayList<>();

        students.add(student);
        students.add(student1);
        students.add(student2);
        students.add(student3);
        List<String> stuNames = new ArrayList<>();

//        students.stream().filter(stu -> stu.getStuAge() > 10).map((stu -> stu.getStuName())).sorted().collect(Collectors.toCollection(() -> stuNames));
//
//
//        String[] str = {"I", "love", "you", "too", "too"};
//
//        Stream<List<Integer>> stream = Stream.of(Arrays.asList(1,2), Arrays.asList(3, 4, 5));
//        stream.flatMap(list -> list.stream()).collect(Collectors.toList());
//        BinaryOperator<String> binaryOperator = (s1, s2) -> s1.length() < s2.length() ? s1 : s2;
//
//        /**
//         * reduce 方法
//         */
////        Optional<String> minStr = Stream.of(stuNames, Arrays.asList(str)).flatMap(list -> list.stream()).distinct().reduce(binaryOperator);
////
////        minStr.ifPresent((str3) -> {
////            //操作
////            System.out.println(str3);
////        });
//
////        Arrays.stream(str).distinct().sorted((str1, str2) -> {
////            return str1.length() - str2.length();
////        }).map(str1 -> str1.toUpperCase()).collect(Collectors.toCollection(() -> {
////            return stuNames;
////        }));
//        /**
//         * reduce(identity, BinaryOperator)
//         */
//        String identity = "hello";
//
//       String minStr = Stream.of(stuNames, Arrays.asList(str)).flatMap(list -> list.stream()).distinct().reduce(identity, (S1,S2) -> {
//           return S1.concat(",").concat(S2);
//       });
//
//        System.out.println(minStr);

        Student studentOptional = students.stream().reduce(student,(stu1, stu2) -> {
            return stu1.getStuAge() < stu2.getStuAge() ? stu1 : stu2;
        });

        System.out.println(studentOptional);


    }
}
