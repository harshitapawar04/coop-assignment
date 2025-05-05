package javaCollectionFramework.Assignment1;

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
