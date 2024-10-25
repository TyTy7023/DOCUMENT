import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception 
    {
        Scanner input=new Scanner(System.in);
        Product[] products= new Product[5]; insertProduct(products);
        int num;
        System.out.println("\t\tHow many customers want to shopping");
        System.out.print("enter number: "); num=input.nextInt();
        input.nextLine();
        Customer[] customers=new Customer[num];
        Order[] orders=new Order[num];
        Cart[] carts = new Cart[num];
        int next=1;
        
        for(int i=0;i<num;i++)
        {
            customers[i] =new Customer();
            System.out.println("\tCustomer "+i+1);
            customers[i].registerCustomer();
            orders[i]=new Order();
            orders[i].setInformation(customers[i]);
            carts[i] = new Cart();
            System.out.println("FINISH REGISTER FOR CUSTOMER "+(i+1)+"\n");
        }
        while (next!=0) 
        {
            System.out.println("\t\tLIST OF CUSTOMERS:");
            for(int i=0;i<num;i++)
                System.out.println(""+(i+1)+". Name of customer: " +customers[i].getFullname());
            System.out.println("\tWHO ARE YOU");
            System.out.print("Enter your choose (ex: 1): "); int choose=input.nextInt();
            while(choose<1 || choose >num)
            {
                System.out.print("Your choose is incorrect, please enter again: ");
                choose=input.nextInt();
            }
            int temp=choose-1;
            choose=1;
            while (choose!=2) 
            {
                System.out.println("\t\tWHAT DO YOU WANT TO DO ?");
                System.out.println("1.Add production to cart\n2.Print History order\n3.Order\n0.exit");
                System.out.print("Enter your choose: ");
                choose=input.nextInt(); 
                while (choose>4 || choose<0) 
                {
                    System.out.print("your choose is incorrect, please enter again :"); 
                    choose=input.nextInt();
                    input.nextLine();
                }
                switch (choose) {
                    case 2:
                    {
                        System.out.println("\t\tHISTORY ORDER");
                        customers[temp].historyOrder(orders[temp]);
                        break;
                    }
                    case 1:
                    {
                        for(int i=0;i<products.length;i++)
                        {
                            System.out.println("\t\tProduction "+(i+1));
                            products[i].printProduct();
                        }
                        System.out.print("\tHow many production you want to add to cart\n Enter number: "); int n=input.nextInt();
                        input.nextLine();
                        for(int i=0;i<n;i++)
                        {
                            System.out.print("What is the number's product you want to add(ex: 1): "); int id=input.nextInt();
                            while (id<1 || id>products.length) 
                            {
                                System.out.print("your choose is incorrect, please enter again :"); 
                                id=input.nextInt();
                                input.nextLine();
                            }
                            System.out.print("how many the quantity you want to add(ex: 1): "); int quantity=input.nextInt(); 
                            input.nextLine();
                            customers[temp].addProductToCart(products[id], quantity, carts[temp]);                            
                            System.out.println("\t\t\tAdded the production "+ products[id].getName()+" to your cart");
                        }
                        customers[temp].showCart(carts[temp]);
                        System.out.println("FINISH SHOPPING");
                        System.out.print("Do you want to continue to order (1.YES || 2.NO) : "); int choose1=input.nextInt();
                        while (choose1!=1 && choose1!=2) 
                        {
                            System.out.print("your choose is incorrect, please enter again :"); 
                            choose1=input.nextInt();
                            input.nextLine();   
                        }
                        if(choose1==2) break;
                    }
                    case 3:
                    {
                        if (carts[temp].getListProducts().size()==0 && orders[temp].getHisListProducts().size()==0) 
                        {
                            System.out.println("\t\tTHERE IS NO PRODUCTION IN HISORDER");
                            break;
                        }
                        customers[temp].Order(carts[temp],orders[temp]);
                        orders[temp].confirmOrder(products);
                        
                        System.out.println("\n\t\tTHERE IS YOUR BILL");
                        orders[temp].printlnVoice();
                        for(int i=0;i<carts.length;i++)
                        {
                            carts[temp].removeProduct(carts[temp].getListProducts().get(i));
                            orders[temp].removeProduct(orders[temp].getListProducts().get(i));
                        }
                        break;
                    }
                }
                System.out.println("\t\tDO YOU WANT TO CONTINUE (1.YES || 2.NO)");
                System.out.print("Enter your choose: "); choose=input.nextInt();
            }
            System.out.println("\t\tDO YOU WANT TO CONTINUE WITH ANOTHER CUSTOMER (1.YES || 0.NO)");
            System.out.print("Enter your choose: "); next=input.nextInt(); 
        }
        
        input.close();
    }
    public static void insertProduct(Product[] products)
    {
        products[0]=new Product("candy",1,"sweet",100);
        products[2]=new Product("phone",100,"sweet",100);
        products[3]=new Product("serum",20,"sweet",100);
        products[4]=new Product("shoes",16,"sweet",100);
        products[1]=new Product("hair",5000,"sweet",100);
    }
}
