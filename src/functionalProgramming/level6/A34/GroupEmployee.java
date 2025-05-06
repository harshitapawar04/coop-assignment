package functionalProgramming.level6.A34;

import java.util.*;
import java.util.stream.Collectors;

public class GroupEmployee {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR"),
                new Employee("Bob", "Finance"),
                new Employee("Charlie", "HR"),
                new Employee("David", "Engineering"),
                new Employee("Eve", "Finance"),
                new Employee("Frank", "Engineering")
        );
        Map<String, Long> employeeCount = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.counting()
                ));

        employeeCount.forEach((dept, count) ->
                System.out.println(dept + " -> " + count + " employees"));
    }
}
