import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        Company company = new Company();
        System.out.println("------------WELCOME TO COMPANY MANAGEMENT SYSTEM------------");
        System.out.println("------------LET'S START WITH ADDING EMPLOYEES:------------");
        company.addBoth();
        System.out.println("------------LIST OF EMPLOYEES:------------");
        Company.manageEmployee manage=new Company.manageEmployee();
        manage.printEmployee();
        int choose=1;
        while (choose!=0) 
        {
            System.out.println("\t\tWHAT DO YOU WANT TO DO?");
            System.out.println("1. Add employee");
            System.out.println("2. Total salary");
            System.out.println("3. Search employee");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: "); choose=input.nextInt();
            while (choose<0 || choose>3) 
            {
                System.out.println("Invalid choice! Please choose again!");
                System.out.print("Enter your choice: "); choose=input.nextInt();
            }
            switch (choose) {
                case 1:
                {
                    System.out.println("------------ADD EMPLOYEE:------------");
                    System.out.println("1. Add fulltime employee");
                    System.out.println("2. Add parttime employee");
                    System.out.println("3. Add bold employee");
                    System.out.println("0. Exit");
                    System.out.print("Enter your choice: "); choose=input.nextInt();
                    while (choose<0 || choose>3) 
                    {
                        System.out.println("Invalid choice! Please choose again!");
                        System.out.print("Enter your choice: "); choose=input.nextInt();
                    }
                    switch (choose) {
                        case 1:
                        {
                            company.addFulltime();
                            break;
                        }
                        case 2:
                        {
                            company.addParttime();
                            break;
                        }
                        case 3:
                        {
                            company.addBoth();
                            break;
                        }
                        case 0:
                        {
                            break;
                        }
                    }
                    break;
                }
                case 2:
                {
                    System.out.println("------------TOTAL SALARY:------------");
                    System.out.println("Total: "+company.totalSalary());
                    break;
                }
                case 3:
                {
                    System.out.println("------------SEARCH EMPLOYEE:------------");
                    System.out.println("Enter id: "); input.nextLine();
                    String id = input.nextLine();
                    company.searchInfo(id);
                    break;
                }                
            }
        }
        input.close();
    }
}
