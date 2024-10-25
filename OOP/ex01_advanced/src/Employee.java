public class Employee extends person {

    public void registerEmployee()
    {
        register();
    }
    public void printlnVoice(Customer[] customers, Order[] orders)
    {
        for(int i=0;i<customers.length;i++)
        {
            System.out.println("\t\tCustomer "+i+1+"\tName: "+customers[i].getFullname());
            System.out.println("The customer's order: ");
            orders[i].printlnVoice();
            System.out.println();
        }
    }
    
}
