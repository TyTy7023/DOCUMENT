import java.util.Scanner;

public class Customer extends Information {
     Scanner input = new Scanner(System.in);
    
       //methods
    public void enterInfo(){
        System.out.print("Enter the name of the customer: "); setName(input.nextLine());
        System.out.print("Enter the address of the customer: "); setAddress(input.nextLine());
        System.out.print("Enter the phone number of the customer: "); setPhone(input.nextLine());
    }
    public void printInfo(){
        System.out.println("Name: " + getName());
        System.out.println("Address: " + getAddress());
        System.out.println("Phone: " + getPhone());
    }
}
