package javaCollectionFramework.UniversityCourseRegistration.Service;

import javaCollectionFramework.UniversityCourseRegistration.model.Course;
import javaCollectionFramework.UniversityCourseRegistration.model.Student;
import java.util.*;

public class RegistrationSystem {

    private Map<String, Course> courseMap;
    private Map<String, Student> studentMap;

    public RegistrationSystem() {
        courseMap = new HashMap<>();
        studentMap = new HashMap<>();
    }

    public void addStudent(Student student) {
        studentMap.put(student.getId(), student);
    }

    public void addCourse(Course course) {
        courseMap.put(course.getCourseId(), course);
    }

    public boolean registerStudentToCourse(String studentId, String courseId) {
        Student student = studentMap.get(studentId);
        Course course = courseMap.get(courseId);
        if (student == null || course == null) return false;

        if (course.getEnrolledStudents().contains(student)) return false;
        if (course.getWaitlist().contains(student)) return false;

        if (course.isFull()) {
            course.getWaitlist().offer(student);
        } else {
            course.getEnrolledStudents().add(student);
        }
        return true;
    }

    public boolean dropStudentFromCourse(String studentId, String courseId) {
        Student student = studentMap.get(studentId);
        Course course = courseMap.get(courseId);
        if (student == null || course == null) return false;

        if (course.getEnrolledStudents().remove(student)) {
            if (!course.getWaitlist().isEmpty()) {
                Student next = course.getWaitlist().poll();
                course.getEnrolledStudents().add(next);
            }
            return true;
        } else {
            return course.getWaitlist().remove(student);
        }
    }

    public List<Student> listStudentsInCourse(String courseId) {
        Course course = courseMap.get(courseId);
        if (course == null) return Collections.emptyList();
        return new ArrayList<>(course.getEnrolledStudents());
    }

    public List<Student> listStudentsByBranch(String branch) {
        List<Student> result = new ArrayList<>();
        for (Student student : studentMap.values()) {
            if (student.getBranch().equalsIgnoreCase(branch)) {
                result.add(student);
            }
        }
        return result;
    }

    public List<Course> listCoursesSortedByEnrollment() {
        List<Course> courses = new ArrayList<>(courseMap.values());
        courses.sort((a, b) -> Integer.compare(b.getEnrolledStudents().size(), a.getEnrolledStudents().size()));
        return courses;
    }

    public List<Course> filterCoursesByCredits(int credits) {
        List<Course> result = new ArrayList<>();
        for (Course course : courseMap.values()) {
            if (course.getCredits() == credits) {
                result.add(course);
            }
        }
        return result;
    }

    public List<Course> filterCoursesByInstructor(String instructor) {
        List<Course> result = new ArrayList<>();
        for (Course course : courseMap.values()) {
            if (course.getInstructorName().equalsIgnoreCase(instructor)) {
                result.add(course);
            }
        }
        return result;
    }
}