package org.ckb;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
class Student {
    private String name;
    private int age;
    private int grade;

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Alice", 15, 9),
                new Student("Bob", 16, 10),
                new Student("Charlie", 14, 9),
                new Student("David", 17, 11),
                new Student("Emily", 15, 10),
                new Student("Frank", 16, 11)
        );

//        Map<Integer, Double> averageAgeByGrade = students.stream()
//                .collect(Collectors.groupingBy(Student::getGrade,
//                        Collectors.averagingInt(Student::getAge)));
//
//        System.out.println(averageAgeByGrade);

        Map<Integer, List<Student>> val = students.stream()
                .collect(Collectors.groupingBy(Student::getGrade, Collectors.toList()));


//        System.out.println("Average age by grade:");
//        averageAgeByGrade.forEach((grade, averageAge) ->
//                System.out.println("Grade " + grade + ": " + averageAge));
    }
}


