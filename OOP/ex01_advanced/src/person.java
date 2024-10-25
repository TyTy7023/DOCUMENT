import java.util.Scanner;

public class person {
    private String fullname, address;
    Scanner input = new Scanner(System.in);
    //setter
    public void setAddress(String address) 
    {
        this.address = address;
    }
    public void setFullname(String fullname) 
    {
        this.fullname = fullname;
    }
    //setter
    public String getAddress() 
    {
        return address;
    }
    public String getFullname() 
    {
        return fullname;
    }
    //input
    public void register() 
    {
        System.out.print("Enter your fullname: "); fullname= input.nextLine();
        System.out.print("Enter your address: "); address= input.nextLine();
    }
    //output
    public void showCustomer() 
    {
        System.out.println("Fullname: " + fullname);
        System.out.println("Address: " + address);
    }
    public void printlnVoice(){};
}
