import java.util.Scanner;
public class Parttime extends Employee{

    Scanner input = new Scanner(System.in);
    private int hourWorked, salary;
    
    public Parttime() {super();}
    public Parttime (Parttime parttime) {
        super(parttime.getName(), parttime.getId(), parttime.getSalaryCoefficient());
        this.hourWorked = parttime.hourWorked;
        this.salary = parttime.salary;
    }
    
    //setters
    public void setHourWorked(int hourWorked) {
        this.hourWorked = hourWorked; 
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    //getters
    public int getHourWorked() {
        return hourWorked;
    }
    public int getSalary() {
        return salary;
    }
    //method
    public void enterInfoPart() {
        enterInfo();
        System.out.print("Enter hourWorked: "); hourWorked=input.nextInt();
        salary = hourWorked * getSalaryCoefficient();
    }
    public void printInfoPart() {
        printInfo();
        System.out.println("hourWorked: " + hourWorked);
        System.out.println("Salary: " + salary);
    }
    public void salary()
    {
        salary = hourWorked * getSalaryCoefficient();
    }
}
