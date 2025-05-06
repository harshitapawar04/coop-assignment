package functionalProgramming.level6.A35;

import java.util.*;
import java.util.stream.Collectors;

public class AvarageSalaryByDept {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR", 50000),
                new Employee("Bob", "Finance", 60000),
                new Employee("Charlie", "HR", 55000),
                new Employee("David", "Engineering", 70000),
                new Employee("Eve", "Finance", 65000),
                new Employee("Frank", "Engineering", 75000)
        );

        Map<String , Double>avgSalary= employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ));

        avgSalary.forEach((dept, avg) ->
                System.out.println(dept + " -> Average Salary: " + avg));
    }
}
