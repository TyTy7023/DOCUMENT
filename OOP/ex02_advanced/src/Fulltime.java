public class Fulltime extends Employee{
    private int dayWorked, salary;
    
    public Fulltime() {}
    public Fulltime (Fulltime fulltime) {
        super(fulltime.getName(), fulltime.getId(), fulltime.getSalaryCoefficient());
        this.dayWorked = fulltime.dayWorked;
        this.salary = fulltime.salary;
    }
    //setters
    public void setDayWorked(int dayWorked) {
        this.dayWorked = dayWorked;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    //getters
    public int getDayWorked() {
        return dayWorked;
    }
    public int getSalary() {
        return salary;
    }
    //method
    public void enterInfoFull() {
        enterInfo();
        System.out.print("Enter dayWorked: "); dayWorked=input.nextInt();
        salary = dayWorked * getSalaryCoefficient();
    }
    public void printInfoFull() {
        printInfo();
        System.out.println("DayWorked: " + dayWorked);
        System.out.println("Salary: " + salary);
    }
    
    public void salary()
    {
        salary = dayWorked * getSalaryCoefficient();
    }
}
