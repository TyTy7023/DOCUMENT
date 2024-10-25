import java.util.ArrayList;
public class Chef extends Customer {
    public void addItem(ArrayList<MenuItem> menu)
    {
       Restaurant.Management management = new Restaurant.Management();
       management.addItemMenu(menu);
    }
    public void deleteItem(ArrayList<MenuItem> menu)
    {
        System.out.println("Chef can't delete item");
    }
    public void updateItem(ArrayList<MenuItem> menu)
    {
        int choose=1,pos=-1; 
        while (choose!=0) 
        {
            System.out.print("Enter the name of the item you want to update: ");
            String name = input.nextLine();
            // find position of item
            for (int i=0;i<menu.size();i++) 
                if(menu.get(i).getName().equals(name)) {   pos = i;break;  }
            // check and update
            if(pos==-1)
                System.out.println("Item not found");
            else 
            {
                System.out.println("Enter the new details of the item");
                System.out.println("Enter name: "); menu.get(pos).setName(input.nextLine());
                System.out.println("Enter price: "); menu.get(pos).setPrice(input.nextLine());
                System.out.println("Enter description: "); menu.get(pos).setDescription(input.nextLine());
                System.out.println("\t\tmenu UPDATED SUCCESSFULLY");
            }
            System.out.print("Do you want to update another item? (1:yes/0:no) ? : "); choose = input.nextInt();
            while (choose!=1 && choose!=0) 
            {
                System.out.print("Invalid input, please enter again: ");choose = input.nextInt();
                pos=-1;
            }
        }
    }
}
