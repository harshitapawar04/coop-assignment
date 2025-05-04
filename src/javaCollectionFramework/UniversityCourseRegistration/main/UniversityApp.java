package javaCollectionFramework.UniversityCourseRegistration.main;

import javaCollectionFramework.UniversityCourseRegistration.model.Course;
import javaCollectionFramework.UniversityCourseRegistration.model.Student;
import javaCollectionFramework.UniversityCourseRegistration.Service.RegistrationSystem;
import javaCollectionFramework.UniversityCourseRegistration.util.ComparatorUtil;

public class UniversityApp {
    public static void main(String[] args) {
        RegistrationSystem system = new RegistrationSystem();

        Student s1 = new Student("S101", "Alice", "alice@email.com", 2, "CSE");
        Student s2 = new Student("S102", "Bob", "bob@email.com", 3, "ECE");
        Student s3 = new Student("S103", "Charlie", "charlie@email.com", 2, "CSE");

        system.addStudent(s1);
        system.addStudent(s2);
        system.addStudent(s3);

        Course c1 = new Course("CSE101", "Data Structures", "Dr. Smith", 2, 4, ComparatorUtil.getStudentNameComparator());
        Course c2 = new Course("ECE202", "Digital Circuits", "Dr. John", 2, 3, ComparatorUtil.getStudentNameComparator());

        system.addCourse(c1);
        system.addCourse(c2);

        system.registerStudentToCourse("S101", "CSE101");
        system.registerStudentToCourse("S102", "CSE101");
        system.registerStudentToCourse("S103", "CSE101");

        System.out.println("Students in CSE101 before dropping a student:");
        system.listStudentsInCourse("CSE101").forEach(System.out::println);
        System.out.println();
        system.dropStudentFromCourse("S101", "CSE101");

        System.out.println("Students in CSE101 after dropping the student:");
        system.listStudentsInCourse("CSE101").forEach(System.out::println);
    }
}