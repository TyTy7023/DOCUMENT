import java.util.Scanner;

public class MenuItem {
    Scanner input = new Scanner(System.in);
    private String name, price, description;
    public MenuItem(){}
    public MenuItem(MenuItem item){
        this.name = item.name;
        this.price = item.price;
        this.description = item.description;
    }
    //setters
    public void setDescription(String description) {
        this.description = description;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    //getters
    public String getDescription() {
        return description;
    }
    public String getName() {
        return name;
    }
    public String getPrice() {
        return price;
    } 
    //methods
    public void enterInfo(){
        System.out.print("Enter the name of the menu item: "); name = input.nextLine();
        System.out.print("Enter the price of the menu item: "); price = input.nextLine();
        System.out.print("Enter the description of the menu item: "); description = input.nextLine();
    }
    public void printInfo(){
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Description: " + description);
    }
    public void addItem(MenuItem item)
    {
        System.out.print("Enter the name of the menu item: "); name = input.nextLine();
        System.out.print("Enter the price of the menu item: "); price = input.nextLine();
        System.out.print("Enter the description of the menu item: "); description = input.nextLine();
    }
}
