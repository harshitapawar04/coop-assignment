package javaCollectionFramework.Assignment3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Employee{
    public String name;
   public double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String toString() {
        return name + " ($" + salary + ")";
    }
}

public class DepartmentDirectory{
    Map<String, List<Employee>> departmentEmp= new HashMap<>();

    public void addEmp(String department,Employee employee ){
        if(!departmentEmp.containsKey(department)){
            departmentEmp.put(department, new ArrayList<>());
        }
        departmentEmp.get(department).add(employee);
    }

    public void sortDepartmentEmp() {
        for(List<Employee> employee : departmentEmp.values()){
            employee.sort((a,b)->Double.compare(b.salary, a.salary));
        }
    }

   public List<Employee> highestPaidEmp(int n){
        List<Employee> allEmp=new ArrayList<>();
        for(List<Employee> list : departmentEmp.values()){
            allEmp.addAll(list);
        }

       allEmp.sort((a,b)->Double.compare(b.salary, a.salary));
        return allEmp.subList(0, Math.min(n,allEmp.size()));
   }
    public void printDirectory() {
        for (String dept : departmentEmp.keySet()) {
            System.out.println("Department: " + dept);
            for (Employee e : departmentEmp.get(dept)) {
                System.out.println("  - " + e);
            }
        }
    }

    public static void main(String[] args) {
        DepartmentDirectory directory = new DepartmentDirectory();

        directory.addEmp("IT", new Employee("Alice", 95000));
        directory.addEmp("IT", new Employee("Bob", 105000));
        directory.addEmp("HR", new Employee("Charlie", 88000));
        directory.addEmp("HR", new Employee("Diana", 99000));
        directory.addEmp("Sales", new Employee("Eve", 110000));
        directory.addEmp("Sales", new Employee("Frank", 92000));

        directory.sortDepartmentEmp();

        System.out.println("Department Directory");
        directory.printDirectory();

        System.out.println("highest paid employees in department");
        List<Employee> topPaid=directory.highestPaidEmp(4);
        for(Employee e : topPaid){
            System.out.println(e);
        }
    }
}