package javaCollectionFramework.UniversityCourseRegistration.util;

import javaCollectionFramework.UniversityCourseRegistration.model.Student;
import java.util.Comparator;

public class ComparatorUtil {
    public static Comparator<Student> getStudentNameComparator() {
        return Comparator.comparing(Student::getName);
    }
}