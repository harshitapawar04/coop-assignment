package functionalProgramming.level9.A46;

import java.util.*;
import java.util.stream.Collectors;

public class GroupByYearAndMaxSalary {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 2020, 50000),
                new Employee("Bob", 2021, 60000),
                new Employee("Charlie", 2020, 70000),
                new Employee("David", 2021, 55000),
                new Employee("Eve", 2022, 80000),
                new Employee("Frank", 2020, 45000)
        );

        Map<Integer, List<Employee>> employeesByYear = employees.stream()
                .collect(Collectors.groupingBy(Employee::getJoiningYear));

        System.out.println("Employees grouped by year:");
        employeesByYear.forEach((year, empList) -> {
            System.out.println(year + ": " + empList);
        });

        System.out.println("\nHighest paid employee by year:");

        Map<Integer, Optional<Employee>> highestPaidByYear = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getJoiningYear,
                        Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))
                ));

        highestPaidByYear.forEach((year, empOpt) ->
                System.out.println(year + " -> " + empOpt.map(Employee::toString).orElse("No Employee"))
        );
    }
}
