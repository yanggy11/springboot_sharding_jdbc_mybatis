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
        student.setSex("");
        student.setFee(10000);
        Student student1 = new Student();
        student1.setId(2);
        student1.setStuAge(30);
        student1.setStuNo("No.0002");
        student1.setStuName("derrick2");
        student1.setFee(10000);
        Student student2 = new Student();
        student2.setId(3);
        student2.setStuAge(24);
        student2.setStuNo("No.0003");
        student2.setFee(10000);
        student2.setStuName("derrick3");
        Student student3 = new Student();
        student3.setId(4);
        student3.setStuAge(70);
        student3.setStuNo("No.0004");
        student3.setStuName("derrick4");
        student3.setFee(10000);

        System.out.println(function.apply(student));

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

        List<String> stuNames = students.stream().map(Student::getStuName).collect(Collectors.toList());

        Optional<Student> oldestStudent = students.stream().reduce((stu1, stu2) -> {
            return stu1.getStuAge() > stu2.getStuAge() ? stu1 : stu2;
        });

        Consumer<Student>consumer = System.out::println;

        oldestStudent.ifPresent(consumer);

        Map<Integer, List<Student>> map = students.stream().collect(Collectors.groupingBy(Student::getStuAge,HashMap::new, Collectors.toList()));
        System.out.println(map);

        Map<Boolean, List<Student>> listMap = students.stream().collect(Collectors.partitioningBy((stu) -> stu.getStuAge() > 20));

        System.out.println(listMap);

    }
}
