import java.util.ArrayList;
import java.util.Scanner;

public class Order{
    Scanner input=new Scanner(System.in);
    private ArrayList<Product> listProducts;  
    private ArrayList<Product> hisListProducts;  
    private Customer information;
    
    public Order() {
        listProducts = new ArrayList<Product>();
        information = new Customer();
        hisListProducts = new ArrayList<Product>();
    }
    //getter
    public ArrayList<Product> getListProducts() {
        return listProducts;
    }
    public Customer getInformation() {
        return information;
    }
    public ArrayList<Product> getHisListProducts() {
        return hisListProducts;
    }
    //setter
    public void setListProducts(ArrayList<Product> listProducts) {
        this.listProducts = listProducts;
    }
    public void setInformation(Customer information) {
        this.information = information;
    }
    //method
    public void addProduct(Product product) {
        listProducts.add(product);
    }
    public void removeProduct(Product product) {
        int index = listProducts.indexOf(product);
        listProducts.remove(index);
    }
    public void showOrder()
    {
        for(int i=0;i<listProducts.size();i++)
        {
            if(listProducts.size()>1) System.out.println("\t\tProduct "+(i+1));
            System.out.println("Product: "+listProducts.get(i).getName());
            System.out.println("Price: "+listProducts.get(i).getPrice());
            System.out.println("Quantity: "+listProducts.get(i).getQuantity());
        }
    }
    public void confirmOrder(Product[] product)
    {
        if(listProducts.size()==0)
        {
            System.out.println("THERE IS NO PRODUCTION IN ORDER");
            return;
        }
        int choose;
        System.out.println("\t\tYOUR INFORMATION");
        System.out.println("Fullname: "+information.getFullname());
        System.out.println("Address: "+information.getAddress());
        System.out.println("Phone: "+information.getPhone());
        System.out.println("\t\tYOUR ORDER"); showOrder();
        System.out.print("\tDO YOU CONFIRM YOUR ORDER (1.YES || 2.NO)\nEnter your choose: "); choose=input.nextInt();
        while (choose!=-1) 
        {
            switch (choose) {
                case 2:
                {
                    changeOrder(product);
                    confirmOrder(product);
                    choose=-1;
                    break;
                }
                case 1:
                {
                    choose=-1;
                   // for(int i=0;i<listProducts.size();i++)
                  //  {
                        for (Product pr : listProducts) {
                            hisListProducts.add(new Product(pr));
                    }
                    System.out.println("\t\tYOUR ORDER CONFIRMATION WAS SUCCESSFUL!");
                    break;
                  //  }
                }
                default:
                {
                    System.out.println("Incorrect, please enter again : ");
                    choose=input.nextInt();
                }
            }
        }
    }
    public void printlnVoice()
    {
        if(listProducts==null)
        {
            System.out.println("THERE IS NO PRODUCTION IN ORDER");
            return;
        }
        System.out.println("\t\tVOICE");
        System.out.println("Fullname: "+information.getFullname());
        System.out.println("Address: "+information.getAddress());
        System.out.println("Phone: "+information.getPhone());
        showOrder();
        int sum=0;
        for(int i=0;i<listProducts.size();i++)
            sum=sum+(listProducts.get(i).price*listProducts.get(i).getQuantity());
        System.out.println("Total of bill : "+ sum +"$"); 
    }
    public void changeOrder(Product[] product)
    {
        
        int choose=0, quantity, count=0;
        String name;
        System.out.println("\tWhat do you want to changes");
        System.out.println("1. Add production\n2. Delete production\n0.Exit");
        System.out.print("Enter your choose: "); choose=input.nextInt();
        while (choose!=0) 
        {
            switch (choose) 
            {
                case 1:
                {
                    int num;
                    System.out.println("How many production do you want to add to order?");
                    System.out.print("Enter your number: "); num=input.nextInt();
                    input.nextLine();
                    for(int j=0;j<num;j++)
                    {
                        System.out.println("ADD ROUND "+j+1);
                        System.out.print("Enter the name of production you want to add: "); name=input.nextLine();
                        System.out.println("Enter the quantity you want to add: "); quantity=input.nextInt();
                        for(int i=0; i<product.length;i++)
                            if(product[i].getName().equals(name)) 
                            {
                                if(productInList(product[i])!=null)
                                    productInList(product[i]).setQuantity(productInList(product[i]).getQuantity()+quantity);
                                else
                                {
                                    addProduct(product[i]);
                                    productInList(product[i]).setQuantity(quantity);
                                    product[i].setQuantity(product[i].getQuantity()-quantity);
                                }
                                count++;
                            }
                        if (count==0) 
                        {
                          System.out.println("\tThe name of production is incorrect !");  
                          System.out.println("Do you want to enter again ? (1.yes || .no)");
                          System.out.print("Enter your choose"); choose=input.nextInt();
                          if(choose==1) j--;
                        }
                    }
                    choose=0;
                    break;
                }
                case 2:
                {
                    int num;
                    System.out.println("How many production do you want to delete in order?");
                    System.out.print("Enter your number: "); num=input.nextInt();
                    input.nextLine();
                    for(int j=0;j<num;j++)
                    {
                        System.out.println("\t\tDELETE ROUND "+j+1);
                        System.out.print("Enter the name of production you want to delete: "); name=input.nextLine();
                        System.out.println("Are you want to delete all quantity ?");
                        System.out.println("Enter the quantity you want to delete: "); quantity=input.nextInt();
                        for(int i=0; i<product.length;i++)
                            if(product[i].getName().equals(name)) 
                            {
                                if(productInList(product[i])!=null)
                                {
                                    productInList(product[i]).setQuantity(productInList(product[i]).getQuantity()-quantity);
                                    product[i].setQuantity(product[i].getQuantity()+quantity);
                                    if(productInList(product[i]).getQuantity()==0) removeProduct(product[i]);                                    
                                }
                                count++;
                            }
                        if (count==0) 
                        {
                          System.out.println("\tThe name of production is incorrect !");  
                          System.out.println("Do you want to enter again ? (1.yes || 2.no)");
                          System.out.print("Enter your choose"); choose=input.nextInt();
                          if(choose == 1) j--;
                        }
                    }
                    choose=0;
                    break;
                }
                default:
                    System.out.println("Incorrect, please enter again : ");
                    choose=input.nextInt();
                    break;
            }
        }
    }
    public void showHisOrder()
    {
        for(int i=0;i<hisListProducts.size();i++)
        {
            if(hisListProducts.size()>1) System.out.println("\t\tProduct "+(i+1));
            System.out.println("Product: "+hisListProducts.get(i).getName());
            System.out.println("Price: "+hisListProducts.get(i).getPrice());
            System.out.println("Quantity: "+hisListProducts.get(i).getQuantity());
            
        }
    }
    public Product productInList(Product product)
    {
        return listProducts.get(listProducts.indexOf(product));
    }
}
