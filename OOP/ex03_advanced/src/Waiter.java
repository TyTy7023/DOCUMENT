public class Waiter extends Customer implements Orderable {
    public void addItem(Order menu) {
        
        MenuItem item = new MenuItem();
        System.out.print("Enter the name of menu you want to add: "); item.setName(input.nextLine());
        System.out.print("Enter the price of menu you want to add: "); item.setPrice(input.nextLine());
        System.out.print("Enter the description of menu you want to add: "); item.setDescription(input.nextLine());
        menu.addOrder(item);
        System.out.println("\t\t ORDER ADDED SUCCESSFULLY");
    }
    public void deleteItem(Order menu) {
        int choose=1,pos=-1;
        while (choose!=0) 
        {
            System.out.print("Enter the name of the item you want to update: ");
            String name = input.nextLine();
            // find position of item
            for (int i=0;i<menu.getItemsList().size();i++) 
                if(menu.getItemsList().get(i).getName().equals(name)) {   pos = i;break;  }
            // check and remove
            if(pos==-1)
                System.out.println("Item not found");
            else 
            {
                menu.getItemsList().remove(pos);
                System.out.println("\t\t ORDER REMOVED SUCCESSFULLY");
            }
            System.out.print("Do you want to update another item? (1:yes/0:no) ? : "); choose = input.nextInt();
            while (choose!=1 && choose!=0) 
            {
                System.out.print("Invalid input, please enter again: ");choose = input.nextInt();
                pos=-1;
            }
        }
    }
    public void totalBill(Order menu) {}
    
}
