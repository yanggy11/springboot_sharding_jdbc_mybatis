package com.yanggy.springboot.jdk_code;

import javafx.print.Collation;
import org.springframework.beans.BeanUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
//        List<Integer> numbers = new ArrayList<>(Arrays.asList(1,5,7,8,12,34,6,17,20));
////        System.out.println(numbers);
//
//        /**
//         * 判断数字是否大于10
//         */
//        Predicate<Integer> predicate = (e) -> {
//            return e > 15;
//        };
////        predicate = predicate.or((e) -> {
////            return e < 10;
////        });
//
////        predicate = predicate.negate();
//
////        Predicate<Integer> predicate = Predicate.isEqual(12);
////        System.out.println(predicate.test(12));
////        numbers.removeIf(predicate);
////
////        System.out.println(numbers);
//
////        List<String> strs = new LinkedList<>(Arrays.asList("hello","derrick","name"));
////        Predicate<String> predicate = Predicate.isEqual("name");
////        strs.removeIf(predicate);
//
////        System.out.println(strs);
//
////        BiPredicate<Integer, Integer> biPredicate = (x,y) -> {
////            return x > y;
////        };
////
////        System.out.println(biPredicate.test(5,7));
//
//        Function<Student, StudentDto> function = (stu -> {
//            StudentDto studentDto = new StudentDto();
//            BeanUtils.copyProperties(stu, studentDto);
//
//            studentDto.setStuId(stu.getId());
//            return studentDto;
//        });
//
        Student student = new Student();
        student.setId(1);
        student.setStuAge(14);
        student.setStuNo("No.0001");
        student.setStuName("derricl");
        student.setSex("");
        student.setFee(10000);
        student.setSex("Male");
        Student student1 = new Student();
        student1.setId(2);
        student1.setStuAge(30);
        student1.setStuNo("No.0002");
        student1.setStuName("derrick2");
        student1.setFee(10000);
        student1.setSex("Male");
        Student student2 = new Student();
        student2.setId(2);
        student2.setStuAge(24);
        student2.setStuNo("No.0003");
        student2.setFee(10000);
        student2.setStuName("derrick3");
        student2.setSex("Female");
        Student student3 = new Student();
        student3.setId(2);
        student3.setStuAge(70);
        student3.setStuNo("No.0004");
        student3.setStuName("derrick4");
        student3.setFee(10000);
        student3.setSex("Male");
//
//        System.out.println(function.apply(student));
//
//        System.out.println(student);
//
//        Supplier<Integer> supplier = () -> {
//            return 20;
//        };
//
//        System.out.println(supplier.get());
//        List<Integer> nums = new ArrayList<>();
//        numbers.stream().collect(Collectors.toCollection(() -> {
//            return nums;
//        }));
//
//        System.out.println(nums);
//
        List<Student> students = new ArrayList<>();

        students.add(student);
        students.add(student1);
        students.add(student2);
        students.add(student3);
//        List<String> stuNames = new ArrayList<>();
//
//
//
////        students.stream().filter(stu -> stu.getStuAge() > 10).map((stu -> stu.getStuName())).sorted().collect(Collectors.toCollection(() -> stuNames));
////
////
////        String[] str = {"I", "love", "you", "too", "too"};
////
////        Stream<List<Integer>> stream = Stream.of(Arrays.asList(1,2), Arrays.asList(3, 4, 5));
////        stream.flatMap(list -> list.stream()).collect(Collectors.toList());
////        BinaryOperator<String> binaryOperator = (s1, s2) -> s1.length() < s2.length() ? s1 : s2;
////
////        /**
////         * reduce 方法
////         */
//////        Optional<String> minStr = Stream.of(stuNames, Arrays.asList(str)).flatMap(list -> list.stream()).distinct().reduce(binaryOperator);
//////
//////        minStr.ifPresent((str3) -> {
//////            //操作
//////            System.out.println(str3);
//////        });
////
//////        Arrays.stream(str).distinct().sorted((str1, str2) -> {
//////            return str1.length() - str2.length();
//////        }).map(str1 -> str1.toUpperCase()).collect(Collectors.toCollection(() -> {
//////            return stuNames;
//////        }));
////        /**
////         * reduce(identity, BinaryOperator)
////         */
////        String identity = "hello";
////
////       String minStr = Stream.of(stuNames, Arrays.asList(str)).flatMap(list -> list.stream()).distinct().reduce(identity, (S1,S2) -> {
////           return S1.concat(",").concat(S2);
////       });
////
////        System.out.println(minStr);
//
//        students.stream().collect(Collectors.groupingBy(Student::getStuAge));
//
//        List<String> names = students.stream().map((stu -> {
//            return stu.getStuNo();
//        })).collect(Collectors.toCollection(ArrayList::new));
//        OptionalInt sumFee = students.stream().mapToInt((stu1 -> stu1.getFee())).reduce((stu1, stu2) -> {
//            return stu1 + stu2;
//        });
//        Map<String, String> map = students.stream().collect(Collectors.toMap(stu -> stu.getStuNo(), stu->stu.getStuName()));
//        Map map1 = students.stream().collect(Collectors.toMap(Student::getId, Student::getFee, (s, a) -> s + a, HashMap::new));
//
//        System.out.println(map1);
//
//        map1.forEach((key, value) -> {
//            Integer v = null;
//            if(value instanceof Integer) {
//                v = (Integer)value;
//            }
//            System.out.println(key + ":" + v);
//        });
//        System.out.println(sumFee.orElse(0));
//
//        Function<Student, String> noFuction = Student::getStuNo;
//        students.stream().sorted(Comparator.comparing(noFuction)).collect(Collectors.toList());

//        Service1 service1 = new Service1Impl();
//        service1.test();
//
//        Service1Impl service1Impl = (Service1Impl)service1;
//
//        service1Impl.test2();
//        service1Impl.sayHello();
//        Comparator<Student> comparator = (stu1, stu2) -> stu1.getStuAge() - stu2.getStuAge();
//        TreeSet<Student> treeSet = new TreeSet<>((stu1, stu2) -> {return stu1.getStuAge() - stu2.getStuAge();});
//
//        treeSet.addAll(students);
//
//        System.out.println(treeSet);
//
//        Map<String, List<Student>> maps = students.stream().collect(Collectors.groupingBy(Student::getSex));
//
//        System.out.println(maps);
//
//        try {
//            MessageDigest md5 = MessageDigest.getInstance("MD5");
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }

        OptionalInt sum = students.stream().mapToInt(Student::getFee).reduce((a, b) -> a + b);

        sum.ifPresent(System.out::println);

        Integer sum1 = students.stream().mapToInt(Student::getFee).reduce(0, (a, b) -> a + b);

        if(sum1 == sum.orElseGet(() -> 0)) {
            System.out.println(true);
        }
    }
}
