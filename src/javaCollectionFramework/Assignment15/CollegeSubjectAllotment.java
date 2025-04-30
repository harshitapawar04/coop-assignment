package javaCollectionFramework.Assignment15;
import java.util.*;

public class CollegeSubjectAllotment {
    private final Map<String, List<String>> studentSubjects = new HashMap<>();

    // Add subject(s) to a student
    public void allotSubjects(String student, List<String> subjects) {
        studentSubjects
                .computeIfAbsent(student, k -> new ArrayList<>())
                .addAll(subjects);
        System.out.println("Allotted subjects to " + student + ": " + subjects);
    }

    // Get subjects allotted to a student
    public List<String> getSubjectsByStudent(String student) {
        return studentSubjects.getOrDefault(student, Collections.emptyList());
    }

    // Reverse lookup: get students by subject
    public List<String> getStudentsBySubject(String subject) {
        List<String> students = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : studentSubjects.entrySet()) {
            if (entry.getValue().contains(subject)) {
                students.add(entry.getKey());
            }
        }
        return students;
    }

    // View all allotments
    public void printAllAllotments() {
        System.out.println("\nSubject Allotments:");
        for (Map.Entry<String, List<String>> entry : studentSubjects.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        CollegeSubjectAllotment allotment = new CollegeSubjectAllotment();

        allotment.allotSubjects("Alice", Arrays.asList("Math", "Physics"));
        allotment.allotSubjects("Bob", Arrays.asList("Biology", "Chemistry"));
        allotment.allotSubjects("Charlie", Arrays.asList("Math", "Computer Science"));

        allotment.printAllAllotments();

        // Reverse lookup
        String subject = "Math";
        List<String> students = allotment.getStudentsBySubject(subject);
        System.out.println("\nStudents who chose " + subject + ": " + students);
    }
}
