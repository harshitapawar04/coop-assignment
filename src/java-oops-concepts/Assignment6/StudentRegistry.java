package Assignment6;
class Students{
    private static int totalStudents=0;
    private int studentID;
    private String studentName;
    public Students(String studentName){
        totalStudents++;
        this.studentName=studentName;
        this.studentID=totalStudents;
    }
    public void displayStudent(){
        System.out.println("Student id: "+studentID + ", Name: "+ studentName);
    }
    public static void displayTotalStudent(){
        System.out.println("Total number of student: "+ totalStudents);
    }
}
public class StudentRegistry{
    public static void main(String[] args) {
        Students s1= new Students("Harshita");
        Students s2= new Students("Harshit");
        Students s3= new Students("Harshi");
        Students s4= new Students("Harsha");
        s1.displayStudent();
        s2.displayStudent();
        s3.displayStudent();
        s4.displayStudent();
        Students.displayTotalStudent();
    }
}
