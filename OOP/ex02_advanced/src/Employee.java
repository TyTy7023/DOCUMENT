import java.util.Scanner;
public abstract class Employee{
    Scanner input = new Scanner(System.in);
    private String name, id;
    private int salaryCoefficient;
    private int salary;

    public Employee() {}
    public Employee(String name, String id, int salaryCoefficient) {
        this.name = name;
        this.id = id;
        this.salaryCoefficient = salaryCoefficient;
    }
    //setters
    public void setName(String name) {
        this.name = name;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setSalaryCoefficient(int salaryCoefficient) {
        this.salaryCoefficient = salaryCoefficient;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    //getters
    public String getName() {
        return name;
    }
    public String getId() {
        return id;
    }
    public int getSalaryCoefficient() {
        return salaryCoefficient;
    }
    public int getSalary() {
        return salary;
    }
    //method
    public abstract void salary();
    public void enterInfo() {
        System.out.print("Enter name: "); name=input.nextLine();
        System.out.print("Enter id: "); id=input.nextLine();
        System.out.print("Enter salaryCoefficient: "); salaryCoefficient=input.nextInt();
    }
    public void printInfo() {
        System.out.println("Name: " + name);
        System.out.println("Id: " + id);
        System.out.println("SalaryCoefficient: " + salaryCoefficient);
    }
}