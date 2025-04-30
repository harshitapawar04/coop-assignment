package javaCollectionFramework.Assignment1;

import java.util.*;

class Student{
    private int id;
    private String name;
    private int age;
    private double grade;
    private String branch;

    public Student(int id, String name, int age, double grade, String branch) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.branch = branch;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getGrade() { return grade; }
    public String getBranch() { return branch; }

    @Override
    public String toString() {
        return String.format("ID: %d | Name: %s | Age: %d | Grade: %.2f | Branch: %s",
                id, name, age, grade, branch);
    }
}

public class AdvancedStudentManagement{
    public static void main(String[] args) {
        List<Student> students=new ArrayList<>();

        //Adding students
        students.add(new Student(1, "Alice", 20, 85.5, "CSE"));
        students.add(new Student(2, "Bob", 21, 91.0, "ECE"));
        students.add(new Student(3, "Charlie", 22, 78.5, "CSE"));
        students.add(new Student(4, "David", 20, 88.0, "EEE"));
        students.add(new Student(5, "Eve", 21, 95.0, "ECE"));
        students.add(new Student(6, "Frank", 22, 67.5, "CSE"));
        students.add(new Student(7, "Grace", 23, 89.0, "ME"));
        students.add(new Student(8, "Heidi", 21, 91.5, "EEE"));
        students.add(new Student(9, "Ivan", 20, 74.5, "ME"));
        students.add(new Student(10, "Judy", 22, 88.5, "ECE"));
        students.add(new Student(11, "Kevin", 21, 81.5, "CSE"));
        students.add(new Student(12, "Laura", 22, 69.0, "ME"));
        students.add(new Student(13, "Mallory", 23, 90.5, "EEE"));
        students.add(new Student(14, "Niaj", 20, 85.0, "CSE"));
        students.add(new Student(15, "Olivia", 21, 92.0, "ECE"));

        //sorting through branch and grade
        students.sort(
                Comparator.comparing(Student::getBranch)
                        .thenComparing(Comparator.comparing(Student::getGrade).reversed())
        );

        //print sorted students
        System.out.println("Sorted by Branch and Grade");
        for(Student s: students){
            System.out.println(s);
        }

        Map<String ,List<Student>> groupedStudents= new HashMap<>();

        for(Student student: students){
            if(!groupedStudents.containsKey(student.getBranch())){
                groupedStudents.put(student.getBranch(),new ArrayList<>());
            }
            groupedStudents.get(student.getBranch()).add(student);
        }

        groupedStudents.forEach((branch,studentInBranch)->{
            System.out.println("Branch" +branch);
            for (Student inBranch : studentInBranch) {
                System.out.println(inBranch);
            }
        });

    }



}