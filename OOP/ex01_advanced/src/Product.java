import java.util.Scanner;

public class Product {
    final String name, description;
    final int price;
    private int quantity;
    Scanner input = new Scanner(System.in);
    
    public Product(String name, int price, String description, int quantity) 
    {
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
    }
    public Product(Product product)
    {
        this.name =product. name;
        this.price = product.price;
        this.description = product.description;
        this.quantity =product. quantity;
        
    }
    //getter
    public String getDescription() 
    {
        return description;
    }
    public String getName() 
    {
        return name;
    }
    public int getPrice() 
    {
        return price;
    }
    public int getQuantity() 
    {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public void printProduct() 
    {
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Description: " + description);
        System.out.println("Quantity: " + quantity);
    }
}
