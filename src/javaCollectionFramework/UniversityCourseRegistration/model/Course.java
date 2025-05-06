package javaCollectionFramework.UniversityCourseRegistration.model;
import java.util.*;

public class Course {
    private String courseId;
    private String courseName;
    private String instructorName;
    private int capacity;
    private int credits;
    private TreeSet<Student> enrolledStudents;
    private Queue<Student> waitlist;

    public Course(String courseId, String courseName, String instructorName, int capacity, int credits, Comparator<Student> studentComparator) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.instructorName = instructorName;
        this.capacity = capacity;
        this.credits = credits;
        this.enrolledStudents = new TreeSet<>(studentComparator);
        this.waitlist = new LinkedList<>();
    }

    public String getCourseId() { return courseId; }
    public String getCourseName() { return courseName; }
    public String getInstructorName() { return instructorName; }
    public int getCapacity() { return capacity; }
    public int getCredits() { return credits; }
    public Set<Student> getEnrolledStudents() { return enrolledStudents; }
    public Queue<Student> getWaitlist() { return waitlist; }

    public boolean isFull() {
        return enrolledStudents.size() >= capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return courseId.equals(course.courseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId);
    }

    @Override
    public String toString() {
        return courseName + " (" + courseId + ")";
    }
}
