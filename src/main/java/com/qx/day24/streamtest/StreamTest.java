package com.qx.day24.streamtest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 5, 0, 8, 6, 5};
        int max = Arrays.stream(arr).max().getAsInt();
        System.out.println("最大值:" + max);
        int sum = Arrays.stream(arr).sum();
        System.out.println("和:" + sum);
        List<Student> list = Arrays.asList(
                new Student(1, "花木兰", 25, 66.0),
                new Student(2, "李白", 21, 90.0),
                new Student(3, "诸葛亮", 21, 80.0),
                new Student(4, "公孙离", 18, 100d),
                new Student(5, "不知火舞", 21, 90d),
                new Student(5, "不知火舞", 21, 90d)
        );
        //过滤
        System.out.println("-------------------------filter------------------------");
        list.stream().filter(a->a.getAge()<20).forEach(System.out::println);

        //去重
        System.out.println("-------------------------distinct------------------------");
        list.stream().skip(3).distinct().forEach(System.out::println);

        System.out.println("-------------------------skip------------------------");
        list.stream().skip(4).forEach(System.out::println);

        System.out.println("-------------------------map------------------------");
        list.stream().mapToInt(Student::getAge).max().ifPresent(System.out::println);

        System.out.println("-------------------------map------------------------");
        list.stream().map(Student::getName).distinct().forEach(System.out::println);

        System.out.println("-------------------------map1------------------------");
        list.stream().map(Student::getName).distinct().forEach(System.out::println);

        System.out.println("-------------------------collect------------------------");
        String collect = list.stream().map(Student::getName).distinct().collect(Collectors.joining(","));
        System.out.println(collect);

        System.out.println("-------------------------comparator------------------------");
        list.stream()
                .sorted(Comparator.comparingDouble(Student::getScore).reversed()
                        .thenComparing(Student::getAge)
                        .thenComparing(Student::getId))
                .collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("-------------------------reduce------------------------");
        list.stream().map(Student::getAge)
                .reduce(Integer::sum)
                .ifPresent(System.out::println);
        System.out.println("-------------------------score------------------------");
        DoubleSummaryStatistics collect1 = list.stream().collect(Collectors.summarizingDouble(Student::getScore));
        System.out.println(collect1);
    }
}
