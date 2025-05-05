package javaCollectionFramework.Assignment8;
import java.util.*;

public class EmployeeHierarchySystem{

    // Employee class
    static class Employee {
        private String name;
        private String empId;

        public Employee(String name, String empId) {
            this.name = name;
            this.empId = empId;
        }

        public String getName() {
            return name;
        }

        public String getEmpId() {
            return empId;
        }

        @Override
        public String toString() {
            return name + " (" + empId + ")";
        }
    }

    static class Manager {
        private String name;
        private String managerId;

        public Manager(String name, String managerId) {
            this.name = name;
            this.managerId = managerId;
        }

        @Override
        public String toString() {
            return name + " (" + managerId + ")";
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Manager)) return false;
            Manager m = (Manager) obj;
            return managerId.equals(m.managerId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(managerId);
        }
    }

    public static void main(String[] args) {
        // Define the hierarchy map
        Map<Manager, TreeMap<Integer, List<Employee>>> hierarchy = new HashMap<>();

        // Managers
        Manager m1 = new Manager("Alice", "M101");
        Manager m2 = new Manager("Bob", "M102");

        // Employees
        Employee e1 = new Employee("John", "E001");
        Employee e2 = new Employee("Jane", "E002");
        Employee e3 = new Employee("David", "E003");
        Employee e4 = new Employee("Emma", "E004");
        Employee e5 = new Employee("Charlie", "E005");

        // Add employees under Alice
        hierarchy.putIfAbsent(m1, new TreeMap<>());
        hierarchy.get(m1).computeIfAbsent(1, k -> new ArrayList<>()).add(e1);
        hierarchy.get(m1).computeIfAbsent(2, k -> new ArrayList<>()).add(e2);
        hierarchy.get(m1).computeIfAbsent(2, k -> new ArrayList<>()).add(e3);

        // Add employees under Bob
        hierarchy.putIfAbsent(m2, new TreeMap<>());
        hierarchy.get(m2).computeIfAbsent(1, k -> new ArrayList<>()).add(e4);
        hierarchy.get(m2).computeIfAbsent(3, k -> new ArrayList<>()).add(e5);

        // Print the hierarchy
        for (Map.Entry<Manager, TreeMap<Integer, List<Employee>>> entry : hierarchy.entrySet()) {
            Manager manager = entry.getKey();
            System.out.println("Manager: " + manager);
            TreeMap<Integer, List<Employee>> levels = entry.getValue();
            for (Map.Entry<Integer, List<Employee>> levelEntry : levels.entrySet()) {
                System.out.println("  Level " + levelEntry.getKey() + ":");
                for (Employee emp : levelEntry.getValue()) {
                    System.out.println("    - " + emp);
                }
            }
            System.out.println();
        }
    }
}
