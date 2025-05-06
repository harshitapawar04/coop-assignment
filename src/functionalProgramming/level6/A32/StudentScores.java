package functionalProgramming.level6.A32;

import java.util.*;
import java.util.stream.Collectors;

public class StudentScores {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Alice", 85),
                new Student("Bob", 55),
                new Student("Charlie", 72),
                new Student("David", 40),
                new Student("Eve", 90)
        );

        List<String>studentScoredAbove80= students.stream()
                .filter(t->t.getGrade()>80)
                .map(Student::getName)
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Students who achieved grades above 80 are " + studentScoredAbove80);
    }
}
