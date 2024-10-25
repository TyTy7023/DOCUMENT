import java.util.Scanner;

public class Customer extends person {
    private String  phone;
    Scanner input = new Scanner(System.in);
    //setter
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }
    //getter
    public String getPhone() {
        return phone;
    }
    //input
    public void registerCustomer() 
    {
        register();
        System.out.print("Enter your phone: "); phone= input.nextLine();
    }
    //output
    public void showCustomer() 
    {
        register();
        System.out.println("Phone: " + phone);
    }
    public void addProductToCart(Product product, int quantity, Cart cart) 
    {
        Product temp= new Product(product.getName(),product.getPrice(),product.getDescription(),product.getQuantity());
        
        cart.addProduct(temp, quantity);
        cart.setQuantity(quantity);
        product.setQuantity(product.getQuantity() - quantity);
    }
    public void removeProductFromCart(Product product,int quantity, Cart cart) 
    {
        cart.removeProduct(product);
        product.setQuantity(product.getQuantity() + quantity);
    }
    public void showCart(Cart cart)
    {
        System.out.println("\t\tYOUR CART");
        for (int i = 0; i < cart.getListProducts().size(); i++) 
        {
            System.out.println("\tProduct " + (i + 1));
            cart.getListProducts().get(i).printProduct();
            System.out.println();
        }
    }
    public void Order(Cart cart, Order order) 
    {
        if(cart.getListProducts().size()==0)
        {
            System.out.println("THERE IS NO PRODUCTION IN CART");
            return;
        }
        for (int i = 0; i < cart.getListProducts().size(); i++)
            order.addProduct(cart.getListProducts().get(i));
        System.out.println("\tORDER SUCCESSFULLY");
    }
    public void historyOrder(Order order) 
    {
        System.out.println("\tYOUR ORDER");
        order.showHisOrder();
    }
    public void printlnVoice(Order order)
    {
        System.out.println("\t\tName: "+ getFullname());
        order.printlnVoice();
    }

}
