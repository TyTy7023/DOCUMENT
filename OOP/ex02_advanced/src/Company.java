import java.util.ArrayList;
import java.util.Scanner;

public class Company {
    Scanner input = new Scanner(System.in);
    static private ArrayList<Employee> employees = new ArrayList<Employee>();
    
    public void addParttime()
    {
        System.out.println("\tHow many parttime employees do you want to add? ");
        System.out.print("Enter number: ");int num = input.nextInt();
        for(int i=0; i<num; i++)
        {
            System.out.println("\t\tEnter information of parttime employee " + (i+1) + ": ");
            Parttime parttime = new Parttime();
            parttime.enterInfoPart();
            employees.add(new Parttime(parttime));
        }
        
    }
    public void addFulltime()
    {
        System.out.println("\tHow many fulltime employees do you want to add? ");
        System.out.print("Enter number: ");int num = input.nextInt();
        for(int i=0; i<num; i++)
        {
            System.out.println("\t\tEnter information of fulltime employee " + (i+1) + ": ");
            Fulltime fulltime = new Fulltime();
            fulltime.enterInfoFull();
            employees.add(new Fulltime(fulltime));
        }
        
    }
    public void addBoth()
    {
        addFulltime();
        addParttime();
    }
    public int totalSalary()
    {
        int sum=0;
        for(int i=0; i<employees.size(); i++)
            sum+=employees.get(i).getSalary();
        return sum;
    }
    public void searchInfo(String id)
    {
        for(int i=0; i<employees.size(); i++)
        {
            if(employees.get(i).getId().equals(id))
            {
                if(employees.get(i) instanceof Parttime)
                {
                    System.out.println("FULLTIME EMPLOYEE: ");
                    ((Parttime)employees.get(i)).printInfo();
                    
                }   
                else if(employees.get(i) instanceof Fulltime)
                {
                    System.out.println("PARTTIME EMPLOYEE: ");
                    ((Fulltime)employees.get(i)).printInfo();
                }
                break;
            }
            if(i==employees.size()-1)
                System.out.println("NOT FOUND!");
        }
    }
    public static class manageEmployee
    {
        public void printEmployee()
        {
            for(Employee enployee: employees)
            {
                if(enployee instanceof Parttime)
                {
                    System.out.println("\tFULLTIME EMPLOYEE: ");
                    ((Parttime)enployee).printInfo();
                    
                }   
                else if(enployee instanceof Fulltime)
                {
                    System.out.println("\tPARTTIME EMPLOYEE: ");
                    ((Fulltime)enployee).printInfo();
                }
                System.out.println();
            }
           
        }
    }
}
