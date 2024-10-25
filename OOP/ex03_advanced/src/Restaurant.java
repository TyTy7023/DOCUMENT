import java.util.ArrayList;
import java.util.Scanner;

public class Restaurant extends Information {
    static Scanner input = new Scanner(System.in);
    static private ArrayList<MenuItem> menu = new ArrayList<MenuItem>();
    public void enterInfo() {
        System.out.println("Enter the name of the restaurant: ");
        setName(input.nextLine());
        System.out.println("Enter the address of the restaurant: ");
        setAddress(input.nextLine());
        System.out.println("Enter the phone number of the restaurant: ");
        setPhone(input.nextLine());
    }
    public static class Management {
        public Management(){};
        public void addItemMenu(ArrayList<MenuItem> menu) {
            MenuItem item = new MenuItem();
            System.out.print("Enter the name of items you want to add: "); item.setName(input.nextLine());
            System.out.print("Enter the price of items you want to add: "); item.setPrice(input.nextLine());
            System.out.print("Enter the description of items you want to add: "); item.setDescription(input.nextLine());
            menu.add(new MenuItem(item));
        }
        public void deleteItemMenu(ArrayList<MenuItem> menu) {
            int choose=1,pos=-1; 
            while (choose!=0) 
            {
                System.out.print("Enter the name of the item you want to update: ");
                String name = input.nextLine();
                // find position of item
                for (int i=0;i<menu.size();i++) 
                    if(menu.get(i).getName().equals(name)) {   pos = i;break;  }
                // check and remove
                if(pos==-1)
                    System.out.println("Item not found");
                else 
                {
                    menu.remove(pos);
                    System.out.println("\t\t REMOVE UPDATED SUCCESSFULLY");
                }
                System.out.print("Do you want to update another item? (1:yes/0:no) ? : "); choose = input.nextInt();
                while (choose!=1 && choose!=0) 
                {
                    System.out.print("Invalid input, please enter again: ");choose = input.nextInt();
                    pos=-1;
                }
            }
        }
        public void updateItemMenu(ArrayList<MenuItem> menu) {
           Chef chef = new Chef();
              chef.updateItem(menu);
        }
        public void addItemOrder(Order menu) {
            Waiter waiter = new Waiter();
            waiter.addItem(menu);
        }
        public void deleteItemOrder(Order menu) {
            Waiter waiter = new Waiter();
            waiter.deleteItem(menu);
        }
        public void totalBill(Order menu) {
            int total=0;
            for (int i=0;i<menu.getItemsList().size();i++) 
                total+=Integer.parseInt(menu.getItemsList().get(i).getPrice());
            System.out.println("Total bill: "+total+"$");
        }
    }
    
     
}