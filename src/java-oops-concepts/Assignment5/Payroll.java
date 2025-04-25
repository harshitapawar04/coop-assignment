package Assignment5;
abstract class Employee{
    protected String empName;
    protected int empID;
    protected double salary;
    public Employee(String empName, int empID ){
        this.empName=empName;
        this.empID=empID;
    }
    abstract void empDetails();
    abstract double calculateSalary();
}
 class FulltimeEmployee extends Employee{
    double salaryOfFTE;
    public FulltimeEmployee(String empName, int empID , double salaryOfFTE){
        super(empName,empID);
        this.salaryOfFTE=salaryOfFTE;
    }


    @Override
    double calculateSalary(){
      salary=salaryOfFTE;
      return salary;
    }
    @Override
     void empDetails(){
        calculateSalary();
        System.out.println("Details of full time employee");
        System.out.println("Employee Name: " + empName);
        System.out.println("Employee ID: " + empID);
        System.out.println("Employee Salary: " + salary);
     }
}
class Freelancer extends Employee{
    double hourlyRate;
     int hoursWorked;
    public Freelancer(String empName, int empID , double hourlyRate,int hoursWorked){
        super(empName,empID);
        this.hourlyRate=hourlyRate;
        this.hoursWorked=hoursWorked;
    }

    @Override
    double calculateSalary(){
        salary=hourlyRate*hoursWorked;
        return salary;
    }
    @Override
    void empDetails(){
        calculateSalary();
        System.out.println("Details of full time employee");
        System.out.println("Employee Name: " + empName);
        System.out.println("Employee ID: " + empID);
        System.out.println("Employee Salary: " + salary);
    }
}
public class Payroll{
    public static void main(String[] args) {
        FulltimeEmployee fte = new FulltimeEmployee("Harshita",23557,35700);
        Freelancer freelancer = new Freelancer("Harshit",244421,400,40);
        fte.empDetails();
        System.out.println();
        freelancer.empDetails();
    }
}

